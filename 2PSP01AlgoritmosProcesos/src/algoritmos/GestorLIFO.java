package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorLIFO extends GestorProceso {

	/**
	 * Crea un nuevo gestor que usará el algoritmo <b>LIFO</b> para ejecutar los
	 * procesos que se le pasen.
	 * 
	 * @param listaProcesos
	 *            la lista que se procesará
	 */
	public GestorLIFO(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	/**
	 * Según Last In First Out, se elige el último proceso que llegó. 
	 * No es apropiativo
	 * 
	 * @return el proceso que se debe ejecutar en este ciclo de CPU.
	 */
	@Override
	protected Proceso seleccionarProceso() {
		// No apropiativo, comprobamos que no haya uno ya ejecutándose.
		if (procesoActual != null)
			return procesoActual;
		
		// Obtiene el último de la cola temporal
		if (!colaProcesos.isEmpty())
			return colaProcesos.get(colaProcesos.size() - 1); 
		
		return null; // Si no existen procesos actualmente en la cola temporal
	}

}
