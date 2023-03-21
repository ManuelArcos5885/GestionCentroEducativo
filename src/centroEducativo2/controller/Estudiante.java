package centroEducativo2.controller;

public class Estudiante {
private int id;
private String nombre;
private String apellido1;
private String apellido2;
private String dni;
private String direccion;
private String email;
private int telefono;


public Estudiante() {
	super();
}


public Estudiante(int id, String nombre, String apellido1, String apellido2, String dni, String direccion, String email,
		int telefono) {
	super();
	this.id = id;
	this.nombre = nombre;
	this.apellido1 = apellido1;
	this.apellido2 = apellido2;
	this.dni = dni;
	this.direccion = direccion;
	this.email = email;
	this.telefono = telefono;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getNombre() {
	return nombre;
}


public void setNombre(String nombre) {
	this.nombre = nombre;
}


public String getApellido1() {
	return apellido1;
}


public void setApellido1(String apellido1) {
	this.apellido1 = apellido1;
}


public String getApellido2() {
	return apellido2;
}


public void setApellido2(String apellido2) {
	this.apellido2 = apellido2;
}


public String getDni() {
	return dni;
}


public void setDni(String dni) {
	this.dni = dni;
}


public String getDireccion() {
	return direccion;
}


public void setDireccion(String direccion) {
	this.direccion = direccion;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public int getTelefono() {
	return telefono;
}


public void setTelefono(int telefono) {
	this.telefono = telefono;
}


@Override
public String toString() {
	return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
			+ ", dni=" + dni + ", direccion=" + direccion + ", email=" + email + ", telefono=" + telefono + "]";
}













}
