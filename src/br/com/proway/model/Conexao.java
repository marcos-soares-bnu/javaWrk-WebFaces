package br.com.proway.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public Connection con = null;

	private static final String SERVER = "localhost";
	private static final String DB = "t-systems";
	private static final String USER = "root";
	private static final String PASS = "mysql";
	private static final String URL = "JDBC:mysql://" + SERVER + "/" + DB
			+ "?user=" + USER + "&password=" + PASS;

	
	public Conexao() throws ClassNotFoundException, SQLException{
		conecta();
	}
	
	public String conecta() throws SQLException, ClassNotFoundException {
		// Carrega o driver
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		// Conecta o BD
		con = (Connection) DriverManager.getConnection(URL);
		return "Conectou";
	}
}