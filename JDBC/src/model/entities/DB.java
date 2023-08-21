package model.entities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import model.exceptions.DbException;

public class DB {

	private static Connection conn = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	
	public static Connection getConnection() {
		
		if (conn == null) {			
			try {
				Properties properties = loadProperties();
				String url = properties.getProperty("dburl");
				conn = DriverManager.getConnection(url, properties);					
			} catch (SQLException e) {				
				throw new DbException("Erro de conexão com banco de dados. " + e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() {
		
		if (!(conn == null)) {
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException("Erro ao encerrar a conexão com banco de dados. " + e.getMessage());
			}
			
		}
		
	}
	
	
	public static void closeStatement() {
		if (!(statement == null)) {			
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException("Erro ao encerrar a sentença SQL com banco de dados. " + e.getMessage());
			}			
		}		
	}
	
	public static void closeResultSet() {
		if (!(resultSet == null)) {			
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new DbException("Erro ao encerrar o conjunto de resultados com banco de dados. " + e.getMessage());
			}			
		}		
	}
	
	
	public static Properties loadProperties() {		
		try {			
			FileInputStream file = new FileInputStream("db.properties");
			Properties properties = new Properties();
			properties.load(file);			
			return properties;						
		}
		catch (IOException e) {			
			throw new DbException("Erro na inicialização das propriedades. " + e.getMessage());			
		}
	}


	
}
