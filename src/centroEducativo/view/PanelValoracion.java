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
import centroEducativo.controller.ControllerValoracion;
import centroEducativo.model.Curso;
import centroEducativo.model.Estudiante;
import centroEducativo.model.Materia;
import centroEducativo.model.Profesor;
import centroEducativo.model.ValoracionMateria;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelValoracion extends JPanel {
	private JTextField textFieldId;
	JComboBox<Materia> IdMateriaCombo = new JComboBox<Materia>();
	JComboBox<Estudiante> IdEstudianteCombo = new JComboBox<Estudiante>();
	JComboBox<Profesor> idProfesor_comboBox = new JComboBox<Profesor>();
	
	JButton botomPrimero, botomAnterior, botomSiguiente, botomUltimo;
	private JTextField textField_Valoracion;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public PanelValoracion(){
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{150, 154, 0};
//		gridBagLayout.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0, 0};
//		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestion Materia");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.gridx = 0;
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
		gbc_textFieldId.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldId.gridx = 1;
		gbc_textFieldId.gridy = 2;
		add(textFieldId, gbc_textFieldId);
		textFieldId.setColumns(10);
		
		JLabel id_Estudiante = new JLabel("id_Estudiante:");
		GridBagConstraints gbc_id_Estudiante = new GridBagConstraints();
		gbc_id_Estudiante.anchor = GridBagConstraints.EAST;
		gbc_id_Estudiante.insets = new Insets(0, 0, 5, 5);
		gbc_id_Estudiante.gridx = 0;
		gbc_id_Estudiante.gridy = 3;
		add(id_Estudiante, gbc_id_Estudiante);
		
		
		GridBagConstraints gbc_IdEstudianteCombo = new GridBagConstraints();
		gbc_IdEstudianteCombo.insets = new Insets(0, 0, 5, 0);
		gbc_IdEstudianteCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_IdEstudianteCombo.gridx = 1;
		gbc_IdEstudianteCombo.gridy = 3;
		add(IdEstudianteCombo, gbc_IdEstudianteCombo);
		
		JLabel lblNewLabel_3 = new JLabel("Id_Materia: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		
		GridBagConstraints gbc_IdMateriaCombo = new GridBagConstraints();
		gbc_IdMateriaCombo.insets = new Insets(0, 0, 5, 0);
		gbc_IdMateriaCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_IdMateriaCombo.gridx = 1;
		gbc_IdMateriaCombo.gridy = 4;
		add(IdMateriaCombo, gbc_IdMateriaCombo);
		
		JLabel lblNewLabel_4 = new JLabel("Id Profesor:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		GridBagConstraints gbc_idProfesor_comboBox = new GridBagConstraints();
		gbc_idProfesor_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_idProfesor_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_idProfesor_comboBox.gridx = 1;
		gbc_idProfesor_comboBox.gridy = 5;
		add(idProfesor_comboBox, gbc_idProfesor_comboBox);
		
		JLabel lblNewLabel_4_1 = new JLabel("Valoracion:");
		GridBagConstraints gbc_lblNewLabel_4_1 = new GridBagConstraints();
		gbc_lblNewLabel_4_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4_1.gridx = 0;
		gbc_lblNewLabel_4_1.gridy = 6;
		add(lblNewLabel_4_1, gbc_lblNewLabel_4_1);
		
		textField_Valoracion = new JTextField();
		GridBagConstraints gbc_textField_Valoracion = new GridBagConstraints();
		gbc_textField_Valoracion.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Valoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Valoracion.gridx = 1;
		gbc_textField_Valoracion.gridy = 6;
		add(textField_Valoracion, gbc_textField_Valoracion);
		textField_Valoracion.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		
		botomPrimero = new JButton("<<");
		botomPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ValoracionMateria valoracion = null;
					valoracion = ControllerValoracion.cargarPrimerRegistro();
					cargarPantalla(valoracion);
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
					cargarPantalla(ControllerValoracion.cargarAnteriorRegistro(textFieldId.getText()));
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
					cargarPantalla(ControllerValoracion.cargarSiguienteRegistro(textFieldId.getText()));
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
					cargarPantalla(ControllerValoracion.cargarUltimoRegistro());
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
			cargarIdEstudianteEnCombo();
			cargarIdMateriaEnCombo();
			cargarIdProfesorEnCombo();
			
			ValoracionMateria valoracion = null;
			valoracion = ControllerValoracion.cargarPrimerRegistro();
			cargarPantalla(valoracion);
			
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
		IdEstudianteCombo.setSelectedIndex(0);
		IdMateriaCombo.setSelectedIndex(0);
		idProfesor_comboBox.setSelectedIndex(0);
		textField_Valoracion.setText("" + 0);
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param materia
	 * @throws SQLException
	 */
	
	public void guardar() throws SQLException {
		ValoracionMateria valoracionNueva = new ValoracionMateria();
		
		valoracionNueva.setId(Integer.parseInt(textFieldId.getText()));
		
		Estudiante estudiante = (Estudiante) IdEstudianteCombo.getSelectedItem();
		Profesor profesor = (Profesor) idProfesor_comboBox.getSelectedItem();
		Materia materia = (Materia) IdMateriaCombo.getSelectedItem();
		
		valoracionNueva.setIdEstudiante(estudiante.getId());
		valoracionNueva.setIdProfesor(profesor.getId());
		valoracionNueva.setIdMateria(materia.getId());
		
		valoracionNueva.setValoracion(Integer.parseInt(textField_Valoracion.getText()));
		
		
		
		String error = "Algo a fallado";
		if (valoracionNueva.getId() == 0) {
			int nuevoIdInsertado = ControllerValoracion.insertarRegistro(valoracionNueva);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			
			else {
				textFieldId.setText("" + nuevoIdInsertado);
				JOptionPane.showMessageDialog(null, "Se inserto correctamente");
			}
			
		}
		else {
			if (ControllerValoracion.modificarRegistro(valoracionNueva) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
		}
	}
	
	
	public void cargarPantalla(ValoracionMateria valoracion) throws SQLException {
		botomPrimero.setEnabled(true);
		botomAnterior.setEnabled(true);
		botomUltimo.setEnabled(true);
		botomSiguiente.setEnabled(true); 
		
		textFieldId.setText("" + valoracion.getId());
		
		textField_Valoracion.setText("" + valoracion.getValoracion());
		for (int i = 0; i < idProfesor_comboBox.getItemCount(); i++) {
			
			if (valoracion.getIdProfesor() == idProfesor_comboBox.getItemAt(i).getId()) {
				idProfesor_comboBox.setSelectedIndex(i);
			}
			
		}
		for (int i = 0; i < IdEstudianteCombo.getItemCount(); i++) {
					
			if (valoracion.getIdEstudiante() == IdEstudianteCombo.getItemAt(i).getId()) {
				IdEstudianteCombo.setSelectedIndex(i);
			}
			
		}
		for (int i = 0; i < IdMateriaCombo.getItemCount(); i++) {
			
			if (valoracion.getIdMateria() == IdMateriaCombo.getItemAt(i).getId()) {
				IdMateriaCombo.setSelectedIndex(i);
			}
			
		}
		
		if(valoracion.getId() == ControllerValoracion.cargarPrimerRegistro().getId()) {
			botomPrimero.setEnabled(false);
			botomAnterior.setEnabled(false);
		}
		if(valoracion.getId() == ControllerValoracion.cargarUltimoRegistro().getId()) {
			botomUltimo.setEnabled(false);
			botomSiguiente.setEnabled(false);
		}
		
		
		
		
	}
	
	public void cargarIdMateriaEnCombo() throws SQLException {
		List<Materia> materias = ControllerMateria.cargarTodasId();
		for (Materia materia : materias) {
			IdMateriaCombo.addItem(materia);
		}
	}
	
	public void cargarIdProfesorEnCombo() throws SQLException {
		List<Profesor> profesores = ControllerProfesor.cargarTodasId();
		for (Profesor profesor : profesores) {
			idProfesor_comboBox.addItem(profesor);
		}
	}
	
	public void cargarIdEstudianteEnCombo() throws SQLException {
		List<Estudiante> estudiantes = ControllerEstudiante.cargarTodasId();

		for (Estudiante estudiante : estudiantes) {
			IdEstudianteCombo.addItem(estudiante);
		}
	}
	
	public void eliminarRegistro() throws NumberFormatException, SQLException {
		String[] opciones = new String[] {"Si","No"};
		int eleccion = JOptionPane.showOptionDialog(null, "Esta seguro de que desea eliminar el registro", 
				"EliminarRegistro", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opciones, "Si");
		
		if (eleccion == JOptionPane.YES_OPTION) {
		
			int row = ControllerMateria.eliminarRegistro(Integer.parseInt(textFieldId.getText()));
			
			if (row !=1) {
				JOptionPane.showMessageDialog(null, "HA OCURRIDO UN ERROR");
			}
			else {
				JOptionPane.showMessageDialog(null, "se ha eliminado correctamente el registro");
				cargarPantalla(ControllerValoracion.cargarUltimoRegistro());
			}
		}
	}

}
