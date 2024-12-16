package org.example.booklogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Updater {

    public void addBook(Book book) throws SQLException {
        String query = "INSERT INTO books (title, author, notes) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getNotes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(long id) throws SQLException {
        String query = "DELETE FROM books WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Book book = new Book();
                book.setTimestamp(rs.getString("timestamp"));
                book.setId(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setNotes(rs.getString("notes"));
                books.add(book);
            }
        }
        return books;
    }

    public void createDB() throws SQLException {
        String q1 = "CREATE DATABASE IF NOT EXISTS booklog;";
        String q2 = "USE booklog;";
        String q3 = "CREATE TABLE IF NOT EXISTS books (\n" +
                "\tid INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    title VARCHAR(100),\n" +
                "    author VARCHAR(100),\n" +
                "    notes VARCHAR(500),\n" +
                "    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" +
                ");";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(q1);
            stmt.executeUpdate(q2);
            stmt.executeUpdate(q3);
        }
    }
}
