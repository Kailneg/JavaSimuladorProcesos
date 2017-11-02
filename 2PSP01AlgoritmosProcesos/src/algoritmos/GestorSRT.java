package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorSRT extends GestorProceso {

	public GestorSRT(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	/**
	 * Según Shorter Remaining Time(SRT), se elige, de manera apropiativa, el
	 * algoritmo con menos carga de trabajo restante.
	 * 
	 * @return el proceso que se debe ejecutar en este ciclo de CPU.
	 */
	@Override
	protected Proceso seleccionarProceso() {

		if (!colaProcesos.isEmpty()) {
			// Ordenar cola por más cortos y devolver el primero
			colaProcesos.sort((Proceso o1, Proceso o2) -> o1.getCargaRestante() - o2.getCargaRestante());
			return colaProcesos.get(0);
		}

		return null; // Si no existen procesos actualmente en la cola temporal.
	}

}
