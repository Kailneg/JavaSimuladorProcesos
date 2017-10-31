package models;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InformacionCicloCPU {

	private final Proceso procesoActual;
	private final int cicloCPU;
	private ArrayList<Proceso> colaProcesos;
	
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

	public ArrayList<Proceso> getColaProcesos() {
		return colaProcesos;
	}

	@Override
	public String toString() {
		return "InformacionCicloCPU: CicloCPU[" + cicloCPU + "]->" + procesoActual;
	}

}
