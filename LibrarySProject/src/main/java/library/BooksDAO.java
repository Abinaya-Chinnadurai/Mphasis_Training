package library;

import java.sql.*;
import java.util.*;

public class BooksDAO {
    Connection con;
    PreparedStatement pst;
    Books book = new Books();
    
	public int generateBookID() throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = " Select case when max(id) is null then 1 else max(id)+1 end id from books";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int id = rs.getInt("id");
		return id;       
	}

	public String addBook(Books book) throws SQLException {
		con = ConnectionHelper.getConnection();
		String cmd = "Insert into Books(id,Name,Author,Edition,Dept,totalbooks) values(?,?,?,?,?,?)";
		pst = con.prepareStatement(cmd);
		pst.setInt(1,book.getId());
		pst.setString(2, book.getName());
		pst.setString(3, book.getAuthor());
		pst.setString(4,  book.getEdition());
		pst.setString(5,  book.getDept());
		pst.setInt(6, book.getTotal());
		pst.executeUpdate();
		return "Added Successfully...";
	}

	public String deletebook(int id) throws ClassNotFoundException, SQLException {
		Books book = searchbooks(id);
		if (book != null) {
			con = ConnectionHelper.getConnection();
			String cmd = "Delete from books where id=?";
			pst = con.prepareStatement(cmd);
			pst.setInt(1, id);
			pst.executeUpdate();
			return "Book Details Deleted...";
		}
		return "Book detail not Found...";
	}
	
	public Books searchbooks(int id) throws SQLException, ClassNotFoundException {
		con = ConnectionHelper.getConnection();
		String cmd = "select * from books where id=?";
		pst = con.prepareStatement(cmd);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		Books books = null;
		if (rs.next()) {
			books= new Books();
			books.setId(rs.getInt("id"));
			books.setName(rs.getString("name"));
			books.setAuthor(rs.getString("author"));
			books.setEdition(rs.getString("edition"));
			books.setDept(rs.getString("dept"));
			books.setTotal(rs.getInt("totalbooks"));
			
		}
		return books;
	}
	
	public Books[] showbook() throws ClassNotFoundException, SQLException {
		con=ConnectionHelper.getConnection();
		String cmd = "select * from books";
		pst = con.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Books> bookList = new ArrayList<Books>();
		Books book = null;
		while(rs.next()) {
			book = new Books();
			book.setId(rs.getInt("id"));
			book.setName(rs.getString("name"));
			book.setAuthor(rs.getString("author"));
			book.setEdition(rs.getString("edition"));
			book.setDept(rs.getString("dept"));
			book.setTotal(rs.getInt("totalbooks"));
			bookList.add(book);
		}
	    return bookList.toArray(new Books[bookList.size()]);
	}
	
	public String updatebook(Books book) throws ClassNotFoundException, SQLException {
		Books book1 = searchbooks(book.getId());
		if (book1 != null) {
			String cmd = "Update books set Name=?, author=?, edition=?, dept=?, totalbooks=? "
					+ " Where id=?";
			con = ConnectionHelper.getConnection();
			pst = con.prepareStatement(cmd);
			pst.setString(1, book.getName());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getEdition());
			pst.setString(4, book.getDept()); 
			pst.setInt(5, book.getTotal());
			pst.setInt(6, book.getId());

			pst.executeUpdate();
			return "Book Details Updated...";
		}
		return "Book detail Not Found...";
	}
}
