package tk.luisalbarracin.librocampo.modelo;

public class PlanFertilizante {

	private Integer id;
	private String nombre;
	private Fertilizante fertilizante;
	private Integer numeroBultos;
	private Float gramosPalma;

	public PlanFertilizante() {
		super();
	}

	public PlanFertilizante(Integer id, String nombre, Fertilizante fertilizante, Integer numeroBultos,
			Float gramosPalma) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fertilizante = fertilizante;
		this.numeroBultos = numeroBultos;
		this.gramosPalma = gramosPalma;
	}

	public PlanFertilizante(String nombre, Fertilizante fertilizante, Integer numeroBultos, Float gramosPalma) {
		super();
		this.nombre = nombre;
		this.fertilizante = fertilizante;
		this.numeroBultos = numeroBultos;
		this.gramosPalma = gramosPalma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Fertilizante getFertilizante() {
		return fertilizante;
	}

	public void setFertilizante(Fertilizante fertilizante) {
		this.fertilizante = fertilizante;
	}

	public Integer getNumeroBultos() {
		return numeroBultos;
	}

	public void setNumeroBultos(Integer numeroBultos) {
		this.numeroBultos = numeroBultos;
	}

	public Float getGramosPalma() {
		return gramosPalma;
	}

	public void setGramosPalma(Float gramosPalma) {
		this.gramosPalma = gramosPalma;
	}

}
