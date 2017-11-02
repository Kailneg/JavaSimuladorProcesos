package algoritmos;

import java.util.ArrayList;

import models.Proceso;

public class GestorRoundRobin extends GestorProceso {

	private final int quantumInicial;
	private int quantum;

	/**
	 * Crea un nuevo gestor que usará el algoritmo <b>Round Robin</b> para ejecutar los
	 * procesos que se le pasen.
	 * 
	 * @param listaProcesos
	 *            la lista que se procesará
	 * @param quantum
	 *            el número de ciclos que se ejecutará cada proceso en cada
	 *            turno
	 */
	public GestorRoundRobin(ArrayList<Proceso> listaProcesos, int quantum) {
		super(listaProcesos);
		this.quantumInicial = quantum;
		this.quantum = quantum;
	}

	/**
	 * Elige a un proceso para ejecutarlo según el algoritmo Round Robin. No es
	 * apropiativo
	 * 
	 * @return el proceso que se debe ejecutar en este ciclo de CPU.
	 */
	@Override
	protected Proceso seleccionarProceso() {
		// Si no existe proceso actual, elegir el primero de la cola.
		if (procesoActual == null) {
			if (!colaProcesos.isEmpty())
				return siguienteProceso();
		} else {
			// Si ya hay un proceso, verificar que queden quauntums por procesar
			if (quantum > 0) {
				quantum--;
				// Si los hay, devolvemos el mismo proceso.
				return procesoActual;
			} else {
				// Si se han acabado los quantums y no ha terminado de
				// ejecutarse,
				// se guarda al final de la cola, y devuelve el primero
				colaProcesos.remove(procesoActual);
				colaProcesos.add(procesoActual);
				return siguienteProceso();
			}
		}
		return null; // Si no existen procesos actualmente en la cola temporal.
	}

	/**
	 * Restablece el quantum y devuelve el siguiente proceso.
	 * @return el siguiente proceso que se debe ejecutar, extraido de la cola de procesos.
	 */
	private Proceso siguienteProceso() {
		// En el momento que se devuelve se ejecutará una vez, por eso se le resta un quantum
		// antes de pasarlo, dando por hecho que se va a ejecutar.
		quantum = quantumInicial - 1;
		return colaProcesos.get(0);
	}
}
