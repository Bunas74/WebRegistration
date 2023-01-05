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
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
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
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");

		User user = new User(login, password, nickName, email, phoneNumber);
		Users users = new Users();

		try {
			users.insert(user);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException
				| ClassNotFoundException | SQLException e) {
			// XXX Auto-generated catch block
			e.printStackTrace();
		}

		try {
			writer.println(
					"<h1 style=\"text-align: center;\">Successful registration.</h1>");
		} finally {
			writer.close();
		}
	}

}
