<!DOCTYPE html>
<html>
<head>
    <title>Get all tasks</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

<h2>List of tasks</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>CreationDate</th>
        <th>DueDate</th>
        <th>Description</th>
    </tr>

    <#list tasks as task>
        <tr>
            <td>${task.getId()}</td>
            <td>${task.getTitle()}</td>
            <td>${task.getCreationDate()}</td>
            <td>${task.getDueDate()}</td>
            <td>${task.getDescription()}</td>
        </tr>
    </#list>
</table>
</body>
</html>