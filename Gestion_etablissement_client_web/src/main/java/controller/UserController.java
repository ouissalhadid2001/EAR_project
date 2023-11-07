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
import java.util.ArrayList;
import java.util.List;

import dao.IDaoLocal;
import dao.RoleDaoLocal;
import dao.UserDaoLocal;
import entities.Field;
import entities.Role;
import entities.User;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
	private UserDaoLocal udao;	
       @EJB
   	private RoleDaoLocal rdao;	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> UserList = udao.findAll();
		System.out.println("liste : "+UserList);
		request.setAttribute("UserList", UserList);

		request.getRequestDispatcher("/ListUsers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (udao.findById(id) != null) {
				System.out.println("not null!!!!");
				boolean deleted = udao.delete(udao.findById(id));

				if (deleted) {
					response.sendRedirect(request.getContextPath() + "/UserController");
				} else {
					response.sendRedirect(request.getContextPath() + "/UserController?deleteFailed=true");
				}
			}

		}

		else if ("edit".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String password = request.getParameter("password");
            int idrole=Integer.parseInt(request.getParameter("role"));
			User userToEdit = udao.findById(id);

			if (userToEdit != null) {
				userToEdit.setLogin(name);
				userToEdit.setMotdepasse(password);
				if(userToEdit.getRoles()!=null)
				userToEdit.getRoles().add(rdao.findById(idrole));
				else {
					 List<Role> r=new ArrayList<Role>();
			         r.add(rdao.findById(idrole));
			         userToEdit.setRoles(r);
				}
				
				udao.update(userToEdit);
			}

			response.sendRedirect(request.getContextPath() + "/UserController");
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
		else if ("showaddform".equals(action)) {
			try {
				showAddForm(request, response);
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

			String login = request.getParameter("name");
			String password = request.getParameter("password");

			User newUser = new User();
			newUser.setLogin(login);
			newUser.setMotdepasse(password);
			if(request.getParameter("role")!=null) {
		         int roleId = Integer.parseInt(request.getParameter("role"));
		         List<Role> r=new ArrayList<Role>();
		         r.add(rdao.findById(roleId));
		         newUser.setRoles(r);
			}
           else
              newUser.setRoles(null);
			if (udao.create(newUser)) {
				List<User> UserList = udao.findAll();
				
				request.setAttribute("UserList", UserList);

				request.getRequestDispatcher("/ListUsers.jsp").forward(request, response);
			} else {

				System.out.println("Failure: User not created.");
			}
		}
	}
	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Role> roles=rdao.findAll();
		System.out.println("liste to addform : "+roles);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addUser.jsp");
		request.setAttribute("roles", roles);
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Role> roles=rdao.findAll();
		User existingUser = udao.findById(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editUser.jsp");
		request.setAttribute("user", existingUser);
		request.setAttribute("roles", roles);
		dispatcher.forward(request, response);
	}
}
