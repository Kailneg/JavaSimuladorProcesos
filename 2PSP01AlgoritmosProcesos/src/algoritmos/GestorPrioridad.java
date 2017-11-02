package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorPrioridad extends GestorProceso {

	/**
	 * Crea un nuevo gestor que usará el algoritmo de <b>prioridad</b> para
	 * ejecutar los procesos que se le pasen.
	 * 
	 * @param listaProcesos
	 *            la lista que se procesará
	 */
	public GestorPrioridad(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	/**
	 * Según algoritmo de prioridades, se elige, de manera apropiativa, al
	 * proceso con mayor prioridad
	 * 
	 * @return el proceso que se debe ejecutar en este ciclo de CPU.
	 */
	@Override
	protected Proceso seleccionarProceso() {

		if (!colaProcesos.isEmpty()) {
			// Ordena cola por más prioritarios y devuelve el primero
			colaProcesos.sort((Proceso o1, Proceso o2) -> o1.getPrioridad().compareTo(o2.getPrioridad()));
			return colaProcesos.get(0);
		}
		return null; // Si no existen procesos actualmente en la cola temporal
	}

}
