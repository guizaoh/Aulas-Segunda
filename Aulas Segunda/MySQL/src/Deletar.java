import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Deletar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arquivo para deletar os dados
				Connection conexao = null;
				PreparedStatement comando = null;
				
				try
				{
					conexao = ClasseConexao.Conectar();
					String sql = "DELETE FROM contatos WHERE cpf=?";
					comando = conexao.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
					
					String cpf = JOptionPane.showInputDialog("CPF:");
					
					comando.setString(1, cpf);
					
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
					}catch(SQLException erro)
					{
						erro.printStackTrace();
					}
				}

		
	}

}
