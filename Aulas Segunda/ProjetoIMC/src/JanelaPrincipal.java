import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class JanelaPrincipal {

	private JFrame frame;
	private JTextField peso;
	private JTextField altura;
	private JLabel JLabel_imagem1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal window = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 469, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		peso = new JTextField();
		peso.setBounds(133, 53, 134, 35);
		frame.getContentPane().add(peso);
		peso.setColumns(10);
		
		altura = new JTextField();
		altura.setBounds(133, 121, 134, 35);
		frame.getContentPane().add(altura);
		altura.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Peso");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(61, 52, 62, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Altura");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 128, 62, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double P = Double.parseDouble(peso.getText());
				double A = Double.parseDouble(altura.getText());
				double imc = P / Math.pow(A, 2);
				JOptionPane.showMessageDialog(null, String.valueOf(imc));
				
			}
		});
		btnNewButton.setBounds(133, 189, 137, 35);
		frame.getContentPane().add(btnNewButton);
		
		JLabel JLabel_imagem1 = new JLabel("New Label");
		
		JLabel_imagem1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/carro.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		JLabel_imagem1.setBounds(277, 53, 159, 95);
		frame.getContentPane().add(JLabel_imagem1);
	}
}
