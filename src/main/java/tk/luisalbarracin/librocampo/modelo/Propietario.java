package tk.luisalbarracin.librocampo.modelo;

import java.io.Serializable;

public class Propietario implements Serializable {

	private Integer id;
	private String nombre;
	private String apellido;
	private String noCedula;
	private String telefono;
	private String expedicionCedula;
	
	
	public Propietario() {
		super();
	}
	
	public Propietario(Integer id, String nombre, String apellido, String noCedula, String telefono,
			String expedicionCedula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.noCedula = noCedula;
		this.telefono = telefono;
		this.expedicionCedula = expedicionCedula;
	}

	public Propietario(String nombre, String apellido, String noCedula, String telefono, String expedicionCedula) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.noCedula = noCedula;
		this.telefono = telefono;
		this.expedicionCedula = expedicionCedula;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNoCedula() {
		return noCedula;
	}
	public void setNoCedula(String noCedula) {
		this.noCedula = noCedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getExpedicionCedula() {
		return expedicionCedula;
	}
	public void setExpedicionCedula(String expedicionCedula) {
		this.expedicionCedula = expedicionCedula;
	}
	
	
	
}
