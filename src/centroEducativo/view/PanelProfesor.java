package centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import centroEducativo.controller.ControllerCurso;
import centroEducativo.controller.ControllerEstudiante;
import centroEducativo.controller.ControllerMateria;
import centroEducativo.controller.ControllerProfesor;
import centroEducativo.model.Curso;
import centroEducativo.model.Estudiante;
import centroEducativo.model.Materia;
import centroEducativo.model.Profesor;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelProfesor extends JPanel {
	private JTextField textFieldId;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido1;
	
	JButton botomPrimero, botomAnterior, botomSiguiente, botomUltimo;
	private JTextField textField_email;
	private JTextField textField_Direccion;
	private JTextField textField_Apellido2;
	private JTextField textField_dni;
	private JTextField textField_telefono;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public PanelProfesor(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{150, 154, 0};
//		gridBagLayout.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion Materia");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldId = new JTextField();
		textFieldId.setEnabled(false);
		GridBagConstraints gbc_textFieldId = new GridBagConstraints();
		gbc_textFieldId.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldId.gridx = 1;
		gbc_textFieldId.gridy = 2;
		add(textFieldId, gbc_textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("direccion:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 5;
		gbc_lblNewLabel_7.gridy = 2;
		add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField_Direccion = new JTextField();
		GridBagConstraints gbc_textField_Direccion = new GridBagConstraints();
		gbc_textField_Direccion.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Direccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Direccion.gridx = 6;
		gbc_textField_Direccion.gridy = 2;
		add(textField_Direccion, gbc_textField_Direccion);
		textField_Direccion.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_Nombre = new JTextField();
		GridBagConstraints gbc_textField_Nombre = new GridBagConstraints();
		gbc_textField_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Nombre.gridx = 1;
		gbc_textField_Nombre.gridy = 3;
		add(textField_Nombre, gbc_textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("email:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 5;
		gbc_lblNewLabel_6.gridy = 3;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_email = new JTextField();
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.insets = new Insets(0, 0, 5, 0);
		gbc_textField_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_email.gridx = 6;
		gbc_textField_email.gridy = 3;
		add(textField_email, gbc_textField_email);
		textField_email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido 1:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_Apellido1 = new JTextField();
		GridBagConstraints gbc_textField_Apellido1 = new GridBagConstraints();
		gbc_textField_Apellido1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Apellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Apellido1.gridx = 1;
		gbc_textField_Apellido1.gridy = 4;
		add(textField_Apellido1, gbc_textField_Apellido1);
		textField_Apellido1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("telefono:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 5;
		gbc_lblNewLabel_8.gridy = 4;
		add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		textField_telefono = new JTextField();
		GridBagConstraints gbc_textField_telefono = new GridBagConstraints();
		gbc_textField_telefono.insets = new Insets(0, 0, 5, 0);
		gbc_textField_telefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_telefono.gridx = 6;
		gbc_textField_telefono.gridy = 4;
		add(textField_telefono, gbc_textField_telefono);
		textField_telefono.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido 2:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_Apellido2 = new JTextField();
		GridBagConstraints gbc_textField_Apellido2 = new GridBagConstraints();
		gbc_textField_Apellido2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Apellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Apellido2.gridx = 1;
		gbc_textField_Apellido2.gridy = 5;
		add(textField_Apellido2, gbc_textField_Apellido2);
		textField_Apellido2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("dni:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_dni = new JTextField();
		GridBagConstraints gbc_textField_dni = new GridBagConstraints();
		gbc_textField_dni.insets = new Insets(0, 0, 5, 5);
		gbc_textField_dni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dni.gridx = 1;
		gbc_textField_dni.gridy = 6;
		add(textField_dni, gbc_textField_dni);
		textField_dni.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 7;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		add(panel, gbc_panel);
		
		botomPrimero = new JButton("<<");
		botomPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					cargarPantalla(ControllerProfesor.cargarPrimerRegistro());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(botomPrimero);
		
		botomAnterior = new JButton("<");
		botomAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarPantalla(ControllerProfesor.cargarAnteriorRegistro(textFieldId.getText()));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(botomAnterior);
		
		botomSiguiente = new JButton(">");
		botomSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarPantalla(ControllerProfesor.cargarSiguienteRegistro(textFieldId.getText()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(botomSiguiente);
		
		botomUltimo = new JButton(">>");
		botomUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cargarPantalla(ControllerProfesor.cargarUltimoRegistro());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(botomUltimo);
		
		JButton botomNuevo = new JButton("Nuevo");
		botomNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCeldas();
			}
		});
		panel.add(botomNuevo);
		
		JButton botomInsertar = new JButton("Insertar");
		botomInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardar();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(botomInsertar);
		
		JButton botomEliminar = new JButton("Eliminar");
		botomEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					eliminarRegistro();
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(botomEliminar);
		
		try {
			
			Profesor profesor = null;
			profesor = ControllerProfesor.cargarPrimerRegistro();
			cargarPantalla(profesor);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
/**
 * 
 * 
 * 
 * @param materia
 * @throws SQLException
 */
	
	
	public void limpiarCeldas() {
		textFieldId.setText("" + 0);
		textField_Nombre.setText("");
		textField_Apellido1.setText("");
		textField_Apellido2.setText("");
		textField_dni.setText("");
		textField_telefono.setText("");
		textField_Direccion.setText("");
		textField_email.setText("");
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param materia
	 * @throws SQLException
	 */
	
	public void guardar() throws SQLException {
		Profesor profesorNuevo = new Profesor();
		
		profesorNuevo.setId(Integer.parseInt(textFieldId.getText()));
		profesorNuevo.setNombre(textField_Nombre.getText());
		profesorNuevo.setApellido1(textField_Apellido1.getText());
		profesorNuevo.setApellido2(textField_Apellido2.getText());
		profesorNuevo.setDireccion(textField_Direccion.getText());
		profesorNuevo.setDni(textField_dni.getText());
		profesorNuevo.setEmail(textField_email.getText());
		profesorNuevo.setTelefono(Integer.parseInt(textField_telefono.getText()));
		

		String error = "Algo a fallado";
		if (profesorNuevo.getId() == 0) {
			int nuevoIdInsertado = ControllerProfesor.insertarRegistro(profesorNuevo);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			
			else {
				textFieldId.setText("" + nuevoIdInsertado);
				JOptionPane.showMessageDialog(null, "Se inserto correctamente");
			}
			
		}
		else {
			if (ControllerProfesor.modificarRegistro(profesorNuevo) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
		}
	}
	
	
	public void cargarPantalla(Profesor profesor) throws SQLException {
		botomPrimero.setEnabled(true);
		botomAnterior.setEnabled(true);
		botomUltimo.setEnabled(true);
		botomSiguiente.setEnabled(true); 
		
		textFieldId.setText("" + profesor.getId());
		textField_Nombre.setText(profesor.getNombre());
		textField_Apellido1.setText(profesor.getApellido1());
		textField_Apellido2.setText(profesor.getApellido2());
		textField_Direccion.setText(profesor.getDireccion());
		textField_dni.setText(profesor.getDni());
		textField_email.setText(profesor.getEmail());
		textField_telefono.setText("" + profesor.getTelefono());
		
		
		
		if(profesor.getId() == ControllerProfesor.cargarUltimoRegistro().getId()) {
			botomUltimo.setEnabled(false);
			botomSiguiente.setEnabled(false);
		}
		if(profesor.getId() == ControllerProfesor.cargarPrimerRegistro().getId()) {
			botomPrimero.setEnabled(false);
			botomAnterior.setEnabled(false);
		}
		
		
		
		
	}
	
	public void eliminarRegistro() throws NumberFormatException, SQLException {
		String[] opciones = new String[] {"Si","No"};
		int eleccion = JOptionPane.showOptionDialog(null, "Esta seguro de que desea eliminar el registro", 
				"EliminarRegistro", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
		
		if (eleccion == JOptionPane.YES_OPTION) {
		
			int row = ControllerProfesor.eliminarRegistro(Integer.parseInt(textFieldId.getText()));
			
			if (row !=1) {
				JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR");
			}
			else {
				JOptionPane.showMessageDialog(null, "se ha eliminado correctamente el registro");
				cargarPantalla(ControllerProfesor.cargarUltimoRegistro());
			}
		}
	}

}
