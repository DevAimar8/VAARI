package PANELES;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class RecordarContrasena extends JFrame {

//	Clase que se implementara en un futuro para que los usuarios puedan recuperar sus claves
//	aun no tenemos esta funcionalidad activada ya que nos haría falta poder mandar correos de confirmacion a los diferentes emails
//	de los usuarios pero una futura actualizacion de la app llegara 
	
	private static final long serialVersionUID = 1L;
	private JPanel FONDO;
	private JPasswordField CampoContrasena;
	private JPasswordField CampoNuevaContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecordarContrasena frame = new RecordarContrasena();
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
	public RecordarContrasena() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 669);
		
		FONDO = new JPanel();
		FONDO.setBackground(new Color(255, 255, 255));
		FONDO.setForeground(new Color(0, 0, 0));
		FONDO.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(FONDO);
		FONDO.setLayout(null);
		
		JButton BotonCambioContrasena = new JButton("Cambiar Contraseña");
		BotonCambioContrasena.setBorder(new LineBorder(Color.WHITE, 2)); // Cambio el color del borde a BLANCO con un ancho de 2 píxeles
		BotonCambioContrasena.setForeground(new Color(255, 255, 255));
		BotonCambioContrasena.setBackground(new Color(72, 209, 204));
		BotonCambioContrasena.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BotonCambioContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				InicioSesion IrInicio = new InicioSesion();
				IrInicio.setVisible(true);
			}
		});
		BotonCambioContrasena.setBounds(149, 373, 210, 56);
		FONDO.add(BotonCambioContrasena);
		
		JLabel fotoCandado = new JLabel("");
		fotoCandado.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\ICONOS\\ICONOS\\CANDADO REPIX.png"));
		fotoCandado.setBounds(226, 439, 69, 50);
		FONDO.add(fotoCandado);
		
		CampoNuevaContrasena = new JPasswordField();
		CampoNuevaContrasena.setBounds(226, 255, 210, 20);
		FONDO.add(CampoNuevaContrasena);
		
		CampoContrasena = new JPasswordField();
		CampoContrasena.setBounds(226, 297, 210, 20);
		FONDO.add(CampoContrasena);
		
		JLabel Etiqueta_NContrasana = new JLabel("Nueva Contraseña");
		Etiqueta_NContrasana.setForeground(new Color(255, 128, 192));
		Etiqueta_NContrasana.setFont(new Font("Tahoma", Font.BOLD, 14));
		Etiqueta_NContrasana.setBounds(50, 247, 166, 30);
		FONDO.add(Etiqueta_NContrasana);
		
		JLabel Etiqueta_VerificarContrasena = new JLabel("Repetir Contraseña");
		Etiqueta_VerificarContrasena.setForeground(new Color(255, 128, 192));
		Etiqueta_VerificarContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		Etiqueta_VerificarContrasena.setBounds(50, 289, 166, 30);
		FONDO.add(Etiqueta_VerificarContrasena);

	
		JLabel FOTO_FONDO = new JLabel("");
		FOTO_FONDO.setBackground(new Color(127, 255, 212));
		FOTO_FONDO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		FOTO_FONDO.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\ICONOS\\aaaaaaaaaaaaa.png"));
		FOTO_FONDO.setBounds(0, 0, 497, 630);
		FONDO.add(FOTO_FONDO);
		
	

	}
}