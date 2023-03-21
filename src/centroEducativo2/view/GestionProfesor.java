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

public class GestionProfesor extends JPanel {
	DatosPersonales datospersonales;
	/**
	 * Create the panel.
	 */
	
	public GestionProfesor() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{212, 219, 0};
//		gridBagLayout.rowHeights = new int[]{134, 300, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestionDeProfesores = new JLabel("Gestion de Profesores");
		lblGestionDeProfesores.setFont(new Font("FreeSans", Font.BOLD, 20));
		GridBagConstraints gbc_lblGestionDeProfesores = new GridBagConstraints();
		gbc_lblGestionDeProfesores.weightx = 1.0;
		gbc_lblGestionDeProfesores.insets = new Insets(0, 0, 5, 0);
		gbc_lblGestionDeProfesores.gridx = 1;
		gbc_lblGestionDeProfesores.gridy = 2;
		add(lblGestionDeProfesores, gbc_lblGestionDeProfesores);
		
		datospersonales = new DatosPersonales();
		GridBagConstraints gbc_datospersonales = new GridBagConstraints();
		gbc_datospersonales.insets = new Insets(0, 0, 5, 0);
		gbc_datospersonales.fill = GridBagConstraints.HORIZONTAL;
		gbc_datospersonales.weightx = 1.0;
		gbc_datospersonales.gridx = 1;
		gbc_datospersonales.gridy = 3;
		add(datospersonales, gbc_datospersonales);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weightx = 1.0;
		gbc_panel.weighty = 1.0;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton botomPrimero = new JButton("<<");
		botomPrimero.setEnabled(true);
		panel_1.add(botomPrimero);
		
		JButton botomAnterior = new JButton("<");
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
	

}
