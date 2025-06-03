package PANELES;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBot extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel chatPanel;
    private JTextField userInputField;
    private JButton sendButton;
    private JTextArea chatArea;

    public ChatBot() {
        setTitle("ChatBot");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu ayudaMenu = new JMenu("Ayuda");
        JMenuItem sobreMenuItem = new JMenuItem("Sobre VAARI");
        sobreMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		SobreVaari SobreVaari = new SobreVaari();
				SobreVaari.setVisible(true);
				
				dispose();
        	}
        });
        JMenuItem soporteMenuItem = new JMenuItem("Soporte");
        soporteMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		Soporte Soporte = new Soporte();
				Soporte.setVisible(true);
				
				dispose();
        	}
        });
        JMenuItem contactoMenuItem = new JMenuItem("Guia");
        contactoMenuItem.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		GuiaUsuario GuiaUsuario = new GuiaUsuario();
				GuiaUsuario.setVisible(true);
				
				dispose();
        	}
        });

        JMenu MenuLista = new JMenu("Menú");
		MenuLista.setForeground(new Color(0, 0, 0));
		MenuLista.setBackground(new Color(255, 255, 255));
		menuBar.add(MenuLista);
		
		
        
    
        JMenuItem IrAnciano = new JMenuItem("Ancianos");
		IrAnciano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
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
			// 	dispose(); AÑADIR PARA SALIR DE LA APP Y DESCONEX , Y QUE LLEVE  ALA PAGINA PANTALLATRASALIR
			}
		});
        
        ayudaMenu.add(sobreMenuItem);
        ayudaMenu.add(soporteMenuItem);
        ayudaMenu.add(contactoMenuItem);
        menuBar.add(ayudaMenu);
        setJMenuBar(menuBar);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Calendario");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(titleLabel, BorderLayout.CENTER);

        JPanel datePanel = new JPanel();
        datePanel.setBackground(Color.WHITE);
        datePanel.setLayout(new FlowLayout());

        JLabel dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        datePanel.add(dateLabel);
        
        chatPanel = new JPanel(new BorderLayout());
        userInputField = new JTextField();
        sendButton = new JButton("Enviar");
        sendButton.setBackground(new Color(255, 255, 255));
        chatArea = new JTextArea();
        chatArea.setForeground(new Color(255, 255, 255));
        chatArea.setBackground(new Color(255, 128, 192));
        chatArea.setEditable(false);

        chatPanel.add(userInputField, BorderLayout.CENTER);
        chatPanel.add(sendButton, BorderLayout.EAST);

        getContentPane().add(chatArea, BorderLayout.CENTER);
        getContentPane().add(chatPanel, BorderLayout.SOUTH);
        
        JLabel lblNewLabel = new JLabel("CHAT VAARI (BOT)");
        lblNewLabel.setIcon(new ImageIcon("D:\\PROGRAMACIÓN\\PROYECTO VAARI\\GRAFICOS\\ICONOS\\Sin título-5.png"));
        getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        // ActionListener para el botón de enviar
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // ActionListener para la entrada del usuario (pulsar Enter)
        userInputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        setVisible(true);
    }

        // Método para enviar un mensaje y obtener una respuesta del chatbot
        private void sendMessage() {
            String userMessage = userInputField.getText();
            chatArea.append("User: " + userMessage + "\n");
    
            // Lógica del chatbot: responder al mensaje del usuario
            String botResponse = getBotResponse(userMessage);
            chatArea.append("Bot: " + botResponse + "\n");
    
            // Limpiar el campo de entrada del usuario después de enviar el mensaje
            userInputField.setText("");
        }
    
        // Método para obtener la respuesta del chatbot en función del mensaje del usuario
        private String getBotResponse(String message) 
        {
            // Convertir el mensaje del usuario a minúsculas para facilitar la comparación
            String lowerCaseMessage = message.toLowerCase();
    
            // Palabras clave para identificar temas relacionados con la aplicación
            String[] cuidadoAncianosKeywords = {"ancianos", "cuidado", "asistencia"};
            String[] centrosDiaKeywords = {"centros de día", "gestión", "atención"};
    
            // Comprobar si el mensaje contiene palabras clave relacionadas con el cuidado de ancianos
            for (String keyword : cuidadoAncianosKeywords) 
            {
                if (lowerCaseMessage.contains(keyword)) 
                {
                    return "Nuestra aplicación ofrece servicios de cuidado de ancianos, incluyendo asistencia y atención personalizada.";
                }
            }
    
            // Comprobar si el mensaje contiene palabras clave relacionadas con la gestión de centros de día
            for (String keyword : centrosDiaKeywords) 
            {
                if (lowerCaseMessage.contains(keyword)) 
                {
                    return "Nuestra aplicación facilita la gestión de centros de día, permitiendo una administración eficiente de recursos y atención a los usuarios.";
                }
            }
    
            // Si el mensaje no contiene palabras clave específicas, devolver una respuesta genérica
            return "¡Hola! Soy un VAARI-BOT. ¿En qué puedo ayudarte?";
        }
        
//        Se implementaran mas funcionalidades y mas respuestas del bot en un futuro

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChatBot();
            }
        });
    }
}
