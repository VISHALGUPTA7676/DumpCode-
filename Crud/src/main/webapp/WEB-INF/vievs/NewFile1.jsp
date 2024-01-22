<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring Form Example</title>
</head>
<body>
    <h2>Experience Details</h2>

    <form:form action="/submitForm" method="post" modelAttribute="userRequest">
        <table border="1">
            <thead>
                <tr>
                    <th>Year</th>
                    <th>Company</th>
                    <th>Description</th>
                    <th>Ahead</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
               
                    <tr>
                        <td><form:input path="noOfYears[0]" /></td>
                        <td><form:input path="companyName[0]" /></td>
                        <td><form:input path="description[0]" /></td>
                        <td><form:checkbox path="experiences[0]" /></td>
                        <td><button type="button" onclick="removeRow(this)">Remove</button></td>
                    </tr>
               
            </tbody>
        </table>

        <button type="button" onclick="addRow()">Add</button>
        <button type="submit">Submit</button>
    </form:form>

    <script>
        function addRow() {
            var table = document.querySelector("table tbody");
            var newRow = table.insertRow(table.rows.length);

            var cells = [];
            for (var i = 0; i < 4; i++) {
                cells[i] = newRow.insertCell(i);

                var input = document.createElement("input");
                input.type = "text";
                input.name = "experiences[" + (table.rows.length - 1) + "].year";
                cells[i].appendChild(input);
            }

            var checkboxCell = newRow.insertCell(4);
            var checkbox = document.createElement("input");
            checkbox.type = "checkbox";
            checkbox.name = "experiences[" + (table.rows.length - 1) + "].ahead";
            checkboxCell.appendChild(checkbox);

            var actionCell = newRow.insertCell(5);
            var removeButton = document.createElement("button");
            removeButton.type = "button";
            removeButton.innerText = "Remove";
            removeButton.onclick = function() { removeRow(this); };
            actionCell.appendChild(removeButton);
        }

        function removeRow(button) {
            var row = button.parentNode.parentNode;
            row.parentNode.removeChild(row);
        }
    </script>
</body>
</html>
