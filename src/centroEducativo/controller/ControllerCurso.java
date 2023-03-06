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
	
	
	private static Connection crearConexion() {
		try {
			conn = ConnectionManager.getConexion();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	
	private static Curso cargarPrimerRegistro() throws SQLException {	
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
	
		return curso;
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
//	private static void cargarSiguienteRegistro() {
//		try {
//			Statement st = conn.createStatement();
//			
//			ResultSet rs = st.executeQuery("Select * from centroeducativo.curso where id > " + jtfid.getText() + " order by id limit 1;");
//			
//			if (rs.next()) {
				
//			}
//			rs.close();
//			st.close();
			
//		} catch (Exception e) {
			// TODO: handle exception
//		}
		
		
//	}
	
	/**
	 * 
	 * 
	 */
	
//	private static void cargarAnteriorRegistro() {
//		try {
//			Statement st = conn.createStatement();
//			
//			ResultSet rs = st.executeQuery("Select * from centroeducativo.curso where id < " + jtfid.getText() + " order by id desc limit 1;");
//			
//			if (rs.next()) {
//				
//			}
//			rs.close();
//			st.close();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
//	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	private static Curso cargarUltimoRegistro() throws SQLException {
		Statement st = conn.createStatement();
		
		ResultSet rs = st.executeQuery("Select * from centroeducativo.curso order by id desc limit 1;");
		
		Curso curso = null;
		if (rs.next()) {
			curso = new Curso();
			
			curso.setId(rs.getInt("id"));		
			curso.setDescripcion(rs.getString("descripcion"));
			
			
		}
		rs.close();
		st.close();
	
		return curso;
		
		
	}
	
	

}
