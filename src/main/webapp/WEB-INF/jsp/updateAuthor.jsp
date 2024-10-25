<form action="${pageContext.request.contextPath}/authors/update/${author.id}" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${author.name}" required>

    <label for="biography">Biography:</label>
    <textarea id="biography" name="biography">${author.biography}</textarea>

    <button type="submit">Update Author</button>
</form>
