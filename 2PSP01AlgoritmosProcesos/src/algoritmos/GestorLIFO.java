package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorLIFO extends GestorProceso {

	public GestorLIFO(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	@Override
	protected Proceso seleccionarProceso() {
		// Según LIFO, eligiremos el último proceso de la cola de procesos.
		// (El último que llegó), siempre que no haya ya uno ejecutándose.
		if (procesoActual != null)
			return procesoActual;
		if (!colaProcesos.isEmpty())
			return colaProcesos.get(colaProcesos.size() - 1); // Obtiene el último
		return null;
	}

}
