package PANELES;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class Anciano extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel FONDO;
	

	/**
	 * Launch the application.
	 */
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Anciano frame = new Anciano();
				//// Obtener la resolución de la pantalla del ordenador en este caso
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
	public Anciano() {
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
				PantallaTrasSalir salir = new PantallaTrasSalir();
				salir.setVisible(true);
				dispose();
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
		FONDO.setBackground(new Color(255, 255, 255));
		FONDO.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(FONDO);
		FONDO.setLayout(null);
		
		JButton BotonPerfil = new JButton("");
		BotonPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_1 = new JButton("VER REGISTROS");
		btnNewButton_1.setBorder(new LineBorder(new Color(72, 209, 204), 2)); // Cambio el color del borde al mismo color del cuadro con un ancho de 2 píxeles
		btnNewButton_1.setToolTipText("V");
		btnNewButton_1.addActionListener(new ActionListener()
		
		
		{
			public void actionPerformed(ActionEvent e) {
				
				VerAncianos IrVerAnciano = new VerAncianos();
				IrVerAnciano.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(72, 209, 204));
		btnNewButton_1.setBounds(369, 207, 187, 58);
		FONDO.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("NUEVO ANCIANO");
		btnNewButton.setBorder(new LineBorder(new Color(72, 209, 204), 2)); // Cambio el color del borde al mismo color del cuadro con un ancho de 2 píxeles
		btnNewButton.setToolTipText("Crear nuevo registro de anciano");
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) 
		    {
		    	
		    	CrearAnciano IrCrearAnciano = new CrearAnciano();
				IrCrearAnciano.setVisible(true);
		    	
		    	dispose();
		    	
		    	
		        // Aquí puedes agregar lo que quieras que suceda cuando se haga clic en el botón
		    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(72, 209, 204));
		btnNewButton.setBounds(75, 207, 187, 58);
		FONDO.add(btnNewButton);
		BotonPerfil.setOpaque(false);
		
			
		
		BotonPerfil.setBorderPainted(false);
		BotonPerfil.setBackground(new Color(255, 255, 255));
		BotonPerfil.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\GRAFICOS\\GRAFICOS\\ICONOS\\USUARIO.png"));
		BotonPerfil.setBounds(547, 11, 70, 70);
		FONDO.add(BotonPerfil);
		
		JLabel Perfil = new JLabel("Perfil");
		Perfil.setHorizontalAlignment(SwingConstants.CENTER);
		Perfil.setBounds(559, 81, 46, 14);
		FONDO.add(Perfil);
		
		JLabel Hora = new JLabel("HORA");
		Hora.setHorizontalAlignment(SwingConstants.CENTER);
		Hora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Hora.setBounds(415, 439, 245, 120);
		FONDO.add(Hora);
		
		JLabel LABEL_FONDO = new JLabel("");
		LABEL_FONDO.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\GRAFICOS\\GRAFICOS\\FONDOS\\FONDOJO.png"));
		LABEL_FONDO.setBounds(0, -22, 633, 566);
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
		
