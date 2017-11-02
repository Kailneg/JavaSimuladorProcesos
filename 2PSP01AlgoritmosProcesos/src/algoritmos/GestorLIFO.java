package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorLIFO extends GestorProceso {

	public GestorLIFO(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	/**
	 * Seg�n Last In First Out, se elige el �ltimo proceso que lleg�. 
	 * No es apropiativo
	 * 
	 * @return el proceso que se debe ejecutar en este ciclo de CPU.
	 */
	@Override
	protected Proceso seleccionarProceso() {
		// No apropiativo, comprobamos que no haya uno ya ejecut�ndose.
		if (procesoActual != null)
			return procesoActual;
		
		// Obtiene el �ltimo de la cola temporal
		if (!colaProcesos.isEmpty())
			return colaProcesos.get(colaProcesos.size() - 1); 
		return null;
	}

}
