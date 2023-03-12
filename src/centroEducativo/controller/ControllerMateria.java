package centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import centroEducativo.ConnectionManager;
import centroEducativo.model.Curso;
import centroEducativo.model.Materia;


public class ControllerMateria {
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
	
	
	private static Materia getEntidadFromResultSet(String sql) {
		Materia materia = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				materia = new Materia();
				materia.setId(rs.getInt("id"));
				materia.setNombre(rs.getString("nombre"));
				materia.setAcronimo(rs.getString("acronimo"));
				materia.setCursoId(rs.getInt("curso_id"));
				System.out.println(materia.toString());
			} 
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return materia;
	}
	/**
	 * 
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	public static Materia cargarPrimerRegistro() throws SQLException {	
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.materia order by id limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Materia cargarSiguienteRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.materia where id > " + id + " order by id limit 1;");
		
	

		
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static Materia cargarAnteriorRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.materia where id < " + id + " order by id desc limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static Materia cargarUltimoRegistro() throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.materia order by id desc limit 1;");
		
		
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int insertarRegistro(Materia materiaNueva) throws SQLException {
		crearConexion();
		PreparedStatement ps = conn.prepareStatement(
				"insert into materia (id, nombre, acronimo, curso_id) "
				+ " values (?, ?, ?, ?)");
		ps.setInt(1, siguienteIdValida());
		ps.setString(2, materiaNueva.getNombre());
		ps.setString(3, materiaNueva.getAcronimo());
		ps.setInt(4, materiaNueva.getCursoId());
		
		
		ps.execute();
		
		conn.close();
		ps.close();
		return siguienteIdValida();
		
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int modificarRegistro(Materia materiaValores) throws SQLException {
		crearConexion();
		
		PreparedStatement ps = conn.prepareStatement("UPDATE `centroeducativo`.`materia` SET `id` = ?, `nombre` = ?, `acronimo` = ?, `curso_id` = ? Where id = " + materiaValores.getId() + ";");
		
		ps.setInt(1, materiaValores.getId());
		ps.setString(2, materiaValores.getNombre());
		ps.setString(3, materiaValores.getAcronimo());
		ps.setInt(4, materiaValores.getCursoId());
		
		
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
		
		
		ResultSet rs = st.executeQuery("SELECT id FROM centroeducativo.materia order by id desc limit 1;");
		
		if (rs.next()) {
			return siguienteIdValida = rs.getInt("id") + 1;
		}
		
		return siguienteIdValida;
	}
	

}
