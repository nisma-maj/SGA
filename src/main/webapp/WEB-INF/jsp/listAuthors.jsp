<table>
    <tr>
        <th>Name</th>
        <th>Biography</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.name}</td>
            <td>${author.biography}</td>
            <td>
                <a href="${pageContext.request.contextPath}/authors/update/${author.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
