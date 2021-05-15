package tk.luisalbarracin.librocampo.modelo;

public class PlanFertilizante {
	
	private Integer id;
	private Fertilizante fertilizante;
	private Integer numeroBultos;
	private Float gramosPalma;
	
	public PlanFertilizante() {
		super();
	}
	
	public PlanFertilizante(Integer id, Fertilizante fertilizante, Integer numeroBultos, Float gramosPalma) {
		super();
		this.id = id;
		this.fertilizante = fertilizante;
		this.numeroBultos = numeroBultos;
		this.gramosPalma = gramosPalma;
	}
	
	public PlanFertilizante(Fertilizante fertilizante, Integer numeroBultos, Float gramosPalma) {
		super();
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
