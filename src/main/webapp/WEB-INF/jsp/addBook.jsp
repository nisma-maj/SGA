<form action="${pageContext.request.contextPath}/books/add" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required>

    <label for="isbn">ISBN:</label>
    <input type="text" id="isbn" name="isbn" required>

    <label for="author">Author:</label>
    <select id="author" name="author.id">
        <c:forEach var="author" items="${authors}">
            <option value="${author.id}">${author.name}</option>
        </c:forEach>
    </select>

    <button type="submit">Add Book</button>
</form>
