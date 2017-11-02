package main;

import java.util.ArrayList;
import algoritmos.*;
import models.InformacionCicloCPU;
import models.Proceso;
import models.ProcesoPrioridad;

public class Principal {
	
	public static void main(String[] args) {
		
		//Generando procesos
		//						llegada, ciclosCarga
		Proceso p1 = new Proceso("A", 0, 4, ProcesoPrioridad.ALTA);
		Proceso p2 = new Proceso("B", 1, 1, ProcesoPrioridad.ALTA);
		Proceso p3 = new Proceso("C", 2, 4, ProcesoPrioridad.ALTA);
		Proceso p4 = new Proceso("D", 32, 1, ProcesoPrioridad.ALTA);
		
		ArrayList<Proceso> listaProcesos = new ArrayList<>();
		
		GestorSRT gestor = new GestorSRT(listaProcesos);
		InformacionCicloCPU iCPU;
		
		listaProcesos.add(p1);
		listaProcesos.add(p2);
		listaProcesos.add(p3);
		listaProcesos.add(p4);
		
		// Mientras quede trabajo por hacer, ejecutar ciclos de procesamiento.
		while (gestor.quedaTrabajo()){
			
			iCPU = gestor.cicloProcesamiento();
			System.out.println(iCPU);
		}
			
	}
	
}
