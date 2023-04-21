package tk.luisalbarracin.librocampo.modelo;

import java.time.LocalDate;
import java.util.List;

public class Finca {
	private Integer id;
	private String nombre;
	private Float area;
	private Asociacion asociacion;
	private Float areaPalma;
	private String plano;
	private Propietario propietario;
	private String vereda;
	private LocalDate inicioSiembra;
	private List<Cultivo> cultivos;

	public Finca() {
		super();
	}

	public Finca(Integer id, String nombre, Float area, Asociacion asociacion, Float areaPalma, String plano,
			Propietario propietario, String vereda, LocalDate inicioSiembra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.area = area;
		this.asociacion = asociacion;
		this.areaPalma = areaPalma;
		this.plano = plano;
		this.propietario = propietario;
		this.vereda = vereda;
		this.inicioSiembra = inicioSiembra;
	}

	public Finca(String nombre, Float area, Asociacion asociacion, Float areaPalma, String plano,
			Propietario propietario, String vereda, LocalDate inicioSiembra) {
		super();
		this.nombre = nombre;
		this.area = area;
		this.asociacion = asociacion;
		this.areaPalma = areaPalma;
		this.plano = plano;
		this.propietario = propietario;
		this.vereda = vereda;
		this.inicioSiembra = inicioSiembra;
	}

	public Finca(Integer id, String nombre, Float area, Asociacion asociacion, Float areaPalma, Propietario propietario,
			String vereda) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.area = area;
		this.asociacion = asociacion;
		this.areaPalma = areaPalma;
		this.propietario = propietario;
		this.vereda = vereda;
	}

	public Finca(String nombre, Float area, Asociacion asociacion, Float areaPalma, Propietario propietario,
			String vereda) {
		super();
		this.nombre = nombre;
		this.area = area;
		this.asociacion = asociacion;
		this.areaPalma = areaPalma;
		this.propietario = propietario;
		this.vereda = vereda;
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

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Asociacion getAsociacion() {
		return asociacion;
	}

	public void setAsociacion(Asociacion asociacion) {
		this.asociacion = asociacion;
	}

	public Float getAreaPalma() {
		return areaPalma;
	}

	public void setAreaPalma(Float areaPalma) {
		this.areaPalma = areaPalma;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public String getVereda() {
		return vereda;
	}

	public void setVereda(String vereda) {
		this.vereda = vereda;
	}

	public LocalDate getInicioSiembra() {
		return inicioSiembra;
	}

	public void setInicioSiembra(LocalDate inicioSiembra) {
		this.inicioSiembra = inicioSiembra;
	}

	public List<Cultivo> getCultivos() {
		return cultivos;
	}

	public void setCultivos(List<Cultivo> cultivos) {
		this.cultivos = cultivos;
	}

}
