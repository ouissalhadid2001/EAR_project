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

import dao.FieldDaoLocal;
import dao.IDaoLocal;
import dao.StudentDaoLocal;
import entities.Field;
import entities.Role;
import entities.Student;

/**
 * Servlet implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       @EJB
       StudentDaoLocal sdao;
       @EJB
       FieldDaoLocal fdao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> StudentList = sdao.findAll();
		System.out.println("liste : " + StudentList);
		request.setAttribute("StudentList", StudentList);

		request.getRequestDispatcher("/ListStudents.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("delete".equals(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			if (sdao.findById(id) != null) {
				System.out.println("not null!!!!");
				boolean deleted = sdao.delete(sdao.findById(id));

				if (deleted) {
					response.sendRedirect(request.getContextPath() + "/StudentController");
				} else {
					response.sendRedirect(request.getContextPath() + "/StudentController?deleteFailed=true");
				}
			}

		}

		else if ("edit".equals(action)) {
			// Retrieve form data
			int id = Integer.parseInt(request.getParameter("id"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String telephone = request.getParameter("tel");
			String login=request.getParameter("login");
			String password=request.getParameter("password");
	        int fieldId = Integer.parseInt(request.getParameter("field"));
			Student studentToEdit = sdao.findById(id);

			if (studentToEdit != null) {
				studentToEdit.setFirstname(firstname);
				studentToEdit.setLastname(lastname);
				studentToEdit.setTelephone(telephone);
				studentToEdit.setLogin(login);
				studentToEdit.setMotdepasse(password);
                studentToEdit.setField(fdao.findById(fieldId));
				sdao.update(studentToEdit);
			}

			response.sendRedirect(request.getContextPath() + "/StudentController");
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

			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String telephone = request.getParameter("tel");
			String login=request.getParameter("login");
			String password=request.getParameter("password");
			Student newStudent = new Student();
			newStudent.setFirstname(firstname);
			newStudent.setLastname(lastname);
            newStudent.setTelephone(telephone);
            newStudent.setLogin(login);
            newStudent.setMotdepasse(password);
            if(request.getParameter("field")!=null) {
		         int fieldId = Integer.parseInt(request.getParameter("field"));
                 newStudent.setField(fdao.findById(fieldId));
			}
            else
                newStudent.setField(null);

			if (sdao.create(newStudent)) {
				List<Student> StudentList = sdao.findAll();
				System.out.println(sdao.findAll());
				request.setAttribute("StudentList", StudentList);

				request.getRequestDispatcher("/ListStudents.jsp").forward(request, response);
			} else {

				System.out.println("Failure: Student not created.");
			}
		}
		
		
	}
	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		List<Field> fieldList=fdao.findAll();
		System.out.println("liste to addform : "+fieldList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("addStudent.jsp");
		request.setAttribute("fieldList", fieldList);
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = sdao.findById(id);
		List<Field> fieldList=fdao.findAll();
		System.out.println("liste to editform : "+fieldList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editStudent.jsp");
		request.setAttribute("student", existingStudent);
		request.setAttribute("fields", fieldList);
		dispatcher.forward(request, response);
	}

}
