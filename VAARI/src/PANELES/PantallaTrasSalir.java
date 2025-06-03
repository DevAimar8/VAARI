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
import java.awt.Color;

public class PantallaTrasSalir extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel FONDO;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaTrasSalir frame = new PantallaTrasSalir();
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
	public PantallaTrasSalir() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 669);
		
		FONDO = new JPanel();
		FONDO.setBackground(new Color(255, 255, 255));
		FONDO.setForeground(new Color(0, 0, 0));
		FONDO.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(FONDO);
		FONDO.setLayout(null);
		
		JButton BotonRegistro = new JButton("Iniciar Sesion");
		BotonRegistro.setBorder(new LineBorder(Color.WHITE, 2)); // Cambio el color del borde a BLANCO con un ancho de 2 píxeles
		BotonRegistro.setForeground(new Color(255, 255, 255));
		BotonRegistro.setBackground(new Color(72, 209, 204));
		BotonRegistro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BotonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				InicioSesion Inicio = new InicioSesion();
				Inicio.setVisible(true);
			}
		});
		BotonRegistro.setBounds(178, 273, 143, 56);
		FONDO.add(BotonRegistro);
		
		JButton BOTON_OLVIDADA = new JButton("Crear cuenta");
		BOTON_OLVIDADA.setBorder(new LineBorder(Color.WHITE, 2)); // Cambio el color del borde a BLANCO con un ancho de 2 píxeles
		BOTON_OLVIDADA.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
				
				Registro registronuevo = new Registro();
				registronuevo.setVisible(true);
				dispose();				
				
			}
		});
		BOTON_OLVIDADA.setBackground(new Color(255, 255, 255));
		BOTON_OLVIDADA.setForeground(new Color(0, 0, 128));
		BOTON_OLVIDADA.setBounds(156, 341, 188, 23);
		FONDO.add(BOTON_OLVIDADA);
		
		
		
		
	
		JLabel FOTO_FONDO = new JLabel("");
		FOTO_FONDO.setBackground(new Color(127, 255, 212));
		FOTO_FONDO.setFont(new Font("Tahoma", Font.PLAIN, 12));
		FOTO_FONDO.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\GRAFICOS\\GRAFICOS\\FONDOS\\aaaaaaaaaaaaa.png"));
		FOTO_FONDO.setBounds(0, 0, 497, 630);
		FONDO.add(FOTO_FONDO);
		
		
		
		
	}
}