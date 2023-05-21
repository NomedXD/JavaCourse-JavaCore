<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="cool" method="POST">
    Первый операнд: <input name="operand1"/>
    <br>
    <br>
    Второй операнд: <input name="operand2"/>
    <br>
    <br>
    Операции:
    <input type="checkbox" name="operation" value="SummarizationOption" checked/>Summarization
    <input type="checkbox" name="operation" value="SubtractionOption" checked/>Subtraction
    <input type="checkbox" name="operation" value="MultiplicationOption" checked/>Multiplication
    <input type="checkbox" name="operation" value="DivisionOption" checked/>Division
    <br><br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
