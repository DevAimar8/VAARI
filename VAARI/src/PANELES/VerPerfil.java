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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class VerPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel FONDO;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	
	
	
//	Hemos creido conveniente empezar ya algunas nuevas interfaces y funcionalidades que iremos aportando en 
//	nuevas actualizacion de la app, aun no esta disponible ver perfil por lo que ahora mismo solo podremos
//	ver una foto del usuario o un icono e¡reemplazando si no hubiese foto
//	
//	La idea de esta interfaz es que vaya haga una consulta a la base de datos y nos devuelva todos los datos de nuestro usuario
//	en modo de desplegable 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					VerPerfil frame = new VerPerfil();
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
	public VerPerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 381);
		
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
				
				dispose();
			}
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
				PantallaTrasSalir SalirApp = new PantallaTrasSalir();
				SalirApp.setVisible(true);
				dispose();
//			 	dispose(); AÑADIR PARA SALIR DE LA APP Y DESCONEX , Y QUE LLEVE  ALA PAGINA PANTALLATRASALIR
			}
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
		FONDO.setBackground(new Color(72, 209, 204));
		FONDO.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(FONDO);
		FONDO.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tu Perfil");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 11, 180, 30);
		FONDO.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(45, 95, 145, 37);
		FONDO.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(45, 163, 128, 37);
		FONDO.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(167, 101, 114, 31);
		FONDO.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 163, 114, 31);
		FONDO.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tipo Usuario");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(45, 222, 128, 37);
		FONDO.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(167, 222, 114, 31);
		FONDO.add(textField_2);
		
     
    
    }
}
		
