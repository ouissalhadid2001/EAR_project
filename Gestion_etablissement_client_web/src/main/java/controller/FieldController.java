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
import entities.Student;

/**
 * Servlet implementation class FieldController
 */
public class FieldController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	FieldDaoLocal fdao;
	@EJB
	StudentDaoLocal sdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FieldController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
// Retrieve the list of fields
List<Field> fieldList = fdao.findAll();
System.out.println("liste : "+fieldList);
// Set the list of fields as an attribute in the request
request.setAttribute("fieldList", fieldList);

// Forward the request to a JSP page that can display the list
request.getRequestDispatcher("/ListFields.jsp").forward(request, response);
}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");

		if ("delete".equals(action)) {
	        // Get the ID of the field to delete
	        int fieldId = Integer.parseInt(request.getParameter("id"));
	        if(fdao.findById(fieldId)!=null) {
	        	System.out.println("not null!!!!");
	        	 // Delete the field (implement this logic in your DAO)
		        boolean deleted = fdao.delete(fdao.findById(fieldId));

		        if (deleted) {
		            // Field deleted successfully
		            response.sendRedirect(request.getContextPath() + "/FieldController");
		        } else {
		            // Handle the case where deletion failed
		            response.sendRedirect(request.getContextPath() + "/FieldController?deleteFailed=true");
		        }
	        }
	       
	    } 
		
		else if("edit".equals(action)) {
	        // Retrieve form data
	        int id = Integer.parseInt(request.getParameter("id"));
	        System.out.println("idddddd: "+id);
	        String name = request.getParameter("name");
	        String code = request.getParameter("code");

	        // Find the Field to edit by its ID
	        Field fieldToEdit = fdao.findById(id);

	        if (fieldToEdit != null) {
	            // Update the Field entity
	            fieldToEdit.setName(name);
	            fieldToEdit.setCode(code);

	            // Save the changes
	            fdao.update(fieldToEdit);
	        }

	        // Redirect to the list of Fields after editing
	        response.sendRedirect(request.getContextPath() + "/FieldController");
	    }
		else if("showform".equals(action)) {
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
		else if("showlist".equals(action)) {
			try {
				showlist(request, response);
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
	    String code = request.getParameter("code");

	    // Create a new Field object
	    Field newField = new Field();
	    newField.setName(name);
	    newField.setCode(code);

	    // Persist the new Field in the database
	    if (fdao.create(newField)) {
	        // If the creation is successful, retrieve the updated list of fields
	        List<Field> fieldList = fdao.findAll();
            System.out.println(fdao.findAll());
	        // Set the list of fields as an attribute in the request
	        request.setAttribute("fieldList", fieldList);

	        // Forward the request to a JSP page that can display the list
	        request.getRequestDispatcher("/ListFields.jsp").forward(request, response);
	    } else {
	        // If the creation fails, you can handle the error accordingly
	        // For now, we simply print an error message
	        System.out.println("Failure: Field not created.");
	    }}
	}
	
    

	
private void showlist(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
	int id = Integer.parseInt(request.getParameter("id"));
	List<Student> liste= sdao.findByFiliere(fdao.findById(id).getName());
	RequestDispatcher dispatcher = request.getRequestDispatcher("studentsfield.jsp");
	request.setAttribute("students", liste);
	request.setAttribute("filiere", fdao.findById(id).getName());
	dispatcher.forward(request, response);		
	}

private void showEditForm(HttpServletRequest request, HttpServletResponse response)
		throws SQLException, ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id"));
	Field existingField = fdao.findById(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("editField.jsp");
	request.setAttribute("field", existingField);
	dispatcher.forward(request, response);
}
}
	


