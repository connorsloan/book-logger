package org.example.booklogger;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;

public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String notes = request.getParameter("notes");

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setNotes(notes);

        Updater updater = new Updater();
        try {
            updater.addBook(book);
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
