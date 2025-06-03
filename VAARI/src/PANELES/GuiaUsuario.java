package PANELES;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class GuiaUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel FONDO;

	/**
	 * Launch the application.
	 */
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GuiaUsuario frame = new GuiaUsuario();
//					//// Obtener la resolución de la pantalla del ordenador en este caso
//					Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
//					//// Establecer el tamaño del JFrame para que coincida con la resolución de la pantalla
//					frame.setSize(screenSize);
//					// Establecer el JFrame en modo de pantalla completa
//					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
	public GuiaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 603);
		
		JMenuBar menuBar = new JMenuBar();
		
		menuBar.setBackground(new Color(255, 128, 192));
		menuBar.setBorder(new LineBorder(Color.WHITE, 0));
		setJMenuBar(menuBar);
		
		JMenu MenuLista = new JMenu("Menú");
		MenuLista.setForeground(new Color(0, 0, 0));
		MenuLista.setBackground(new Color(255, 255, 255));
		menuBar.add(MenuLista);
		
		JLabel HoraMenu = new JLabel("Hora");
		HoraMenu.setBackground(new Color(255, 255, 255));
		HoraMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MenuLista.add(HoraMenu);
//		lblNewLabel_1.setBackground(Color.WHITE); // Cambia Color.white por el color deseado
//		lblNewLabel_1.setOpaque(false); // Asegura que el JLabel sea opaco para mostrar el color de fondo
		Thread te = new Thread(() -> {
            while (true) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaActual = sdf.format(new Date());
                HoraMenu.setText("Fecha: " + fechaActual);
                try {
                    Thread.sleep(1000); // Esperar 1 segundo antes de actualizar la fecha
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        te.start();
    
		
		JMenuItem IrAnciano = new JMenuItem("Ancianos");
		IrAnciano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Anciano Anciano = new Anciano();
				Anciano.setVisible(true);
				dispose();				}
		});
		IrAnciano.setHorizontalAlignment(SwingConstants.LEFT);
		IrAnciano.setBackground(new Color(255, 255, 255));
		MenuLista.add(IrAnciano);
				

		
		JMenuItem IrChat = new JMenuItem("Chat");
		IrChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ChatBot ChatBot = new ChatBot();
				ChatBot.setVisible(true);
				dispose();
			}
		});
		IrChat.setBackground(new Color(255, 255, 255));
		MenuLista.add(IrChat);
		
		
		
		JMenuItem IrMenuPrincipal = new JMenuItem("Menú");
		IrMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MenuPrincipal MenuPrincipal = new MenuPrincipal();
				MenuPrincipal.setVisible(true);
				dispose();
			}
		});
		IrMenuPrincipal.setBackground(new Color(255, 255, 255));
		MenuLista.add(IrMenuPrincipal);

		JMenuItem IrCalendario = new JMenuItem("Calendario");
		IrCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CalendarioInterfaz irCalendario = new CalendarioInterfaz();
				irCalendario.setVisible(true);
				dispose();
			}
		});
		IrCalendario.setBackground(new Color(255, 255, 255));
		MenuLista.add(IrCalendario);
		
		JMenuItem Salir = new JMenuItem("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PantallaTrasSalir salir = new PantallaTrasSalir();
				salir.setVisible(true);
				dispose();			}
		});
		Salir.setBackground(new Color(255, 255, 255));
		MenuLista.add(Salir);
		
		JMenu Ayuda = new JMenu("Ayuda");
		Ayuda.setForeground(new Color(0, 0, 0));
		Ayuda.setBackground(new Color(255, 255, 255));
		Ayuda.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(Ayuda);
		
		JMenuItem SobreVAARI = new JMenuItem("Sobre Vaari");
		SobreVAARI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SobreVaari SobreVaari = new SobreVaari();
				SobreVaari.setVisible(true);
				dispose();
			}
		});
		SobreVAARI.setBackground(new Color(255, 255, 255));
		Ayuda.add(SobreVAARI);
		
		JMenuItem Soporte = new JMenuItem("Soporte");
		Soporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Soporte Soporte = new Soporte();
				Soporte.setVisible(true);
				dispose();
			}
		});
		Soporte.setBackground(new Color(255, 255, 255));
		Ayuda.add(Soporte);
		
		JMenuItem Contacto = new JMenuItem("Guía");
		Contacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GuiaUsuario GuiaUsuario = new GuiaUsuario();
				GuiaUsuario.setVisible(true);
				dispose();
			}
		});
		Contacto.setBackground(new Color(255, 255, 255));
		Ayuda.add(Contacto);
		FONDO = new JPanel();
		FONDO.setBounds(0, 0, 497, 630);
		FONDO.setBackground(new Color(255, 255, 255));
		FONDO.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(FONDO);
		FONDO.setLayout(null);
		
		JTextPane SobreVaari = new JTextPane();
		SobreVaari.setForeground(new Color(255, 153, 204));
		SobreVaari.setFont(new Font("Tahoma", Font.BOLD, 12));
		SobreVaari.setText("Guía de Usuario de VAARI\r\n\r\n¡Bienvenido a VAARI ! Esta guía te ayudará a aprovechar al máximo nuestra aplicación, diseñada para mejorar la calidad de vida de las personas mayores y aquellos que requieren cuidado remoto. Sigue estos pasos para comenzar:\r\n\r\nRegistro y Inicio de Sesión:\r\n\r\nSi eres un nuevo usuario, regístrate en VAARI creando una cuenta con tu información personal.\r\nUna vez registrado, inicia sesión utilizando tu nombre de usuario y contraseña.\r\n\r\nFuncionalidades Principales:\r\n\r\nMonitorización de Salud: Descubre cómo utilizar la función de monitorización de salud para realizar un seguimiento de tus signos vitales y recibir alertas en caso de anomalías.\r\nComunicación con Familiares y Cuidadores: Aprende cómo utilizar la función de comunicación para mantenerte en contacto con tus familiares y cuidadores, compartiendo mensajes y actualizaciones fácilmente.\r\nPreferencias de Notificación: Configura tus preferencias de notificación para recibir alertas y recordatorios según tus necesidades y horarios.\r\n\r\n\r\n¡Y eso es todo! Con esta guía de usuario, estarás listo para comenzar a utilizar VAARI con confianza y mejorar tu experiencia de cuidado remoto y bienestar. ¡Gracias por elegir VAARI y esperamos que disfrutes de nuestra aplicación!\r\n\r\n");
		SobreVaari.setBounds(112, 0, 441, 458);
		FONDO.add(SobreVaari);	
		SobreVaari.setOpaque(false);
		
		JLabel Hora = new JLabel("HORA");
		Hora.setHorizontalAlignment(SwingConstants.CENTER);
		Hora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Hora.setBounds(415, 439, 245, 120);
		FONDO.add(Hora);
		
		JLabel LABEL_FONDO = new JLabel("");
		LABEL_FONDO.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\GRAFICOS\\GRAFICOS\\FONDOS\\Fondito.png"));
		LABEL_FONDO.setBounds(0, 0, 633, 544);
		FONDO.add(LABEL_FONDO);
		Thread t = new Thread(() -> {
            while (true) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String horaActual = sdf.format(new Date());
                Hora.setText(horaActual);
                Hora.setText("Hora Actual: " + horaActual);
                try {
                    Thread.sleep(1000); // Esperar 1 segundo antes de actualizar la hora
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
		
