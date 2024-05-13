package mqtt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chat {

	private JFrame frame;
	private JTextField apelido;
	private JTextField texto;
	private JTextField area;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chat window = new Chat();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chat() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 411, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("APELIDO:");
		lblNewLabel.setBounds(47, 38, 62, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel textolabel = new JLabel("MENSAGEM:");
		textolabel.setBounds(26, 63, 83, 14);
		frame.getContentPane().add(textolabel);
		
		apelido = new JTextField();
		apelido.setBounds(97, 35, 116, 20);
		frame.getContentPane().add(apelido);
		apelido.setColumns(10);
		
		texto = new JTextField();
		texto.setBounds(86, 60, 299, 20);
		frame.getContentPane().add(texto);
		texto.setColumns(10);
		
		JButton btnNewButton = new JButton("ENVIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//BOTAO DE ENVIAR MENSAGEM
				Mensagem UOL = new Mensagem();
				String txt = apelido.getText() + ": " + texto.getText();
				UOL.Enviar("unisociesc/batepapo/pirigo1" , txt);
				
					
				
			}
		});
		btnNewButton.setBounds(296, 91, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		area = new JTextField();
		area.setBounds(10, 124, 375, 260);
		frame.getContentPane().add(area);
		area.setColumns(10);
	}
}
