package PANELES;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Conexion.ConexionMySQL;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class CrearAnciano extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel FONDO;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_4;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JTextArea textArea;
	private JTextArea txtrcomoEs;


	/**
	 * Launch the application.
	 */
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CrearAnciano frame = new CrearAnciano();
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
	public CrearAnciano() {
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
		FONDO.setBackground(new Color(255, 128, 192));
		FONDO.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(FONDO);
		FONDO.setLayout(null);
		
		JButton btnNewButton = new JButton("CREAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				registrarAnciano();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(72, 209, 204));
		btnNewButton.setBounds(463, 297, 124, 49);
		
		
		
		FONDO.add(btnNewButton);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.addItem("Mujer");
		comboBox_2.addItem("Hombre");
		comboBox_2.setBounds(321, 119, 81, 22);
		FONDO.add(comboBox_2);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.addItem("Total");
		comboBox_1.addItem("Media");
		comboBox_1.addItem("Baja");
		comboBox_1.setBounds(351, 460, 86, 22);
		FONDO.add(comboBox_1);
		
		comboBox = new JComboBox<String>();
		comboBox.addItem("Independiente");
		comboBox.addItem("Media");
		comboBox.addItem("Total");
		comboBox.setBounds(117, 460, 115, 22);
		FONDO.add(comboBox);
		
		
		
		textArea = new JTextArea();
		textArea.setBounds(203, 315, 199, 56);
		FONDO.add(textArea);
		
		JLabel lblNewLabel_11 = new JLabel("Dependencia");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_11.setBounds(10, 462, 110, 14);
		FONDO.add(lblNewLabel_11);
		
		JLabel lblNewLabel_10 = new JLabel("Movilidad");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10.setBounds(265, 462, 86, 14);
		FONDO.add(lblNewLabel_10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(351, 387, 86, 27);
		FONDO.add(textField_4);
		textField_4.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 387, 115, 27);
		FONDO.add(textField_1);
		textField_1.setColumns(10);
		
		txtrcomoEs = new JTextArea();
		txtrcomoEs.setToolTipText("");
		txtrcomoEs.setBounds(203, 235, 199, 56);
		FONDO.add(txtrcomoEs);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setBounds(54, 204, 34, 27);
		FONDO.add(textField_3);
		textField_3.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(78, 155, 115, 27);
		FONDO.add(textField_2);
		textField_2.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(78, 117, 115, 27);
		FONDO.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel_9 = new JLabel("Trastornos o Enfermedad");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(10, 332, 183, 14);
		FONDO.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("Sexo");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(279, 121, 46, 14);
		FONDO.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Dosis");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(272, 391, 53, 14);
		FONDO.add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("Medicación");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(10, 391, 110, 14);
		FONDO.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5 = new JLabel("¿Como es...?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(10, 274, 137, 14);
		FONDO.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Gustos/Hobbies");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 249, 154, 14);
		FONDO.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 208, 46, 14);
		FONDO.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 155, 63, 31);
		FONDO.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 113, 63, 31);
		FONDO.add(lblNewLabel_1);
		
		JLabel Hora = new JLabel("HORA");
		Hora.setHorizontalAlignment(SwingConstants.CENTER);
		Hora.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Hora.setBounds(415, 439, 245, 120);
		FONDO.add(Hora);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\GRAFICOS\\GRAFICOS\\FONDOS\\FONDOCREAANCIANO.png"));
		lblNewLabel.setBounds(0, 0, 633, 544);
		FONDO.add(lblNewLabel);
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
	private void registrarAnciano() {
	    String Nombre_Anciano = textField.getText();
	    String Apellidos_Anciano = textField_2.getText();
	    int Edad_Anciano = Integer.parseInt(textField_3.getText());
	    String Sexo = comboBox_2.getSelectedItem().toString();
	    String DescripcionAnciano = txtrcomoEs.getText();
	    String DescripcionTrastorno = textArea.getText();
	    String Medicacion = textField_1.getText();
	    String Dosis = textField_4.getText();
	    String Movilidad = comboBox_1.getSelectedItem().toString();
	    String Dependencia = comboBox.getSelectedItem().toString();

	    if (Nombre_Anciano.isEmpty() || Apellidos_Anciano.isEmpty() || DescripcionAnciano.isEmpty() || DescripcionTrastorno.isEmpty() || Medicacion.isEmpty() || Dosis.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    ConexionMySQL conexion = new ConexionMySQL("root", "test", "freedb_VAARI_APP");
	    try {
	        conexion.conectar();
	        String consulta = "INSERT INTO Ancianos (Nombre_Anciano, Apellidos_Anciano, Edad_Anciano, Sexo, DescripcionANciano, DescripcionTrastorno, Medicacion, Dosis, Movilidad, Dependencia)" + 
	        		"VALUES ('" + Nombre_Anciano + "', '" + Apellidos_Anciano + "',  '" + Edad_Anciano + "', '" + Sexo + "', '" + DescripcionAnciano + "', '" + DescripcionTrastorno + "', '" + Medicacion + "', '" + Dosis + "', '" + Movilidad + "', '" + Dependencia + "')";
			conexion.ejecutarInsertDeleteUpdate(consulta);
	        
	        JOptionPane.showMessageDialog(this, "Registro de anciano exitoso.", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
	        Anciano IrAnciano = new Anciano();
			IrAnciano.setVisible(true);
			dispose();
	        // Resto del código para limpiar los campos o realizar otras acciones después de registrar al anciano
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al registrar el anciano. Inténtalo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
	    } finally {
	        try {
	            conexion.desconectar();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
		