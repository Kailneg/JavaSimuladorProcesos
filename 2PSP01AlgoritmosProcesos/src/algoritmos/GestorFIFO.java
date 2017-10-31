package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorFIFO extends GestorProceso {

	public GestorFIFO(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	/**
	 * Ser� null si no existe un proceso disponible para el ciclo actual de CPU.
	 */
	@Override
	protected Proceso seleccionarProceso() {
		// Seg�n FIFO, eligiremos el primer proceso de la cola de procesos.
		// (El que primero lleg�), siempre que no haya ya uno ejecut�ndose.
		if (procesoActual != null)
			return procesoActual;
		if (!colaProcesos.isEmpty())
			return colaProcesos.get(0);
		return null;
	}
	
}
