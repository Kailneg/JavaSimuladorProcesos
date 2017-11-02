package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorSJF extends GestorProceso {

	/**
	 * Crea un nuevo gestor que usar� el algoritmo <b>SJF</b> para ejecutar los
	 * procesos que se le pasen.
	 * 
	 * @param listaProcesos
	 *            la lista que se procesar�
	 */
	public GestorSJF(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	/**
	 * Seg�n Shorter Job First(SJF), se elige primero al proceso m�s corto. 
	 * No es apropiativo
	 * 
	 * @return el proceso que se debe ejecutar en este ciclo de CPU.
	 */
	@Override
	protected Proceso seleccionarProceso() {

		if (procesoActual != null)
			return procesoActual;

		if (!colaProcesos.isEmpty()) {
			// Ordenar cola por m�s cortos y devolver el primero
			colaProcesos.sort((Proceso o1, Proceso o2) -> o1.getCargaRestante() - o2.getCargaRestante());
			return colaProcesos.get(0);
		}

		return null; // Si no existen procesos actualmente en la cola temporal.
	}

}
