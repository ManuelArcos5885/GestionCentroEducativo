package centroEducativo2.view;

import javax.swing.JPanel;

import centroEducativo.controller.ControllerEstudiante;
import centroEducativo.controller.ControllerMateria;
import centroEducativo.model.Estudiante;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class GestionEstudiante extends JPanel {
	JButton botomPrimero, botomAnterior, botomSiguiente, botomUltimo;
	/**
	 * Create the panel.
	 */
	public GestionEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{1.0};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.columnWeights = new double[]{1.0};
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestionDeCurso = new JLabel("Gestion de Estudiante");
		lblGestionDeCurso.setFont(new Font("FreeSans", Font.BOLD, 20));
		GridBagConstraints gbc_lblGestionDeCurso = new GridBagConstraints();
		gbc_lblGestionDeCurso.weightx = 1.0;
		gbc_lblGestionDeCurso.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestionDeCurso.gridx = 0;
		gbc_lblGestionDeCurso.gridy = 0;
		add(lblGestionDeCurso, gbc_lblGestionDeCurso);
		
		DatosPersonales datospersonales = new DatosPersonales();
		GridBagLayout gridBagLayout_1 = (GridBagLayout) datospersonales.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout_1.columnWeights = new double[]{0.0, 0.0, 1.0};
		gridBagLayout_1.columnWidths = new int[]{0, 0, 0};
		GridBagConstraints gbc_datospersonales = new GridBagConstraints();
		gbc_datospersonales.insets = new Insets(0, 0, 5, 0);
		gbc_datospersonales.fill = GridBagConstraints.HORIZONTAL;
		gbc_datospersonales.gridx = 0;
		gbc_datospersonales.gridy = 1;
		add(datospersonales, gbc_datospersonales);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		
		
		
		botomPrimero = new JButton("<<");
		botomPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					cargarPantalla(ControllerEstudiante.cargarPrimerRegistro());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_1.add(botomPrimero);
		
		botomAnterior = new JButton("<");
		botomAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botomAnterior.setEnabled(true);
		panel_1.add(botomAnterior);
		
		JButton botomSiguiente = new JButton(">");
		botomSiguiente.setEnabled(true);
		panel_1.add(botomSiguiente);
		
		JButton botomUltimo = new JButton(">>");
		botomUltimo.setEnabled(true);
		panel_1.add(botomUltimo);
		
		JButton botomNuevo = new JButton("Nuevo");
		panel_1.add(botomNuevo);
		
		JButton botomInsertar = new JButton("Insertar");
		panel_1.add(botomInsertar);
		
		JButton botomEliminar = new JButton("Eliminar");
		panel_1.add(botomEliminar);
		
		

	}
	
	/**
	 * 
	 * 
	 * 
	 */
	
	public void cargarPantalla(Estudiante estudiante) throws SQLException {
		botomPrimero.setEnabled(true);
		botomAnterior.setEnabled(true);
		botomUltimo.setEnabled(true);
		botomSiguiente.setEnabled(true); 
		
		textFieldId.setText("" + estudiante.getId());
		textField_Nombre.setText(estudiante.getNombre());
		textField_Apellido1.setText(estudiante.getApellido1());
		textField_Apellido2.setText(estudiante.getApellido2());
		textField_Direccion.setText(estudiante.getDireccion());
		textField_dni.setText(estudiante.getDni());
		textField_email.setText(estudiante.getEmail());
		textField_telefono.setText("" + estudiante.getTelefono());
		
		
		
		if(estudiante.getId() == ControllerEstudiante.cargarUltimoRegistro().getId()) {
			botomUltimo.setEnabled(false);
			botomSiguiente.setEnabled(false);
		}
		if(estudiante.getId() == ControllerMateria.cargarPrimerRegistro().getId()) {
			botomPrimero.setEnabled(false);
			botomAnterior.setEnabled(false);
		}
		
		
		
		
	}
}
