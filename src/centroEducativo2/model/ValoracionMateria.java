package centroEducativo2.model;

public class ValoracionMateria {
private int id;
private int idProfesor;
private int idEstudiante;
private int idMateria;
private int valoracion;


public ValoracionMateria() {
	super();
}


public ValoracionMateria(int id, int idProfesor, int idEstudiante, int idMateria, int valoracion) {
	super();
	this.id = id;
	this.idProfesor = idProfesor;
	this.idEstudiante = idEstudiante;
	this.idMateria = idMateria;
	this.valoracion = valoracion;
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public int getIdProfesor() {
	return idProfesor;
}


public void setIdProfesor(int idProfesor) {
	this.idProfesor = idProfesor;
}


public int getIdEstudiante() {
	return idEstudiante;
}


public void setIdEstudiante(int idEstudiante) {
	this.idEstudiante = idEstudiante;
}


public int getIdMateria() {
	return idMateria;
}


public void setIdMateria(int idMateria) {
	this.idMateria = idMateria;
}


public int getValoracion() {
	return valoracion;
}


public void setValoracion(int valoracion) {
	this.valoracion = valoracion;
}


@Override
public String toString() {
	return "ValoracionMateria [id=" + id + ", idProfesor=" + idProfesor + ", idEstudiante=" + idEstudiante
			+ ", idMateria=" + idMateria + ", valoracion=" + valoracion + "]";
}



}
