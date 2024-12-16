<%@ page import="java.util.*, org.example.booklogger.*" %>
<%@ page import="java.sql.SQLException" %>
<html>
<head>
  <title>Book Log</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="icon" href="img/book.png">
</head>
<body>
<h1>My Books</h1>
<a href="addBook.jsp"><button>Add a new book</button></a>
<table border="1">
  <tr>
    <th>Title</th>
    <th>Author</th>
    <th>Notes</th>
    <th>Date</th>
  </tr>
  <%
    Updater updater = new Updater();
    List<Book> books;
    try {
        books = updater.getAllBooks();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
      for (Book book : books) {
  %>
  <tr>
    <td class="title"><%= book.getTitle() %></td>
    <td class="author"><%= book.getAuthor() %></td>
    <td class="notes"><%= book.getNotes() %></td>
    <td class="timestamp"><%= book.getTimestamp()%></td>
    <td>
      <form action="deleteBookServlet" method="POST">
        <input type="hidden" name="id" value="<%= book.getId() %>" />
        <input type="submit" value="Delete" />
      </form>
    </td>
  </tr>
  <% } %>
</table>
</body>
</html>
