package models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factories.DBConectorFactory;

public class Student {
	private java.sql.Connection connection;
	private Statement stmt;
	private String id;
	private String name;

	
	public Student() {
		connection = DBConectorFactory.getDatabaseConnection();
	}
	
	public void create(String id, String name) {
		String sql = ("INSERT INTO dblab. `students` (id, name)"
				+ "VALUES ('" + id + "', '" + name + "');");
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("sql exception caught");
		}
	}

	public void readAll() {
		String sql = "SELECT * FROM dblab. `students`";
		try {
			stmt = connection.createStatement();
			//stmt.executeUpdate(sql);
			ResultSet result = stmt.executeQuery(sql);
			while(result.next()) {
				System.out.println("ID: " + result.getString("id") + "  Name: " + result.getString("name"));
			    //System.out.println("ID: " + result.getString(1) + "  Name: " + result.getString(2));
			}
		} catch (SQLException e) {
			System.err.println("sql exception caught");
			e.printStackTrace();
		}
	}

	public void update(String id, String name) {
		String sql = "UPDATE dblab.`students` SET `name` = '" + name + "' WHERE `id` = '" + id + "'";
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("sql exception caught");
		}
	}

	public void delete(String id) {
		String sql = "DELETE FROM dblab. `students`  WHERE id = '" + id + "'";
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("sql exception caught");
		}
	}
}