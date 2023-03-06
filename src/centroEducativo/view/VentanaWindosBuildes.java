package centroEducativo.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;

import centroEducativo.ConnectionManager;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class VentanaWindosBuildes extends JFrame {

	private JPanel contentPane;
	private JTextField jtfid;
	private JTextField jtfDescripcion;
	private JButton btnCargarResitroAnterior;
	private JButton btnCargarPrimarRegistro;
	private JButton btnCargarSiguienteRegistro;
	private JButton btnCargarUltimoRegistro;
	
	private Connection conn = null;
	private JPanel panel_1;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEliminar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaWindosBuildes frame = new VentanaWindosBuildes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaWindosBuildes() {
		try {
			conn = ConnectionManager.getConexion();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblGestionDatosCurso = new JLabel("Gestion Datos Cursos");
		lblGestionDatosCurso.setFont(new Font("DejaVu Serif", Font.BOLD, 22));
		GridBagConstraints gbc_lblGestionDatosCurso = new GridBagConstraints();
		gbc_lblGestionDatosCurso.gridwidth = 2;
		gbc_lblGestionDatosCurso.insets = new Insets(0, 0, 15, 0);
		gbc_lblGestionDatosCurso.gridx = 0;
		gbc_lblGestionDatosCurso.gridy = 0;
		contentPane.add(lblGestionDatosCurso, gbc_lblGestionDatosCurso);
		
		JLabel lblId = new JLabel("id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 1;
		contentPane.add(lblId, gbc_lblId);
		
		jtfid = new JTextField();
		GridBagConstraints gbc_jtfid = new GridBagConstraints();

		gbc_jtfid.weightx = 1.0;
		gbc_jtfid.insets = new Insets(0, 0, 5, 0);
		gbc_jtfid.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfid.gridx = 1;
		gbc_jtfid.gridy = 1;
		contentPane.add(jtfid, gbc_jtfid);
		jtfid.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("descripción:");
		GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
		gbc_lblDescripcion.anchor = GridBagConstraints.EAST;
		gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcion.gridx = 0;
		gbc_lblDescripcion.gridy = 2;
		contentPane.add(lblDescripcion, gbc_lblDescripcion);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.weightx = 1.0;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 2;
		contentPane.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		contentPane.add(panel_1, gbc_panel_1);
		
		btnCargarPrimarRegistro = new JButton("<<");
		panel_1.add(btnCargarPrimarRegistro);
		btnCargarPrimarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimerRegistro();
			}
		});
		
		btnCargarResitroAnterior = new JButton("<");
		btnCargarResitroAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnteriorRegistro();
			}
		});
		panel_1.add(btnCargarResitroAnterior);
		
		btnCargarSiguienteRegistro = new JButton(">");
		btnCargarSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguienteRegistro();
			}
		});
		panel_1.add(btnCargarSiguienteRegistro);
		
		btnCargarUltimoRegistro = new JButton(">>");
		btnCargarUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimoRegistro();
			}
		});
		panel_1.add(btnCargarUltimoRegistro);
		
		btnNuevo = new JButton("N");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNuevo);
		
		btnEliminar = new JButton("E");
		panel_1.add(btnEliminar);
		
		btnGuardar = new JButton("G");
		panel_1.add(btnGuardar);
	}
	
	
	
	/**
	 * 
	 * 
	 */
	
	private void cargarPrimerRegistro() {
		try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from centroeducativo.curso order by id limit 1;");
			
			if (rs.next()) {
				this.jtfid.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
			rs.close();
			st.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	private void cargarSiguienteRegistro() {
		try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from centroeducativo.curso where id > " + jtfid.getText() + " order by id limit 1;");
			
			if (rs.next()) {
				this.jtfid.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
			rs.close();
			st.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	private void cargarAnteriorRegistro() {
		try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from centroeducativo.curso where id < " + jtfid.getText() + " order by id desc limit 1;");
			
			if (rs.next()) {
				this.jtfid.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
			rs.close();
			st.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	/**
	 * 
	 * 
	 */
	
	private void cargarUltimoRegistro() {
		try {
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery("Select * from centroeducativo.curso order by id desc limit 1;");
			
			if (rs.next()) {
				this.jtfid.setText(rs.getString(1));
				this.jtfDescripcion.setText(rs.getString(2));
			}
			rs.close();
			st.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}


}
