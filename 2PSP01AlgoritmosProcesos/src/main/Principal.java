package main;

import java.util.ArrayList;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import algoritmos.*;
import models.InformacionCicloCPU;
import models.Proceso;
import models.ProcesoPrioridad;

public class Principal implements Runnable {

	public static void main(String[] args) {

		try {
			new Thread(new Principal()).start();
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void run() {
		
		ArrayList<Proceso> listaProcesos = new ArrayList<>();
		GestorProceso gestor;
		int eleccion, quantum = 0;
		String mensaje = "";
		
		// Generando y añadiendo procesos a la lista.
		//							->llegada,ciclosCarga
		listaProcesos.add(new Proceso("A", 4, 1, ProcesoPrioridad.BAJA));
		listaProcesos.add(new Proceso("B", 0, 5, ProcesoPrioridad.MEDIA));
		listaProcesos.add(new Proceso("C", 1, 3, ProcesoPrioridad.ALTA));
		listaProcesos.add(new Proceso("D", 8, 6, ProcesoPrioridad.MEDIA));
		listaProcesos.add(new Proceso("E", 9, 2, ProcesoPrioridad.ALTA));

		// Mostrar al usuario información sobre los procesos
		System.out.println("Algoritmos de planificación de procesos, por Alejandro del Río.\n\n"
				+ "Dados los siguientes procesos: ");
		listaProcesos.forEach(x -> System.out.println(
				"Proceso: " + x.getNombre() + ", llegada: " + x.getLlegada() +
				", carga: " + x.getCargaRestante()));
		// Dar a elegir el gestor de procesos que se quiera usar
		System.out.println("\nElija un algortmo de planificación para procesarlos."
				+ "\n1-> FIFO" + "\n2-> LIFO" + "\n3-> SJF"
				+ "\n4-> SRT Apropiativo" + "\n5-> Prioridades"
				+ "\n6-> Round Robin");
		
		eleccion = leerInt();
		
		// En el caso de que haya elegido Round Robin, preguntar por el quantum.
		if (eleccion == 6) {
			System.out.println("Introduce el quantum:");
			quantum = leerInt();
			if (quantum < 1) {
				System.out.println("Dato no válido introducido, quantum mínimo fijado en 1");
				quantum = 1;
			}
		}
		
		switch (eleccion) {
		case 1:
			gestor = new GestorFIFO(listaProcesos);
			mensaje = "\nGestor FIFO elegido, procesando...\n";
			break;
		case 2:
			gestor = new GestorLIFO(listaProcesos);
			mensaje = "\nGestor LIFO elegido, procesando...\n";
			break;
		case 3:
			gestor = new GestorSJF(listaProcesos);
			mensaje = "\nGestor SJF elegido, procesando...\n";
			break;
		case 4:
			gestor = new GestorSRT(listaProcesos);
			mensaje = "\nGestor SRT elegido, procesando...\n";
			break;
		case 5:
			gestor = new GestorPrioridad(listaProcesos);
			mensaje = "\nGestor Prioridades elegido, procesando...\n";
			break;
		case 6:
			gestor = new GestorRoundRobin(listaProcesos, quantum);
			mensaje = "\nGestor Round Robin elegido, con quantum " 
					+ quantum + " procesando...\n";
			break;
		default:
			System.out.println("Opción no válida introducida.");
			System.exit(0);
			gestor = null;
			break;
		}
		System.out.println(mensaje);
		// Mientras quede trabajo por hacer, ejecutar ciclos de procesamiento.
		while (gestor.quedaTrabajo()){
			InformacionCicloCPU iCPU = gestor.cicloProcesamiento();
			System.out.println(iCPU.getProcesoActual() == null ? 
					"InfoCPU: Ciclo[" + iCPU.getCicloCPU() + "] Esperando..." : iCPU);
		}
	}

	private int leerInt() {
		Scanner sc = new Scanner(System.in);
		int eleccionNum;
		
		try {
			eleccionNum = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			eleccionNum = 0;
		}
		return eleccionNum;
	}
}
