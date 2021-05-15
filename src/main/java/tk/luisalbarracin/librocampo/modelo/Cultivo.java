package tk.luisalbarracin.librocampo.modelo;

public class Cultivo {
	private Integer id;
	private Finca finca;
	private Integer numero;
	
	public Cultivo() {
		super();
	}
	
	public Cultivo(Integer id, Finca finca, Integer numero) {
		super();
		this.id = id;
		this.finca = finca;
		this.numero = numero;
	}
	
	public Cultivo(Finca finca, Integer numero) {
		super();
		this.finca = finca;
		this.numero = numero;
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
	
	
	
}
