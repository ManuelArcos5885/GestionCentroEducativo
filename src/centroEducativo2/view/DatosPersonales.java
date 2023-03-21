package centroEducativo2.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class DatosPersonales extends JPanel {
	private JTextField textField_id;
	private JTextField textField_Nombre;
	private JTextField textField_Apellido1;
	private JTextField textField_Apellido2;
	private JTextField textField_dni;
	private JTextField textField_direccion;
	private JTextField textField_email;
	private JTextField textField_telefono;
	public DatosPersonales() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
//		gridBagLayout.columnWidths = new int[]{0};
//		gridBagLayout.rowHeights = new int[]{0};
//		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		textField_id = new JTextField();
		GridBagConstraints gbc_textField_id = new GridBagConstraints();
		gbc_textField_id.insets = new Insets(0, 0, 5, 0);
		gbc_textField_id.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_id.gridx = 2;
		gbc_textField_id.gridy = 2;
		add(textField_id, gbc_textField_id);
		textField_id.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_Nombre = new JTextField();
		textField_Nombre.setColumns(10);
		GridBagConstraints gbc_textField_Nombre = new GridBagConstraints();
		gbc_textField_Nombre.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Nombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Nombre.gridx = 2;
		gbc_textField_Nombre.gridy = 3;
		add(textField_Nombre, gbc_textField_Nombre);
		
		JLabel lblApellido = new JLabel("Apellido1:");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellido.gridx = 1;
		gbc_lblApellido.gridy = 4;
		add(lblApellido, gbc_lblApellido);
		
		textField_Apellido1 = new JTextField();
		textField_Apellido1.setColumns(10);
		GridBagConstraints gbc_textField_Apellido1 = new GridBagConstraints();
		gbc_textField_Apellido1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Apellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Apellido1.gridx = 2;
		gbc_textField_Apellido1.gridy = 4;
		add(textField_Apellido1, gbc_textField_Apellido1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido2:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_Apellido2 = new JTextField();
		textField_Apellido2.setColumns(10);
		GridBagConstraints gbc_textField_Apellido2 = new GridBagConstraints();
		gbc_textField_Apellido2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_Apellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Apellido2.gridx = 2;
		gbc_textField_Apellido2.gridy = 5;
		add(textField_Apellido2, gbc_textField_Apellido2);
		
		JLabel lblNewLabel_2_1 = new JLabel("dni:");
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 6;
		add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		textField_dni = new JTextField();
		textField_dni.setColumns(10);
		GridBagConstraints gbc_textField_dni = new GridBagConstraints();
		gbc_textField_dni.insets = new Insets(0, 0, 5, 0);
		gbc_textField_dni.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dni.gridx = 2;
		gbc_textField_dni.gridy = 6;
		add(textField_dni, gbc_textField_dni);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("direccion:");
		GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1.gridy = 7;
		add(lblNewLabel_2_1_1, gbc_lblNewLabel_2_1_1);
		
		textField_direccion = new JTextField();
		textField_direccion.setColumns(10);
		GridBagConstraints gbc_textField_direccion = new GridBagConstraints();
		gbc_textField_direccion.insets = new Insets(0, 0, 5, 0);
		gbc_textField_direccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_direccion.gridx = 2;
		gbc_textField_direccion.gridy = 7;
		add(textField_direccion, gbc_textField_direccion);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("email:");
		GridBagConstraints gbc_lblNewLabel_2_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2_1_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1_1.gridy = 8;
		add(lblNewLabel_2_1_1_1, gbc_lblNewLabel_2_1_1_1);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		GridBagConstraints gbc_textField_email = new GridBagConstraints();
		gbc_textField_email.insets = new Insets(0, 0, 5, 0);
		gbc_textField_email.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_email.gridx = 2;
		gbc_textField_email.gridy = 8;
		add(textField_email, gbc_textField_email);
		
		JLabel lblNewLabel_3 = new JLabel("telefono:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 9;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_telefono = new JTextField();
		textField_telefono.setColumns(10);
		GridBagConstraints gbc_textField_telefono = new GridBagConstraints();
		gbc_textField_telefono.insets = new Insets(0, 0, 5, 0);
		gbc_textField_telefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_telefono.gridx = 2;
		gbc_textField_telefono.gridy = 9;
		add(textField_telefono, gbc_textField_telefono);
	}
	
	public void setId(int id) {
		textField_id.setText("" + id);
	}
	public void setApellido1(String id) {
		textField_Apellido1.setText("" + id);
	}
	public void setApellido2(String id) {
		textField_Apellido2.setText("" + id);
	}
	public void setDireccion(String id) {
		textField_direccion.setText("" + id);
	}
	public void setEmail(String id) {
		textField_email.setText("" + id);
	}
	public void setNombre(String id) {
		textField_Nombre.setText("" + id);
	}
	public void setTelefono(int id) {
		textField_telefono.setText("" + id);
	}
	public void setDni(int id) {
		textField_dni.setText("" + id);
	}
	/**
	 * 
	 * 
	 * @return
	 */
	public String getId() {
		return textField_id.getText();
	}
	public String getApellido1() {
		return textField_Apellido1.getText();
	}
	public String getApellido2() {
		return textField_Apellido2.getText();
	}
	public String getDireccion() {
		return textField_direccion.getText();
	}
	public String getDni() {
		return textField_dni.getText();
	}
	public String getEmail() {
		return textField_email.getText();
	}
	public String getNombre() {
		return textField_Nombre.getText();
	}
	public String getTelefono() {
		return textField_telefono.getText();
	}
	
	

}
