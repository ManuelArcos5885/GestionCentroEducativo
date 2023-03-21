package centroEducativo2.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class FramePrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		FramePrincipal fp = new FramePrincipal();
		fp.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		JTabbedPane tabedPane = new JTabbedPane();
		
		tabedPane.add("Estudiante",new GestionEstudiante());
		tabedPane.add("Profesor",new GestionProfesor());
		
		
		this.setContentPane(tabedPane);
	}

}
