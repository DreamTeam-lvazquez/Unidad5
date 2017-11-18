package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Zoo;

public class ZooDAOImpl implements ZooDAO {
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public ZooDAOImpl() {
		getConnetion();
	}
	
	public Connection getConnetion() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "1234");
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createZoo(Zoo zoo) {
		try {
		if(connection != null) {
			preparedStatement = connection.prepareStatement("INSERT INTO zoos (name, number_animals,"
									+ "city)values (?,?,?);");
			preparedStatement.setString(1,zoo.getName() );
			preparedStatement.setString(2,zoo.getNumber_animals() );
			preparedStatement.setString(3,zoo.getCity());
			preparedStatement.execute();
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Zoo readZoo(Long id_zoom) {
		Zoo zoo = null;
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("SELECT * FROM zoos WHERE id_zoom=?");
				
				preparedStatement.setLong(1, id_zoom);
				resultSet = preparedStatement.executeQuery();
				if(resultSet.next()) {
					zoo = new Zoo(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
											resultSet.getString(4));
				}
				
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return zoo;
	}

	@Override
	public List<Zoo> readAllZoos() {
		List<Zoo> zoos = new ArrayList<Zoo>();
		try {
		
				preparedStatement = connection.prepareStatement("SELECT * FROM zoos");
				resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					Zoo zoo = new Zoo(
									resultSet.getLong(1), 
									resultSet.getString(2), 
									resultSet.getString(3),
									resultSet.getString(4));
					zoos.add(zoo);
				}
				}catch(SQLException e) {
				e.printStackTrace();
			}
		return zoos;
	}

	@Override
	public void updateZoo(Zoo zoo) {
		try {
			if(connection != null) {
				preparedStatement = connection.prepareStatement("UPDATE zoos SET name=?, "
											+ "number_animals=?,"
										+ "city=? WHERE id_zoom=?;");
				preparedStatement.setString(1,zoo.getName() );
				preparedStatement.setString(2,zoo.getNumber_animals() );
				preparedStatement.setString(3,zoo.getCity());
				preparedStatement.setLong(4, zoo.getId_zoom());
				preparedStatement.execute();
			}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteZoo(Long id_zoom) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM zoos WHERE id_zoom=?;");
				preparedStatement.setLong(1, id_zoom);
				preparedStatement.execute();
				
			}catch(SQLException e){
				e.printStackTrace();
				
			}
		}
		
	}
	
	

	
}
