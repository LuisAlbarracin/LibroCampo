package tk.luisalbarracin.librocampo.modelo;

public class Cultivo {
	private Integer id;
	private Finca finca;
	private Integer numero;
	private String nombre;
	
	public Cultivo() {
		super();
	}
	
	public Cultivo(Integer id, Finca finca, Integer numero, String nombre) {
		super();
		this.id = id;
		this.finca = finca;
		this.numero = numero;
		this.nombre = nombre;
	}
	
	public Cultivo(Finca finca, Integer numero, String nombre) {
		super();
		this.finca = finca;
		this.numero = numero;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Finca getFinca() {
		return finca;
	}

	public void setFinca(Finca finca) {
		this.finca = finca;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
