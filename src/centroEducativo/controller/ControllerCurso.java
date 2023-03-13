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


public class ControllerCurso {
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
	
	public static Curso cargarPrimerRegistro() throws SQLException {	
		crearConexion();
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from centroeducativo.curso order by id limit 1;");
		
		Curso curso = null;
		if (rs.next()) {
			curso = new Curso();
			
			curso.setId(rs.getInt("id"));		
			curso.setDescripcion(rs.getString("descripcion"));
			
			
		}
		rs.close();
		st.close();
		conn.close();
		return curso;
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Curso cargarSiguienteRegistro(String id) throws SQLException {
		crearConexion();

		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from centroeducativo.curso where id > " + id + " order by id limit 1;");
		
		Curso curso = null;
		if (rs.next()) {
			curso = new Curso();
			
			curso.setId(rs.getInt("id"));		
			curso.setDescripcion(rs.getString("descripcion"));
		}
		rs.close();
		st.close();

		conn.close();
		return curso;
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static Curso cargarAnteriorRegistro(String id) throws SQLException {
		crearConexion();

		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from centroeducativo.curso where id < " + id + " order by id desc limit 1;");
		
		Curso curso = null;
		if (rs.next()) {
			curso = new Curso();
			
			curso.setId(rs.getInt("id"));		
			curso.setDescripcion(rs.getString("descripcion"));
		}
		rs.close();
		st.close();

		conn.close();
		return curso;
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Curso cargarUltimoRegistro() throws SQLException {
		crearConexion();
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from centroeducativo.curso order by id desc limit 1;");
		System.out.println("hola");
		Curso curso = null;
		if (rs.next()) {
			curso = new Curso();
			
			curso.setId(rs.getInt("id"));		
			curso.setDescripcion(rs.getString("descripcion"));
			
			
		}
		rs.close();
		st.close();
		conn.close();
		return curso;
		
		
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static List<Curso> cargarTodasId() throws SQLException {
		crearConexion();
		List<Curso> listaId = new ArrayList<Curso>();
		
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from centroeducativo.curso");
		Curso curso = null;
		while (rs.next()) {
			curso = new Curso();
			curso.setId(rs.getInt("id"));
			curso.setDescripcion(rs.getString("descripcion"));
			listaId.add(curso);
			
		}
		return listaId;
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public static int eliminarRegistro(int id) throws SQLException {
		crearConexion();
		
		
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM curso WHERE id = ?;");
		
		ps.setInt(1, id);
		
		int row = ps.executeUpdate();
		
		return row;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int modificarRegistro(Curso cursoNuevo) throws SQLException {
		crearConexion();
		
		PreparedStatement ps = conn.prepareStatement("UPDATE `centroeducativo`.`curso` SET `id` = ?, `nombre` = ?, `apellido1` = ?, `apellido2` = ?, `dni` = ?, `direccion` = ?, `email` = ?, `telefono` = ? Where id = " + cursoNuevo.getId() + ";");
		
		ps.setInt(1, cursoNuevo.getId());
		ps.setString(2, cursoNuevo.getDescripcion());
		
		
		int rows = ps.executeUpdate();
		
		return rows;
		
	}
	
	
	
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int insertarRegistro(Curso cursoNuevo) throws SQLException {
		crearConexion();
		PreparedStatement ps = conn.prepareStatement(
				"insert into curso (id, nombre, apellido1, apellido2, dni, direccion, email, telefono) "
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)");
		
		int siguienteIdValida = siguienteIdValida();
		ps.setInt(1, siguienteIdValida);
		ps.setString(2, cursoNuevo.getDescripcion());


		
		
		ps.execute();
		
		conn.close();
		ps.close();
		return siguienteIdValida;
		
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
		
		
		ResultSet rs = st.executeQuery("SELECT id FROM centroeducativo.curso order by id desc limit 1;");
		
		if (rs.next()) {
			return siguienteIdValida = rs.getInt("id") + 1;
		}
		
		return siguienteIdValida;
	}
	

}
