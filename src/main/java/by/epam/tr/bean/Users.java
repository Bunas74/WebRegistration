package by.epam.tr.bean;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Users {

	private static String url = "jdbc:mysql://localhost:3306/mysql";
	private static String username = "root";
	private static String password = "Bie1018751Bie";
	private static String driver = "com.mysql.cj.jdbc.Driver";

	public ArrayList<User> select() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

		ArrayList<User> users = new ArrayList<User>();

			Class.forName(driver).getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username,
					password);

				Statement statement = conn.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM user.user");
				while (resultSet.next()) {

					String login = resultSet.getString(2);
					String password = resultSet.getString(3);
					String nickName = resultSet.getString(4);
					String email = resultSet.getString(5);
					String phoneNumber = resultSet.getString(6);
					User user = new User(login, password, nickName, email,
							phoneNumber);
					users.add(user);
				}
		return users;
	}

	public User selectOne(String login) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

		User user = null;

			Class.forName(driver).getDeclaredConstructor().newInstance();
		Connection conn = DriverManager.getConnection(url, username,
					password);

				String sql = "SELECT * FROM user.user WHERE login=?";
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
					preparedStatement.setString(1, login);
					ResultSet resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {

						String loginUser = resultSet.getString(2);
						String password = resultSet.getString(3);
						String nickName = resultSet.getString(4);
						String email = resultSet.getString(5);
						String phoneNumber = resultSet.getString(6);
						user = new User(loginUser, password, nickName, email,
								phoneNumber);
					}
	
		return user;
	}

	public int insert(User user) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

			Class.forName(driver).getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username,
					password);

				String sql = "INSERT INTO user.user (login, password, nickName, email, phoneNumber) Values (?, ?, ?, ?, ?)";
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
					preparedStatement.setString(1, user.getLogin());
					preparedStatement.setString(2, user.getPassword());
					preparedStatement.setString(3, user.getNickName());
					preparedStatement.setString(4, user.getEmail());
					preparedStatement.setString(5, user.getPhoneNumber());

					return preparedStatement.executeUpdate();
	}

	public int update(User user) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {

			Class.forName(driver).getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username,
					password);

				String sql = "UPDATE user.user SET login = ?, password = ?, nickName = ?, email = ?, phoneNumber = ? WHERE id = ?";

				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
					preparedStatement.setString(1, user.getLogin());
					preparedStatement.setString(2, user.getPassword());
					preparedStatement.setString(3, user.getNickName());
					preparedStatement.setString(4, user.getEmail());
					preparedStatement.setString(5, user.getPhoneNumber());

					return preparedStatement.executeUpdate();
	
	}

	public int delete(int id) throws InstantiationException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException,
			ClassNotFoundException, SQLException {

			Class.forName(driver).getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username,
					password);

				String sql = "DELETE FROM user.user WHERE id = ?";
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
					preparedStatement.setInt(1, id);

					return preparedStatement.executeUpdate();
	
	}
}
