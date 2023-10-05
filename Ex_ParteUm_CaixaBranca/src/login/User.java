package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
public Connection conectarBD() {
	/*1*/Connection conn = null;
	/*2*/try {
		Class.forName("com.mysql.Driver.Manager").newInstance();
		String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
		conn = DriverManager.getConnection(url);
	}/*3*/catch (Exception e) /*4*/{}/*5*/
	return conn;}
/*6*/public String nome = "";
	public boolean result = false;
	public boolean verificarUsuario(String login, String senha) {
		/*7*/String sql = "";
		Connection conn = conectarBD();
		//INSTRUÇÃO SQL
		/*8*/sql += "select nome from usuarios ";
		sql += "where login = " + "'" + login + "'";
		sql += " and senha = " + "'" + senha + "';";
		/*9*/try {
			/*10*/Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			/*11*/if(rs.next()) {
				/*12*/result = true;
				nome = rs.getString("nome");}/*13*/
		}/*14*/catch (Exception e) /*15*/{}/*16*/
		/*17*/	return result;}
			}//fim da classe
		


