<html>
<head>
    <title>Add A New Book</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img/book.png">
</head>
<body>
<h1>Add A New Book</h1>
<form action="addBookServlet" method="POST">
    Title: <input type="text" name="title" required><br><br>
    Author: <input type="text" name="author" required><br><br>
    Notes: <textarea name="notes"></textarea><br><br>
    <input type="submit" value="Add Book">
</form>
</body>
</html>

