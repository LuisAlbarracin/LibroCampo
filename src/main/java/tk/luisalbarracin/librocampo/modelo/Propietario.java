package tk.luisalbarracin.librocampo.modelo;

import java.io.Serializable;

public class Propietario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
	private String apellido;
	private String noCedula;
	private String telefono;
	private String expedicionCedula;
	private String email;
	private String contrasenia;

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

	public Propietario(String nombre, String apellido, String noCedula, String telefono, String expedicionCedula,
			String email, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.noCedula = noCedula;
		this.telefono = telefono;
		this.expedicionCedula = expedicionCedula;
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public Propietario(Integer id, String nombre, String apellido, String noCedula, String telefono,
			String expedicionCedula, String email, String contrasenia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.noCedula = noCedula;
		this.telefono = telefono;
		this.expedicionCedula = expedicionCedula;
		this.email = email;
		this.contrasenia = contrasenia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
