package PANELES;

import javax.swing.*;
import java.awt.*;

public class PantallaChat extends JDialog {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PantallaChat(JFrame parent) {
        super(parent, "Chat", true); // Hacer que la ventana sea modal y esté vinculada al JFrame principal
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Área de texto para mostrar el historial del chat
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false); // El usuario no puede editar el historial del chat
        JScrollPane scrollPane = new JScrollPane(chatArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        // Campo de texto para que el usuario escriba sus mensajes
        JTextField inputField = new JTextField();
        panel.add(inputField, BorderLayout.SOUTH);
        
        // Botón para enviar el mensaje
        JButton sendButton = new JButton("Enviar");
        sendButton.addActionListener(e -> {
            String message = inputField.getText().trim();
            if (!message.isEmpty()) {
                chatArea.append("Tú: " + message + "\n");
                inputField.setText(""); // Limpiar el campo de texto después de enviar el mensaje
                // Aquí puedes agregar la lógica para que el chatbot responda al mensaje del usuario
            }
        });
        panel.add(sendButton, BorderLayout.EAST);
        
        add(panel);
    }
}
    
