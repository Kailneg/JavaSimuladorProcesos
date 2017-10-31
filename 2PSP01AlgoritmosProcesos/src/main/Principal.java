package main;

import java.util.ArrayList;
import java.util.Arrays;

import algoritmos.GestorFIFO;
import algoritmos.GestorLIFO;
import models.InformacionCicloCPU;
import models.Proceso;
import models.ProcesoPrioridad;

public class Principal {
	
	public static void main(String[] args) {
		
		//Generando procesos
		//						llegada, ciclosCarga
		Proceso p1 = new Proceso("A", 2, 3, ProcesoPrioridad.ALTA);
		Proceso p2 = new Proceso("B", 1, 3, ProcesoPrioridad.ALTA);
		Proceso p3 = new Proceso("C", 0, 3, ProcesoPrioridad.ALTA);
		
		ArrayList<Proceso> listaProcesos = new ArrayList<>();
		
		GestorLIFO gestor = new GestorLIFO(listaProcesos);
		InformacionCicloCPU iCPU;
		
		listaProcesos.add(p1);
		listaProcesos.add(p2);
		listaProcesos.add(p3);
		
		// Mientras quede trabajo por hacer, ejecutar ciclos de procesamiento.
		while (gestor.quedaTrabajo()){
			
			iCPU = gestor.cicloProcesamiento();
			System.out.println(iCPU);
		}
			
	}
	
}
