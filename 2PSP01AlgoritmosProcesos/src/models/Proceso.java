package models;

public class Proceso {
	
	//STATE
	private final int ciclosInicio;
	private final String nombre;
	private final int tiempoLlegada;
	private final ProcesoPrioridad prioridad;
	
	private int cargaRestante;
	private int cicloEntrada;
	
	//CONSTRUCTOR
	/**
	 * Construye un nuevo objeto de tipo proceso.
	 * @param nombre nombre del proceso, no debe ser nulo ni vacío.
	 * @param llegada indica el momento de llegada del proceso, debe ser igual o mayor de 0
	 * @param ciclosInicio número de ciclos de procesamiento con los que cuenta el proceso en su inicio.
	 * Debe ser mayor de 0.
	 * @param prioridad prioridad que tiene el proceso. Usar Enumeracion ProcesoPrioridad.
	 */
	public Proceso(String nombre, int llegada, int ciclosInicio, ProcesoPrioridad prioridad) {
		super();
		//Comprobando nombre
		if (nombre == null)
			throw new NullPointerException("Nombre no debe ser null");
		if (nombre.isEmpty())
			throw new IllegalArgumentException("Nombre no puede estar vacío");
		this.nombre = nombre;
		
		//Comprobando llegada
		if (llegada < 0)
			throw new IllegalArgumentException("Llegada debe ser mínimo 0");
		this.tiempoLlegada = llegada;
		
		//Comprobando ciclos
		if (ciclosInicio < 1)
			throw new IllegalArgumentException("ciclosInicio debe ser mayor de 0");
		this.ciclosInicio = ciclosInicio;
		this.cargaRestante = ciclosInicio;
		this.cicloEntrada = -1;
		
		//Comprobando prioridad
		if (prioridad == null)
			throw new NullPointerException("Prioridad no debe ser null");
		this.prioridad = prioridad;
	}

	//METHODS
	/**
	 * Procesa un ciclo
	 * @return devuelve true si le quedan ciclos restantes por procesar, de lo contrario false.
	 */
	public void procesar(){
		cargaRestante--;
	}
	
	//GETTERS
	public int getCiclosInicio() {
		return ciclosInicio;
	}

	public String getNombre() {
		return nombre;
	}

	public int getLlegada() {
		return tiempoLlegada;
	}

	public ProcesoPrioridad getPrioridad() {
		return prioridad;
	}

	public int getCargaRestante() {
		return cargaRestante;
	}
	
	public void setCicloEntrada(int cicloEntrada) {
		this.cicloEntrada = cicloEntrada;
	}
	
	public int getCicloEntrada(){ return cicloEntrada; }
	
	public boolean tieneCargaRestante(){
		return getCargaRestante() > 0;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Proceso [PID=" + nombre + ", llegada=" + tiempoLlegada
				+ ", entradaCPU=" + cicloEntrada + ", prioridad=" + prioridad
				+ ", cargaRestante=" + cargaRestante + "]";
	}
		
}
