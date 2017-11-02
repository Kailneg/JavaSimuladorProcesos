package models;

import java.util.ArrayList;

public class InformacionCicloCPU {

	private final Proceso procesoActual;
	private final int cicloCPU;
	private ArrayList<Proceso> colaProcesos;
	
	/**
	 * Construye un objeto v�lido para realizar cualquier tipo de interpretaci�n con los datos
	 * que se generan al ejecutar un proceso.
	 * @param procesoActual el proceso que se est� ejecutando actualmente.
	 * @param cicloCPU ciclo de CPU en el que se encuentra.
	 * @param colaProcesos una copia de la cola actual que se est� procesando.
	 */
	public InformacionCicloCPU(Proceso procesoActual, int cicloCPU, ArrayList<Proceso> colaProcesos) {
		this.procesoActual = procesoActual;
		this.cicloCPU = cicloCPU;
		this.colaProcesos = colaProcesos;
	}

	public Proceso getProcesoActual() {
		return procesoActual;
	}

	public int getCicloCPU() {
		return cicloCPU;
	}

	/**
	 * M�todo que devuelve una <b>copia</b> de la cola.
	 * @return <b>copia</b> de cola de procesos que se est� ejecutando actualmente. 
	 */
	public ArrayList<Proceso> getColaProcesos() {
		return new ArrayList<>(colaProcesos);
	}

	@Override
	public String toString() {
		return "InformacionCicloCPU: CicloCPU[" + cicloCPU + "]->" + procesoActual;
	}

}
