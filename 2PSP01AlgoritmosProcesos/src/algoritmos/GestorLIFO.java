package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorLIFO extends GestorProceso {

	public GestorLIFO(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	@Override
	protected Proceso seleccionarProceso() {
		// Seg�n LIFO, eligiremos el �ltimo proceso de la cola de procesos.
		// (El �ltimo que lleg�), siempre que no haya ya uno ejecut�ndose.
		if (procesoActual != null)
			return procesoActual;
		if (!colaProcesos.isEmpty())
			return colaProcesos.get(colaProcesos.size() - 1); // Obtiene el �ltimo
		return null;
	}

}
