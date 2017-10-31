package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorSPF extends GestorProceso {

	public GestorSPF(ArrayList<Proceso> listaProcesos) {
		super(listaProcesos);
	}

	@Override
	protected Proceso seleccionarProceso() {
		// Seg�n Shorter Process First (SPF), se elige primero al proceso m�s corto.
		
		// No es apropiativo.
		if (procesoActual != null)
			return procesoActual;
		
		if (!colaProcesos.isEmpty()) {
			// Ordenar cola por m�s cortos y devolver el primero
			colaProcesos.sort((Proceso o1, Proceso o2) ->
					o1.getCargaRestante() - o2.getCargaRestante());
			return colaProcesos.get(0);
		}
			
		return null; // Si no existen procesos actualmente en la cola se devuelve null.
	}

}
