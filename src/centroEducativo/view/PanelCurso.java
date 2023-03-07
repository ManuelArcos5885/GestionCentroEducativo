package centroEducativo.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;

import centroEducativo.controller.ControllerCurso;
import centroEducativo.model.Curso;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class PanelCurso extends JPanel {
	private JTextField textField_Id;
	private JTextField textField_Descrip;

	/**
	 * Create the panel.
	 */
	public PanelCurso() {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblGestionCurso = new JLabel("Gestion Curso");
		lblGestionCurso.setFont(new Font("MathJax_Math", Font.BOLD, 22));
		GridBagConstraints gbc_lblGestionCurso = new GridBagConstraints();
		gbc_lblGestionCurso.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestionCurso.gridx = 2;
		gbc_lblGestionCurso.gridy = 1;
		add(lblGestionCurso, gbc_lblGestionCurso);
		
		JLabel lblId = new JLabel("id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 4;
		add(lblId, gbc_lblId);
		
		textField_Id = new JTextField();
		GridBagConstraints gbc_textField_Id = new GridBagConstraints();
		gbc_textField_Id.gridwidth = 5;
		gbc_textField_Id.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Id.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Id.gridx = 1;
		gbc_textField_Id.gridy = 4;
		add(textField_Id, gbc_textField_Id);
		textField_Id.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 6;
		add(lblDescripcion, gbc_lblDescripcion);
		
		textField_Descrip = new JTextField();
		textField_Descrip.setColumns(10);
		GridBagConstraints gbc_textField_Descrip = new GridBagConstraints();
		gbc_textField_Descrip.gridwidth = 5;
		gbc_textField_Descrip.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Descrip.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Descrip.gridx = 1;
		gbc_textField_Descrip.gridy = 6;
		add(textField_Descrip, gbc_textField_Descrip);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 6;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		
		JButton btnNewButton_2 = new JButton("<<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Curso curso = ControllerCurso.cargarUltimoRegistro();
					textField_Id.setText("" + curso.getId());
					textField_Descrip.setText(curso.getDescripcion());
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_1 = new JButton(">");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_5 = new JButton(">>");
		panel.add(btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 6;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 8;
		add(panel_1, gbc_panel_1);
		
		JButton btnNewButton_4 = new JButton("Nuevo");
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Eliminar");
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton = new JButton("Guardar");
		panel_1.add(btnNewButton);

	}
	
	
	

}
