package program;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entities.DB;
import model.exceptions.DbException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;				
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		
		try {
			connection = DB.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from department");
			
			System.out.println("\nLISTA DE DEPARTAMENTOS: ");			
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name"));	
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException("Erro na integraçao com banco de dados: " + e.getMessage());
		}
		
		
	
		
		
		DB.closeConnection();

	}

}
