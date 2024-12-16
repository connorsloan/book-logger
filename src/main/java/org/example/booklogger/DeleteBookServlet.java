package org.example.booklogger;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.SQLException;

public class DeleteBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));

        Updater updater = new Updater();
        try {
            updater.deleteBook(id);
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error adding book: " + e.getMessage());
        }
    }
}