package tk.luisalbarracin.librocampo.modelo;

import java.util.Date;

public class Calidad {
	private Integer id;
	private Cultivo cultivo;
	private Date fecha;
	private Float porcentajeVerdes;
	private Float porcentajeSobremaduros;
	private Float porcentajePedunculoLargo;
	private Float porcentajePodridos;
	private Boolean impurezas;
	
	
	public Calidad() {
		super();
	}
	
	public Calidad(Integer id, Cultivo cultivo, Date fecha, Float porcentajeVerdes, Float porcentajeSobremaduros,
			Float porcentajePedunculoLargo, Float porcentajePodridos, Boolean impurezas) {
		super();
		this.id = id;
		this.cultivo = cultivo;
		this.fecha = fecha;
		this.porcentajeVerdes = porcentajeVerdes;
		this.porcentajeSobremaduros = porcentajeSobremaduros;
		this.porcentajePedunculoLargo = porcentajePedunculoLargo;
		this.porcentajePodridos = porcentajePodridos;
		this.impurezas = impurezas;
	}
	
	public Calidad(Cultivo cultivo, Date fecha, Float porcentajeVerdes, Float porcentajeSobremaduros,
			Float porcentajePedunculoLargo, Float porcentajePodridos, Boolean impurezas) {
		super();
		this.cultivo = cultivo;
		this.fecha = fecha;
		this.porcentajeVerdes = porcentajeVerdes;
		this.porcentajeSobremaduros = porcentajeSobremaduros;
		this.porcentajePedunculoLargo = porcentajePedunculoLargo;
		this.porcentajePodridos = porcentajePodridos;
		this.impurezas = impurezas;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Float getPorcentajeVerdes() {
		return porcentajeVerdes;
	}

	public void setPorcentajeVerdes(Float porcentajeVerdes) {
		this.porcentajeVerdes = porcentajeVerdes;
	}

	public Float getPorcentajeSobremaduros() {
		return porcentajeSobremaduros;
	}

	public void setPorcentajeSobremaduros(Float porcentajeSobremaduros) {
		this.porcentajeSobremaduros = porcentajeSobremaduros;
	}

	public Float getPorcentajePedunculoLargo() {
		return porcentajePedunculoLargo;
	}

	public void setPorcentajePedunculoLargo(Float porcentajePedunculoLargo) {
		this.porcentajePedunculoLargo = porcentajePedunculoLargo;
	}

	public Float getPorcentajePodridos() {
		return porcentajePodridos;
	}

	public void setPorcentajePodridos(Float porcentajePodridos) {
		this.porcentajePodridos = porcentajePodridos;
	}

	public Boolean getImpurezas() {
		return impurezas;
	}

	public void setImpurezas(Boolean impurezas) {
		this.impurezas = impurezas;
	}
	
	
	
	
}
