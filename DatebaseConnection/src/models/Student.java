package models;
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
		String sql = ("SELECT * FROM `students`");
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("sql exception caught");
		}
	}

	public void update(String id, String name) {
		String sql = ("UPDATE `students` SET name ='" + name + "' WHERE id = '" + id + "');");
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("sql exception caught");
		}
	}

	public void delete(String id) {
		String sql = ("DELETE FROM `students`  WHERE id = '" + id + "');");
		try {
			stmt = connection.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("sql exception caught");
		}
	}
}