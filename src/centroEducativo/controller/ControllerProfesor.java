package centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import centroEducativo.ConnectionManager;
import centroEducativo.model.Curso;
import centroEducativo.model.Estudiante;
import centroEducativo.model.Materia;
import centroEducativo.model.Profesor;


public class ControllerProfesor {
	private static Connection conn = null;
	
	
	public static void main(String[] args) {
		
	}
	
	
	public static Connection crearConexion() {
		try {
			conn = ConnectionManager.getConexion();
			
		} catch (Exception e) {
			System.out.println("no se pudo");
		}
		return conn;
	}
	
	/**
	 * 
	 * @param rs
	 * @return
	 */
	
	
	private static Profesor getEntidadFromResultSet(String sql) {
		Profesor profesor = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				profesor = new Profesor();
				profesor.setId(rs.getInt("id"));
				profesor.setNombre(rs.getString("nombre"));
				profesor.setApellido1(rs.getString("apellido1"));
				profesor.setApellido2(rs.getString("apellido2"));
				profesor.setDni(rs.getString("dni"));
				profesor.setDireccion(rs.getString("direccion"));
				profesor.setEmail(rs.getString("email"));
				profesor.setTelefono(rs.getInt("telefono"));
				
				
			} 
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return profesor;
	}
	/**
	 * 
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	public static Profesor cargarPrimerRegistro() throws SQLException {	
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.profesor order by id limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Profesor cargarSiguienteRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.profesor where id > " + id + " order by id limit 1;");
		
	

		
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static Profesor cargarAnteriorRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.profesor where id < " + id + " order by id desc limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Profesor cargarUltimoRegistro() throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.profesor order by id desc limit 1;");
		
		
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int insertarRegistro(Profesor profesorNuevo) throws SQLException {
		crearConexion();
		PreparedStatement ps = conn.prepareStatement(
				"insert into profesor (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
		int siguienteIdValida = siguienteIdValida();
		ps.setInt(1, siguienteIdValida);
		ps.setString(2, profesorNuevo.getNombre());
		ps.setString(3, profesorNuevo.getApellido1());
		ps.setString(4, profesorNuevo.getApellido2());
		ps.setString(5, profesorNuevo.getDni());
		ps.setString(6, profesorNuevo.getDireccion());
		ps.setString(7, profesorNuevo.getEmail());
		ps.setInt(8, profesorNuevo.getTelefono());
		
		
		ps.execute();
		
		conn.close();
		ps.close();
		return siguienteIdValida;
		
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int modificarRegistro(Profesor profesorNuevo) throws SQLException {
		crearConexion();
		
		PreparedStatement ps = conn.prepareStatement("UPDATE `centroeducativo`.`estudiante` SET `id` = ?, `nombre` = ?, `apellido1` = ?, `apellido2` = ?, `dni` = ?, `direccion` = ?, `email` = ?, `telefono` = ? Where id = " + profesorNuevo.getId() + ";");
		
		ps.setInt(1, profesorNuevo.getId());
		ps.setString(2, profesorNuevo.getNombre());
		ps.setString(3, profesorNuevo.getApellido1());
		ps.setString(4, profesorNuevo.getApellido2());
		ps.setString(5, profesorNuevo.getDni());
		ps.setString(6, profesorNuevo.getDireccion());
		ps.setString(7, profesorNuevo.getEmail());
		ps.setInt(8, profesorNuevo.getTelefono());
		
		
		int rows = ps.executeUpdate();
		
		return rows;
		
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 */
	public static int siguienteIdValida() throws SQLException {
		crearConexion();
		int siguienteIdValida = 0;
		Connection conn = ConnectionManager.getConexion();
		
		Statement st = conn.createStatement();
		
		
		ResultSet rs = st.executeQuery("SELECT id FROM centroeducativo.profesor order by id desc limit 1;");
		
		if (rs.next()) {
			return siguienteIdValida = rs.getInt("id") + 1;
		}
		
		return siguienteIdValida;
	}
	/**
	 * 
	 * 
	 */
	
	public static int eliminarRegistro(int id) throws SQLException {
		crearConexion();
		
		
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM profesor WHERE id = ?;");
		
		ps.setInt(1, id);
		
		int row = ps.executeUpdate();
		
		return row;
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	public static List<Profesor> cargarTodasId() throws SQLException {
		List<Profesor> idProfesor = new ArrayList<Profesor>();
		
		crearConexion();
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from profesor");
		
		while (rs.next()) {
			Profesor profesor = new Profesor();
			
			profesor.setId(rs.getInt("id"));
			profesor.setApellido1(rs.getString("apellido1"));
			profesor.setApellido2(rs.getString("apellido2"));
			profesor.setNombre(rs.getString("nombre"));
			profesor.setTelefono(rs.getInt("telefono"));
			profesor.setEmail(rs.getString("email"));
			profesor.setDireccion(rs.getString("direccion"));
			profesor.setDni(rs.getString("dni"));
			
			idProfesor.add(profesor);
		}
		
		return idProfesor;
		
	}
	

}
