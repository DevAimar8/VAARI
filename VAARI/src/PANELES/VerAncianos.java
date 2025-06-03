package PANELES;

import java.awt.EventQueue;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Conexion.ConexionMySQL;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VerAncianos extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel FONDO;
    private JTextField Nombre_Anciano;
    private JTextField Apellidos_Anciano;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VerAncianos frame = new VerAncianos();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VerAncianos() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 649, 603);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255, 128, 192));
        menuBar.setBorder(null);
        setJMenuBar(menuBar);
        
        JMenu MenuLista = new JMenu("Menú");
        MenuLista.setForeground(Color.BLACK);
        MenuLista.setBackground(Color.WHITE);
        menuBar.add(MenuLista);
        
        JLabel HoraMenu = new JLabel("Hora");
        HoraMenu.setBackground(Color.WHITE);
        HoraMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
        MenuLista.add(HoraMenu);
        
        Thread te = new Thread(() -> {
            while (true) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fechaActual = sdf.format(new Date());
                HoraMenu.setText("Fecha: " + fechaActual);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        te.start();
        
        JMenuItem IrAnciano = new JMenuItem("Ancianos");
        IrAnciano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Anciano anciano = new Anciano();
                anciano.setVisible(true);
                dispose();
            }
        });
        IrAnciano.setHorizontalAlignment(SwingConstants.LEFT);
        IrAnciano.setBackground(Color.WHITE);
        MenuLista.add(IrAnciano);
                
        JMenuItem IrChat = new JMenuItem("Chat");
        IrChat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ChatBot chatBot = new ChatBot();
                chatBot.setVisible(true);
                dispose();
            }
        });
        IrChat.setBackground(Color.WHITE);
        MenuLista.add(IrChat);
        
        JMenuItem IrMenuPrincipal = new JMenuItem("Menú");
        IrMenuPrincipal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                menuPrincipal.setVisible(true);
                dispose();
            }
        });
        IrMenuPrincipal.setBackground(Color.WHITE);
        MenuLista.add(IrMenuPrincipal);

        JMenuItem IrCalendario = new JMenuItem("Calendario");
        IrCalendario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CalendarioInterfaz irCalendario = new CalendarioInterfaz();
                irCalendario.setVisible(true);
                dispose();
            }
        });
        IrCalendario.setBackground(Color.WHITE);
        MenuLista.add(IrCalendario);
        
        JMenuItem Salir = new JMenuItem("Salir");
        Salir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PantallaTrasSalir salir = new PantallaTrasSalir();
                salir.setVisible(true);
                dispose();
            }
        });
        Salir.setBackground(Color.WHITE);
        MenuLista.add(Salir);
        
        JMenu Ayuda = new JMenu("Ayuda");
        Ayuda.setForeground(Color.BLACK);
        Ayuda.setBackground(Color.WHITE);
        Ayuda.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        menuBar.add(Ayuda);
        
        JMenuItem SobreVAARI = new JMenuItem("Sobre Vaari");
        SobreVAARI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SobreVaari sobreVaari = new SobreVaari();
                sobreVaari.setVisible(true);
                dispose();
            }
        });
        SobreVAARI.setBackground(Color.WHITE);
        Ayuda.add(SobreVAARI);
        
        JMenuItem Soporte = new JMenuItem("Soporte");
        Soporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Soporte soporte = new Soporte();
                soporte.setVisible(true);
                dispose();
            }
        });
        Soporte.setBackground(Color.WHITE);
        Ayuda.add(Soporte);
        
        JMenuItem Contacto = new JMenuItem("Guía");
        Contacto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuiaUsuario guiaUsuario = new GuiaUsuario();
                guiaUsuario.setVisible(true);
                dispose();
            }
        });
        Contacto.setBackground(Color.WHITE);
        Ayuda.add(Contacto);
        
        FONDO = new JPanel();
        FONDO.setBounds(0, 0, 497, 630);
        FONDO.setBackground(new Color(255, 128, 192));
        FONDO.setBorder(null);
        setContentPane(FONDO);
        FONDO.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBackground(new Color(255, 153, 204));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Anciano anciano = new Anciano();
                anciano.setVisible(true);
                dispose();
            }
        });
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\acer\\Desktop\\Recursos\\Recursos\\Images\\previous.png"));
        btnNewButton_1.setBounds(37, 492, 85, 21);
        FONDO.add(btnNewButton_1);
        
        Apellidos_Anciano = new JTextField();
        Apellidos_Anciano.setBounds(175, 229, 144, 27);
        FONDO.add(Apellidos_Anciano);
        Apellidos_Anciano.setColumns(10);
        
        Nombre_Anciano = new JTextField();
        Nombre_Anciano.setToolTipText("");
        Nombre_Anciano.setBounds(175, 169, 144, 31);
        FONDO.add(Nombre_Anciano);
        Nombre_Anciano.setColumns(10);
        
        JLabel lblNewLabel_2 = new JLabel("Apellidos");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(61, 211, 153, 56);
        FONDO.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("Nombre");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(61, 169, 144, 31);
        FONDO.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("DESCARGAR FICHA");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = Nombre_Anciano.getText();
                String apellidos = Apellidos_Anciano.getText();
                
                if (nombre.isEmpty() || apellidos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese el nombre y los apellidos del anciano.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ConexionMySQL conexion = new ConexionMySQL("root", "test", "freedb_VAARI_APP");
                try {
                    conexion.conectar();
                    String consulta = "SELECT * FROM Ancianos WHERE Nombre_Anciano = '" + nombre + "' AND Apellidos_Anciano = '" + apellidos + "'";
                    ResultSet resultSet = conexion.ejecutarSelect(consulta);

                    if (resultSet.next()) {
                        try {
                            String nombreArchivo = nombre + "_" + apellidos + ".txt";
                            String escritorioPath = System.getProperty("user.home") + "/Desktop";//esto hara que el fichero se guarde ene el escritorio
                            File escritorio = new File(escritorioPath);
                            File archivo = new File(escritorio, nombreArchivo);
                            FileWriter writer = new FileWriter(archivo);
                            BufferedWriter bw = new BufferedWriter(writer);

                            bw.write("Nombre: " + resultSet.getString("Nombre_Anciano"));
                            bw.newLine();
                            bw.write("Apellidos: " + resultSet.getString("Apellidos_Anciano"));
                            bw.newLine();
                            bw.write("Edad: " + resultSet.getInt("Edad_Anciano"));
                            bw.newLine();
                            bw.write("Sexo: " + resultSet.getString("Sexo"));
                            bw.newLine();
                            bw.write("Descripción Anciano: " + resultSet.getString("DescripcionAnciano"));
                            bw.newLine();
                            bw.write("Descripción Trastorno: " + resultSet.getString("DescripcionTrastorno"));
                            bw.newLine();
                            bw.write("Medicación: " + resultSet.getString("Medicacion"));
                            bw.newLine();
                            bw.write("Dosis: " + resultSet.getString("Dosis"));
                            bw.newLine();
                            bw.write("Movilidad: " + resultSet.getString("Movilidad"));
                            bw.newLine();
                            bw.write("Dependencia: " + resultSet.getString("Dependencia"));
                            bw.newLine();
                            bw.close();

                            JOptionPane.showMessageDialog(null, "Ficha descargada exitosamente. Fichero guardado en su escritorio", "Descarga exitosa", JOptionPane.INFORMATION_MESSAGE);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al crear el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Anciano no encontrado en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al buscar el anciano en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    try {
                        conexion.desconectar();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(72, 209, 204));
        btnNewButton.setBounds(262, 285, 255, 56);
        FONDO.add(btnNewButton);
        
        JLabel Hora = new JLabel("HORA");
        Hora.setHorizontalAlignment(SwingConstants.CENTER);
        Hora.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Hora.setBounds(415, 439, 245, 120);
        FONDO.add(Hora);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBackground(new Color(240, 240, 240));
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
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }   
}
