package tk.luisalbarracin.librocampo.modelo;

public class CultivoPlan {
	
	private Integer id;
	private Cultivo cultivo;
	private PlanFertilizante plan;
	private Integer mes;
	private Integer anio;
	
	public CultivoPlan() {
		super();
	}
	
	public CultivoPlan(Cultivo cultivo, PlanFertilizante plan, Integer mes, Integer anio) {
		super();
		this.cultivo = cultivo;
		this.plan = plan;
		this.mes = mes;
		this.anio = anio;
	}
	
	
	public CultivoPlan(Integer id, Cultivo cultivo, PlanFertilizante plan, Integer mes, Integer anio) {
		super();
		this.id = id;
		this.cultivo = cultivo;
		this.plan = plan;
		this.mes = mes;
		this.anio = anio;
	}

	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cultivo getCultivo() {
		return cultivo;
	}
	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}
	public PlanFertilizante getPlan() {
		return plan;
	}
	public void setPlan(PlanFertilizante plan) {
		this.plan = plan;
	}
	public Integer getMes() {
		return mes;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public Integer getAnio() {
		return anio;
	}
	public void setAnio(Integer anio) {
		this.anio = anio;
	}
	
}
