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
import centroEducativo.controller.ControllerMateria;
import centroEducativo.model.Curso;
import centroEducativo.model.Materia;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class PanelMateria extends JPanel {
	private JTextField textFieldId;
	private JTextField textField_Nombre;
	private JTextField textField_Acronimo;
	JComboBox<Curso> IdCursoCombo = new JComboBox<Curso>();
	
	JButton botomPrimero, botomAnterior, botomSiguiente, botomUltimo;
	/**
	 * Create the panel.
	 * @throws SQLException 
	 */
	public PanelMateria(){
		GridBagLayout gridBagLayout = new GridBagLayout();
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
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_Nombre = new JTextField();
		GridBagConstraints gbc_textField_Nombre = new GridBagConstraints();
		gbc_textField_Nombre.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Nombre.gridx = 1;
		gbc_textField_Nombre.gridy = 3;
		add(textField_Nombre, gbc_textField_Nombre);
		textField_Nombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Acronimo: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_Acronimo = new JTextField();
		GridBagConstraints gbc_textField_Acronimo = new GridBagConstraints();
		gbc_textField_Acronimo.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Acronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Acronimo.gridx = 1;
		gbc_textField_Acronimo.gridy = 4;
		add(textField_Acronimo, gbc_textField_Acronimo);
		textField_Acronimo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Id curso:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		
		GridBagConstraints gbc_IdCursoCombo = new GridBagConstraints();
		gbc_IdCursoCombo.insets = new Insets(0, 0, 5, 0);
		gbc_IdCursoCombo.fill = GridBagConstraints.HORIZONTAL;
		gbc_IdCursoCombo.gridx = 1;
		gbc_IdCursoCombo.gridy = 5;
		add(IdCursoCombo, gbc_IdCursoCombo);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		
		botomPrimero = new JButton("<<");
		botomPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Materia materia = null;
					materia = ControllerMateria.cargarPrimerRegistro();
					cargarPantalla(materia);
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
					cargarPantalla(ControllerMateria.cargarAnteriorRegistro(textFieldId.getText()));
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
					cargarPantalla(ControllerMateria.cargarSiguienteRegistro(textFieldId.getText()));
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
					cargarPantalla(ControllerMateria.cargarUltimoRegistro());
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
		panel.add(botomEliminar);
		
		try {
			cargarIdCursoEnCombo();
			Materia materia = null;
			materia = ControllerMateria.cargarPrimerRegistro();
			cargarPantalla(materia);
			
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
		textField_Acronimo.setText("");
		IdCursoCombo.setSelectedIndex(0);
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param materia
	 * @throws SQLException
	 */
	
	public void guardar() throws SQLException {
		Materia materiaNueva = new Materia();
		
		materiaNueva.setId(Integer.parseInt(textFieldId.getText()));
		materiaNueva.setNombre(textField_Nombre.getText());
		materiaNueva.setAcronimo(textField_Acronimo.getText());
		Curso curso = (Curso) IdCursoCombo.getSelectedItem();
		
		materiaNueva.setCursoId(curso.getId());
		String error = "Algo a fallado";
		if (materiaNueva.getId() == 0) {
			int nuevoIdInsertado = ControllerMateria.insertarRegistro(materiaNueva);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, error);
			}
			
			else {
				textFieldId.setText("" + nuevoIdInsertado);
				JOptionPane.showMessageDialog(null, "Se inserto correctamente");
			}
			
		}
		else {
			if (ControllerMateria.modificarRegistro(materiaNueva) != 1) {
				JOptionPane.showMessageDialog(null, error);
			}
		}
	}
	
	
	public void cargarPantalla(Materia materia) throws SQLException {
		botomPrimero.setEnabled(true);
		botomAnterior.setEnabled(true);
		botomUltimo.setEnabled(true);
		botomSiguiente.setEnabled(true); 
		
		textFieldId.setText("" + materia.getId());
		textField_Nombre.setText(materia.getNombre());
		textField_Acronimo.setText(materia.getAcronimo());
		
		for (int i = 0; i < IdCursoCombo.getItemCount(); i++) {
			
			if (materia.getCursoId() == IdCursoCombo.getItemAt(i).getId()) {
				IdCursoCombo.setSelectedIndex(i);
			}
			
		}
		
		if(materia.getId() == IdCursoCombo.getItemAt(0).getId()) {
			botomPrimero.setEnabled(false);
			botomAnterior.setEnabled(false);
		}
		if(materia.getId() == ControllerMateria.cargarUltimoRegistro().getId()) {
			botomUltimo.setEnabled(false);
			botomSiguiente.setEnabled(false);
		}
		
		
		
		
	}
	
	public void cargarIdCursoEnCombo() throws SQLException {
		List<Curso> cursos = ControllerCurso.cargarTodasId();
		for (Curso curso : cursos) {
			IdCursoCombo.addItem(curso);
		}
	}

}
