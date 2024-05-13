import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Alterar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arquivo para alterar os dados
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "UPDATE contatos SET nome=? WHERE cpf=?";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					String cpf = JOptionPane.showInputDialog("CPF:");
					String nome = JOptionPane.showInputDialog("NOME:");
					
					comando.setString(1, nome);
					comando.setString(2, cpf);
					
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
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}

		
	}

}
