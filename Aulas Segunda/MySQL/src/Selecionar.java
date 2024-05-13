import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Selecionar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Arquivo para LISTAR dados da tabela
				Connection conexao = null;
				Statement comando = null;
				ResultSet resultado = null;
						
				try
				{
					conexao = ClasseConexao.Conectar();
					comando = conexao.createStatement();
							
					String sql = "SELECT * FROM contatos";
					resultado = comando.executeQuery(sql);
					while(resultado.next())
					{
						System.out.println(resultado.getString("cpf") + "   " + resultado.getString("nome"));
					}
							
							
				}catch(SQLException erro)
				{
					erro.printStackTrace();
				}finally
				{
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
