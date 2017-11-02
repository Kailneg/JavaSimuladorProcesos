package algoritmos;

import java.util.ArrayList;

import models.InformacionCicloCPU;
import models.Proceso;

public abstract class GestorProceso {
	
	protected ArrayList<Proceso> listaProcesosInicial;
	protected ArrayList<Proceso> colaProcesos;
	protected Proceso procesoActual;
	protected int cicloCPU;

	public GestorProceso(ArrayList<Proceso> listaProcesos) {
		this.listaProcesosInicial = listaProcesos;
		colaProcesos = new ArrayList<>();
		cicloCPU = 0;
		procesoActual = seleccionarProceso();
	}
	
	/**
	 * Simula la ejecución de un ciclo de procesamiento de CPU.
	 * @return devuelve un objeto InformacionCicloCPU
	 * con toda la información relacionada con el ciclo que se acaba de ejecutar.
	 */
	public InformacionCicloCPU cicloProcesamiento() {
		// Orden del procesamiento
		// Busco por nuevos que hayan entrado > selecciono > proceso
		buscarNuevosProcesos();
		procesoActual = seleccionarProceso();
		return ejecutarProceso();
	}
	
	/**
	 * Busca por nuevos procesos que entren justo en ese ciclo de CPU,
	 * para introducirlos en la cola de procesamiento.
	 */
	protected void buscarNuevosProcesos() {
		// Añado a la cola los procesos que hayan llegado en el nuevo ciclo de CPU
		for (Proceso proceso : listaProcesosInicial) 
			// No seguir si el proceso ya está en la cola (comprobación seguridad)
			if (!colaProcesos.contains(proceso) && proceso.getLlegada() == cicloCPU)
				colaProcesos.add(proceso);		
		
		// Elimina de la lista inicial todos los procesos que 
		// hayan podido entrar en la cola de procesamiento.
		listaProcesosInicial.removeAll(colaProcesos);
	}

	/**
	 * Selecciona un proceso para ejecutarlo.
	 * Depende de la implementación en el algoritmo
	 * @return el proceso que se debe ejecutar en el ciclo de CPU actual.
	 */
	protected abstract Proceso seleccionarProceso();
	
	/**
	 * Ejecuta un ciclo del proceso actual, si existe un proceso ejecutable
	 * disponible para ese ciclo de CPU. Será igual para todos.
	 * @return devuelve un objeto tipo InformacionCicloCPU con
	 * toda la información sobre el procesamiento
	 */
	protected InformacionCicloCPU ejecutarProceso() {
		InformacionCicloCPU iCPU;
		if (procesoActual != null) {
			// Seteando el momento de entrada a ejecución del proceso,
			// en caso de que sea la primera vez que entra.
			if (procesoActual.getCicloEntrada() == -1) {
				procesoActual.setCicloEntrada(cicloCPU);
			}
			// Entonces procesamos y guardamos los parametros
			procesoActual.procesar();	
			iCPU = new InformacionCicloCPU(procesoActual, cicloCPU, colaProcesos);
			
			// Si al proceso actual no le quedan ciclos restantes, entonces eliminar de la cola.
			// Y setear el proceso actual a null
			if (!procesoActual.tieneCargaRestante()){
				colaProcesos.remove(procesoActual);
				procesoActual = null;
			}
			
			// Ha existido un proceso y se ha ejecutado
		} else {
			iCPU = new InformacionCicloCPU(null, cicloCPU, colaProcesos); // No ha habido proceso para ejecutarse
		}
		cicloCPU++;
		return iCPU;
	}
	
	/**
	 * Devolvera si quedan procesos pendientes que se ejecutarán en un futuro.
	 * @return true si listaProcesosInicial o colaProcesos tienen procesos.
	 */
	public boolean quedaTrabajo() { 
		return !colaProcesos.isEmpty() || !listaProcesosInicial.isEmpty(); 
	};
}
