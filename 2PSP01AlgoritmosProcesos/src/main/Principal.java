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
		Proceso p1 = new Proceso("A", 4, 1, ProcesoPrioridad.BAJA);
		Proceso p2 = new Proceso("B", 0, 5, ProcesoPrioridad.ALTA);
		Proceso p3 = new Proceso("C", 1, 3, ProcesoPrioridad.ALTA);
		Proceso p4 = new Proceso("D", 8, 6, ProcesoPrioridad.ALTA);
		Proceso p5 = new Proceso("E", 12, 2, ProcesoPrioridad.ALTA);
		
		ArrayList<Proceso> listaProcesos = new ArrayList<>();
		
		GestorRoundRobin gestor = new GestorRoundRobin(listaProcesos, 3);
		InformacionCicloCPU iCPU;
		
		listaProcesos.add(p1);
		listaProcesos.add(p2);
		listaProcesos.add(p3);
		listaProcesos.add(p4);
		listaProcesos.add(p5);
		
		// Mientras quede trabajo por hacer, ejecutar ciclos de procesamiento.
		while (gestor.quedaTrabajo()){
			iCPU = gestor.cicloProcesamiento();
			System.out.println(iCPU);
		}
			
	}
	
}
