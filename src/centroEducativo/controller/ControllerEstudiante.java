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


public class ControllerEstudiante {
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
	
	
	private static Estudiante getEntidadFromResultSet(String sql) {
		Estudiante estudiante = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				estudiante = new Estudiante();
				estudiante.setId(rs.getInt("id"));
				estudiante.setNombre(rs.getString("nombre"));
				estudiante.setApellido1(rs.getString("apellido1"));
				estudiante.setApellido2(rs.getString("apellido2"));
				estudiante.setDni(rs.getString("dni"));
				estudiante.setDireccion(rs.getString("direccion"));
				estudiante.setEmail(rs.getString("email"));
				estudiante.setTelefono(rs.getInt("telefono"));
				
				
			} 
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return estudiante;
	}
	/**
	 * 
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	public static Estudiante cargarPrimerRegistro() throws SQLException {	
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.estudiante order by id limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Estudiante cargarSiguienteRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.estudiante where id > " + id + " order by id limit 1;");
		
	

		
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static Estudiante cargarAnteriorRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.estudiante where id < " + id + " order by id desc limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Estudiante cargarUltimoRegistro() throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.estudiante order by id desc limit 1;");
		
		
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int insertarRegistro(Estudiante estudianteNuevo) throws SQLException {
		crearConexion();
		PreparedStatement ps = conn.prepareStatement(
				"insert into estudiante (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
		
		int siguienteIdValida = siguienteIdValida();
		ps.setInt(1, siguienteIdValida);
		ps.setString(2, estudianteNuevo.getNombre());
		ps.setString(3, estudianteNuevo.getApellido1());
		ps.setString(4, estudianteNuevo.getApellido2());
		ps.setString(5, estudianteNuevo.getDni());
		ps.setString(6, estudianteNuevo.getDireccion());
		ps.setString(7, estudianteNuevo.getEmail());
		ps.setInt(8, estudianteNuevo.getTelefono());
		
		
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
	
	public static int modificarRegistro(Estudiante estudianteNuevo) throws SQLException {
		crearConexion();
		
		PreparedStatement ps = conn.prepareStatement("UPDATE `centroeducativo`.`estudiante` SET `id` = ?, `nombre` = ?, `apellido1` = ?, `apellido2` = ?, `dni` = ?, `direccion` = ?, `email` = ?, `telefono` = ? Where id = " + estudianteNuevo.getId() + ";");
		
		ps.setInt(1, estudianteNuevo.getId());
		ps.setString(2, estudianteNuevo.getNombre());
		ps.setString(3, estudianteNuevo.getApellido1());
		ps.setString(4, estudianteNuevo.getApellido2());
		ps.setString(5, estudianteNuevo.getDni());
		ps.setString(6, estudianteNuevo.getDireccion());
		ps.setString(7, estudianteNuevo.getEmail());
		ps.setInt(8, estudianteNuevo.getTelefono());
		
		
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
		
		
		ResultSet rs = st.executeQuery("SELECT id FROM centroeducativo.estudiante order by id desc limit 1;");
		
		if (rs.next()) {
			return siguienteIdValida = rs.getInt("id") + 1;
		}
		
		return siguienteIdValida;
	}
	
	
	public static int eliminarRegistro(int id) throws SQLException {
		crearConexion();
		
		
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM estudiante WHERE id = ?;");
		
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
	
	
	public static List<Estudiante> cargarTodasId() throws SQLException {
		List<Estudiante> idEstudiante = new ArrayList<Estudiante>();
		
		crearConexion();
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("select * from estudiante");
		
		while (rs.next()) {
			Estudiante estudiante = new Estudiante();
			
			estudiante.setId(rs.getInt("id"));
			estudiante.setApellido1(rs.getString("apellido1"));
			estudiante.setApellido2(rs.getString("apellido2"));
			estudiante.setNombre(rs.getString("nombre"));
			estudiante.setTelefono(rs.getInt("telefono"));
			estudiante.setEmail(rs.getString("email"));
			estudiante.setDireccion(rs.getString("direccion"));
			estudiante.setDni(rs.getString("dni"));
			
			idEstudiante.add(estudiante);
		}
		
		return idEstudiante;
		
	}
	

}
