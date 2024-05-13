import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class somar {

	private JFrame frame;
	private JTextField n1;
	private JTextField n2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					somar window = new somar();
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
	public somar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		n1 = new JTextField();
		n1.setBounds(152, 64, 86, 20);
		frame.getContentPane().add(n1);
		n1.setColumns(10);
		
		n2 = new JTextField();
		n2.setBounds(152, 143, 86, 20);
		frame.getContentPane().add(n2);
		n2.setColumns(10);
		
		JLabel JLabel = new JLabel("Numero 1");
		JLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel.setBounds(55, 67, 73, 20);
		frame.getContentPane().add(JLabel);
		
		JLabel JLabel2 = new JLabel("Numero 2");
		JLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel2.setBounds(55, 146, 73, 14);
		frame.getContentPane().add(JLabel2);
		
		JButton btnNewButton = new JButton("somar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double resultado = 0;
				resultado = Double.parseDouble(n1.getText()) + Double.parseDouble(n2.getText());
				JOptionPane.showMessageDialog(null, resultado);
			}
		});
		btnNewButton.setBounds(149, 193, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
