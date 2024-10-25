<form action="${pageContext.request.contextPath}/books/update/${book.id}" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" value="${book.title}" required>

    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" value="${book.isbn}" required>

    <label for="author">Author:</label>
    <select id="author" name="author.id">
        <c:forEach var="author" items="${authors}">
            <option value="${author.id}" ${author.id == book.author.id ? 'selected' : ''}>${author.name}</option>
        </c:forEach>
    </select>

    <button type="submit">Update Book</button>
</form>
