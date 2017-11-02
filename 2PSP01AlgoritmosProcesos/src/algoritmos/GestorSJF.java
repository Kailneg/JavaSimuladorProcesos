package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorSJF extends GestorProceso {

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
