package library;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBook
 */
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         Books book =  new Books();
	         BooksDAO dao = new BooksDAO();
	         PrintWriter out = response.getWriter();
	        
	       try {
				book.setId(dao.generateBookID());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	         
	         book.setName(request.getParameter("name"));
	         book.setAuthor(request.getParameter("author"));
	         book.setEdition(request.getParameter("edition"));
	         book.setDept(request.getParameter("dept"));
	         book.setTotal(Integer.parseInt(request.getParameter("total")));
	         try {
				out.println(dao.addBook(book));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
