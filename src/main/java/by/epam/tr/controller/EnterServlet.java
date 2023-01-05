package by.epam.tr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import by.epam.tr.bean.User;
import by.epam.tr.bean.Users;

/**
 * Servlet implementation class EnterServlet
 */
public class EnterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EnterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ")
				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String login = request.getParameter("login");
		String password = request.getParameter("password");

		Users users = new Users();
		User user = null;
		try {
			user = users.selectOne(login);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException
				| ClassNotFoundException | SQLException e) {
			// XXX Auto-generated catch block
			e.printStackTrace();
		}

		try {
			if (user == null) {
				writer.println(
						"<h1 style=\"text-align: center;\">Wrong login.</h1>");
			} else if (user.getLogin().equals(login)
					&& !user.getPassword().equals(password)) {
				writer.println(
						"<h1 style=\"text-align: center;\">Wrong password.</h1>");
			} else if (user.getLogin().equals(login)
					&& user.getPassword().equals(password)) {
				writer.println(
						"<h1 style=\"text-align: center;\">Login successful.</h1>");
			}
		} finally {
			writer.close();
		}
	}

}
