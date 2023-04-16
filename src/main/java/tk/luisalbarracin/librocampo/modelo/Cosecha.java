package tk.luisalbarracin.librocampo.modelo;

import java.time.LocalDate;

public class Cosecha {
	private Integer id;
	private Cultivo cultivo;
	private LocalDate fecha;
	private Integer numeroRacimos;
	private Float pesoTotal;
	private Float precioVenta;

	public Cosecha(Integer id, Cultivo cultivo, LocalDate fecha, Integer numeroRacimos, Float pesoTotal,
			Float precioVenta) {
		super();
		this.id = id;
		this.cultivo = cultivo;
		this.fecha = fecha;
		this.numeroRacimos = numeroRacimos;
		this.pesoTotal = pesoTotal;
		this.precioVenta = precioVenta;
	}

	public Cosecha() {
		super();
	}

	public Cosecha(Cultivo cultivo, LocalDate fecha, Integer numeroRacimos, Float pesoTotal, Float precioVenta) {
		super();
		this.cultivo = cultivo;
		this.fecha = fecha;
		this.numeroRacimos = numeroRacimos;
		this.pesoTotal = pesoTotal;
		this.precioVenta = precioVenta;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Integer getNumeroRacimos() {
		return numeroRacimos;
	}

	public void setNumeroRacimos(Integer numeroRacimos) {
		this.numeroRacimos = numeroRacimos;
	}

	public Float getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(Float pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	public Float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}

}
