<form action="${pageContext.request.contextPath}/authors/add" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required>

    <label for="biography">Biography:</label>
    <textarea id="biography" name="biography"></textarea>

    <button type="submit">Add Author</button>
</form>
