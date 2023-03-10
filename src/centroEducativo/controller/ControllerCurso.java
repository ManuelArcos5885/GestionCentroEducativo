package centroEducativo.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import centroEducativo.ConnectionManager;
import centroEducativo.model.Curso;


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
	
	

}
