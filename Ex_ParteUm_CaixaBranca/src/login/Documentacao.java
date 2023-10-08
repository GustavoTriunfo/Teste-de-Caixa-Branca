package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**@author Prof.Daniel Ohata
 * @version 1.1
 * edited by Gustavo Costa**/

/**Só para comentar que essa classe e métodos tiveram suas estruturas alteradas no sentido de separar os itens. 
 * A indentação é recomendada como boa prática pela comunidade pois facilita a leitura do código e consequentemente o entendimento de seu conteúdo.
 * Por isso, visando a qualidade da documentação aqui apresentada, essa parte de indentação foi alterada.**/
public class Documentacao 
{
	/**@param nome , campo que se refere ao nome a ser inserido na consulta SQL
	 * @param result , campo referente ao resultado da verificação do usuário**/
	public String nome = "";
	public boolean result = false;
	
	/**Este método "conectarBD" é resonsável por efetuar a conexão com o banco de dados.
	 *  Não existem @param de entrada como argumento, e podemos notar que após a abertura, a conexão não é fechada.
	 *  Esse fato deflagra um problema na segurança. Essa não é uma prática recomendada. */
public Connection conectarBD() 
{
	Connection conn = null;
	try 
	{
		Class.forName("com.mysql.Driver.Manager").newInstance();
		/**Declaração da variável url de tipo String. Nela é atribuido o endereço url do jdbc.**/
		String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
		conn = DriverManager.getConnection(url);
	}catch (Exception e) 
	{
		/**Nesse catch a @exception ClassNotFoundException é capturada mas não é tratada de forma alguma. 
		 * Esse ponto também pode caracterizar um erro no código.**/
	}
	/**@return conn é o retorno do estado da conexão. Se ela foi efetuada ou não.**/
	return conn;
}

/** O método "verificarUsuario" é o responsável por verificar no banco de dados se o usuário está cadastrado no sitema.
 * Repare que ele possui dois @param... a String login e a String senha**/
	public boolean verificarUsuario(String login, String senha) 
	{
		/**Nesse trecho temos a declaração de uma nova variavel @param sql , que dentro do escopo do método tem a função de construir a instrução SQL.**/
		String sql = "";
		/**Aqui temos a chamada do método "conectarBD" que foi construído anteriormente. 
		 * E o resultado obtido com o retorno é guardado no @param conn de tipo Connection.**/
		Connection conn = conectarBD();
		//INSTRUÇÃO SQL
		/**Dentro dessa instrução SQL temos a utilização dos dois @param que são argumentados no método.**/
		sql += "select nome from usuarios ";
		sql += "where login = " + "'" + login + "'";
		sql += " and senha = " + "'" + senha + "';";
		try 
		{
			/**A seguir a declaração de dois @param st e rs. Dos tipos Statement e ResultSet respectivamente.**/
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				result = true;
				nome = rs.getString("nome");
				}
		}catch (Exception e) 
		{
			/**Nesse catch as @exception que podem ser lançadas: SQLException, NullPointerException. 
			 * Mas especificamente as exceções são capturadas de uma forma genérica utilizando o tipo Exception.
			 * Também não existe tratamento para essas exceptions. 
			 * Esse ponto também pode caracterizar um erro no código.**/
		}
		/**@return result é o retorno que trás o valor booleano da verificação do usuário.**/
			return result;
	}
}//fim da classe

/**Teste de documentação**/
		


