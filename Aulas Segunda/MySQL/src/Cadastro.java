import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cadastro {

	private JFrame frame;
	private JTextField cpf;
	private JTextField nome;
	private JTextField idade;
	private JTable tabela_listagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
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
	
	public void Selecionando()
	{
		// Precisamos criar algumas variáveis para conectar, dar comandos e
		// também para armazenar a pesquisa com o SELECT:
		Connection conexao = null;
		Statement  comando = null;
		ResultSet  resultado = null;
		try {
			conexao = ClasseConexao.Conectar();
			comando = conexao.createStatement();
			String meu_sql = "SELECT * FROM contatos";
			resultado = comando.executeQuery(meu_sql); // Executa o SQL
			
// O nome da sua jTable deve ser “tabela_listagem”
			tabela_listagem.setModel(DbUtils.resultSetToTableModel(resultado));
// O DbUtils deve ser importado (java.sql)
				
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			ClasseConexao.FecharConexao(conexao);
			try
			{
				comando.close();
				resultado.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}		
	}

	
	
	public Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 359, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setBounds(25, 31, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		cpf = new JTextField();
		cpf.setBounds(96, 28, 86, 20);
		frame.getContentPane().add(cpf);
		cpf.setColumns(10);
		
		nome = new JTextField();
		nome.setBounds(96, 73, 237, 20);
		frame.getContentPane().add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("NOME:");
		lblNewLabel_1.setBounds(25, 76, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IDADE:");
		lblNewLabel_2.setBounds(25, 119, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		idade = new JTextField();
		idade.setBounds(96, 116, 86, 20);
		frame.getContentPane().add(idade);
		idade.setColumns(10);
		
		JButton btnNewButton = new JButton("INSERIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BOTÃO INSERIR
				
				// Arquivo para INSERIR dados numa tabela
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "INSERT into contatos(cpf,nome, idade) VALUES(?,?,?)";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					comando.setString(1, cpf.getText());
					comando.setString(2, nome.getText());
					comando.setInt(3, Integer.parseInt(idade.getText()));
					if(comando.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(null, "DADOS GRAVADOS");
					}
				}catch(SQLException erro)
				{
					erro.printStackTrace();
				}finally {
					ClasseConexao.FecharConexao(conexao);
					try
					{
						comando.close();
						Selecionando();
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(25, 171, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ALTERAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// BOTAO ALTERAR
				// Arquivo para alterar os dados
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "UPDATE contatos SET nome=? WHERE cpf=?";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					comando.setString(1, nome.getText());
					comando.setString(2, cpf.getText());
					comando.setInt(3, Integer.parseInt(idade.getText()));
					
					if(comando.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(null, "DADOS ALTERADOS");
					}
				}catch(SQLException erro)
				{
					erro.printStackTrace();
				}finally {
					ClasseConexao.FecharConexao(conexao);
					try
					{
						comando.close();
						Selecionando();
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(124, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("EXCLUIR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//BOTAO EXCLUIR
				// Arquivo para deletar os dados
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "DELETE FROM contatos WHERE cpf=?";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					comando.setString(1, cpf.getText());
					
					if(comando.executeUpdate()>0)
					{
						JOptionPane.showMessageDialog(null, "DADOS EXCLUÍDOS");
					}
				}catch(SQLException erro)
				{
					erro.printStackTrace();
				}finally {
					ClasseConexao.FecharConexao(conexao);
					try
					{
						comando.close();
						Selecionando();
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}
			}
		});
		btnNewButton_2.setBounds(223, 171, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 323, 155);
		frame.getContentPane().add(scrollPane);
		
		tabela_listagem = new JTable();
		tabela_listagem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Clique na tabela:
				int linha = tabela_listagem.getSelectedRow();
				cpf.setText(tabela_listagem.getModel().getValueAt(linha,0).toString());
				nome.setText(tabela_listagem.getModel().getValueAt(linha,1).toString());
				idade.setText(tabela_listagem.getModel().getValueAt(linha,2).toString());
			}
		});
		scrollPane.setViewportView(tabela_listagem);
	}
}
