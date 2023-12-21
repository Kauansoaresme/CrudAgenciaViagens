package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuario no mysql
	private static final String USERNAME = "root";
	
	//Senha do mysql
	private static final String PASSWORD = "Recode2023";
	
	//Dados de caminho, porta e nome da base de dados que irá ser
	//feita pela conexão
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/Viajantes";
	/**
	 * Cria uma conexão com o banco de dados MYSQL utilizandoo nome de usuario e senha fornecidos
	 * @param username
	 * @param senha
	 * @return uma conexão com banco de dados
	 * @throws Exception
	 */
	public static Connection createConnectionToMySQL() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
		
		//Cria a conexão com banco de dados
		Connection connection =
	DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	public static void main(String[] args) throws Exception{
		
		//Recupera uma conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testa se a conexão é nula
		if (con != null) {
			System.out.println("Conexão obtida com sucesso!" + con);
			con.close();
		}
	}

}
