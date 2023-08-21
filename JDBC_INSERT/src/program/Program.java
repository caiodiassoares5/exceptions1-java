package program;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.entities.DB;
import model.exceptions.DbException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection connection = null;				
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
				
		try {
			connection = DB.getConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT INTO SELLER "
					+"(name, email, birthdate, basesalary, departmentid) "
					+"VALUES "
					+"(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, "Caio Dias");
			preparedStatement.setString(2, "caio@gmail.com");
			preparedStatement.setDate(3, new java.sql.Date(simpleDateFormat.parse("21/08/2008").getTime()));
			preparedStatement.setDouble(4, 1000.00);
			preparedStatement.setInt(5, 2);
			
			int rowsAffected = preparedStatement.executeUpdate();
						
			if (rowsAffected > 0 ) {
				resultSet = preparedStatement.getGeneratedKeys();
				
				while (resultSet.next()) {					
					System.out.println(resultSet.getInt(1));					
				}				
			}			
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DbException("Erro na integraçao com banco de dados: " + e.getMessage());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new DbException("Erro na transformação de data: " + e.getMessage());
		}
		finally {
			
			DB.closeStatement();
			DB.closeResultSet();
			DB.closeConnection();
		}

	}
}

