package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import dao.IDaoLocal;
import dao.RoleDaoLocal;
import entities.Field;
import entities.Role;

/**
 * Servlet implementation class RoleController
 */
public class RoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	RoleDaoLocal rdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoleController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Role> RoleList = rdao.findAll();
		System.out.println("liste : " + RoleList);
		request.setAttribute("RoleList", RoleList);

		request.getRequestDispatcher("/ListRoles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (rdao.findById(id) != null) {
				System.out.println("not null!!!!");
				boolean deleted = rdao.delete(rdao.findById(id));

				if (deleted) {
					response.sendRedirect(request.getContextPath() + "/RoleController");
				} else {
					response.sendRedirect(request.getContextPath() + "/RoleController?deleteFailed=true");
				}
			}

		}

		else if ("edit".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");

			Role roleToEdit = rdao.findById(id);

			if (roleToEdit != null) {
				roleToEdit.setName(name);

				rdao.update(roleToEdit);
			}

			response.sendRedirect(request.getContextPath() + "/RoleController");
		} else if ("showform".equals(action)) {
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {

			// Retrieve form data from the request
			String name = request.getParameter("name");

			Role newRole = new Role();
			newRole.setName(name);

			if (rdao.create(newRole)) {
				List<Role> RoleList = rdao.findAll();
				System.out.println(rdao.findAll());
				request.setAttribute("RoleList", RoleList);

				request.getRequestDispatcher("/ListRoles.jsp").forward(request, response);
			} else {

				System.out.println("Failure: Field not created.");
			}
		}
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Role existingRole = rdao.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editRole.jsp");
		request.setAttribute("role", existingRole);
		dispatcher.forward(request, response);
	}
}
