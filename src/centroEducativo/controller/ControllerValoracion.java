package centroEducativo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.result.Row;

import centroEducativo.ConnectionManager;
import centroEducativo.model.Curso;
import centroEducativo.model.Materia;
import centroEducativo.model.ValoracionMateria;


public class ControllerValoracion {
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
	
	
	private static ValoracionMateria getEntidadFromResultSet(String sql) {
		ValoracionMateria valoracion = null;
		try {
			Connection conn = ConnectionManager.getConexion();
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				valoracion = new ValoracionMateria();
				valoracion.setId(rs.getInt("id"));
				valoracion.setIdEstudiante(rs.getInt("idEstudiante"));
				valoracion.setIdMateria(rs.getInt("idMateria"));
				valoracion.setIdProfesor(rs.getInt("idProfesor"));
				valoracion.setValoracion(rs.getInt("valoracion"));
				
			} 
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return valoracion;
	}
	/**
	 * 
	 * 
	 * @return
	 * @throws SQLException
	 */
	
	public static ValoracionMateria cargarPrimerRegistro() throws SQLException {	
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.valoracionmateria order by id limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static ValoracionMateria cargarSiguienteRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.valoracionmateria where id > " + id + " order by id limit 1;");
		
	

		
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	public static ValoracionMateria cargarAnteriorRegistro(String id) throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.valoracionmateria where id < " + id + " order by id desc limit 1;");
		
		
		
		
	}
	
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 * 
	 */
	
	public static ValoracionMateria cargarUltimoRegistro() throws SQLException {
		crearConexion();
		return getEntidadFromResultSet("Select * from centroeducativo.valoracionmateria order by id desc limit 1;");
		
		
	}
	
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int insertarRegistro(ValoracionMateria valoracionNueva) throws SQLException {
		crearConexion();
		PreparedStatement ps = conn.prepareStatement(
				"insert into valoracionmateria (id, idProfesor, idEstudiante, idMateria, valoracion) "
				+ " values (?, ?, ?, ?,?)");
		
		int siguienteIdValida = siguienteIdValida();
		ps.setInt(1, siguienteIdValida());
		ps.setInt(2, valoracionNueva.getIdProfesor());
		ps.setInt(3, valoracionNueva.getIdEstudiante());
		ps.setInt(4, valoracionNueva.getIdMateria());
		ps.setInt(5, valoracionNueva.getValoracion());
		
		
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
	
	public static int modificarRegistro(ValoracionMateria valoracionNueva) throws SQLException {
		crearConexion();
		
		PreparedStatement ps = conn.prepareStatement("UPDATE `centroeducativo`.`valoracionmateria` SET `id` = ?, `idProfesor` = ?, `idEstudiante` = ?, `idMateria` = ?, `valoracion` = ? Where id = " + valoracionNueva.getId() + ";");
		
		ps.setInt(1, valoracionNueva.getId());
		ps.setInt(2, valoracionNueva.getIdProfesor());
		ps.setInt(3, valoracionNueva.getIdEstudiante());
		ps.setInt(4, valoracionNueva.getIdMateria());
		ps.setInt(5, valoracionNueva.getValoracion());
		
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
		
		
		ResultSet rs = st.executeQuery("SELECT id FROM centroeducativo.valoracionmateria order by id desc limit 1;");
		
		if (rs.next()) {
			return siguienteIdValida = rs.getInt("id") + 1;
		}
		
		return siguienteIdValida;
	}
	
	/**
	 * @throws SQLException 
	 * 
	 * 
	 * 
	 */
	
	public static int eliminarRegistro(int id) throws SQLException {
		crearConexion();
		
		
		
		PreparedStatement ps = conn.prepareStatement("DELETE FROM materia WHERE id = ?;");
		
		ps.setInt(1, id);
		
		int row = ps.executeUpdate();
		
		return row;
	}

}
