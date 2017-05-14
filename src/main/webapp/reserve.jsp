<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reserve</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/ReserveStyle.css">
</head>
<body>
<form method="post" action="hotel">
    <div id="BG">
        <div id="Reserve">
            <table align="center">
                <tr>
                    <td class="Text Prompt">Дата заезда</td>
                    <td class="Text Prompt">Дата выезда</td>
                    <td class="Text Prompt">Количество человек</td>
                    
                </tr>
                <tr>
                    <td><input type="date" name="from" class="Field"></td>
                    <td><input type="date" name="to" class="Field" ></td>
                     <td>
                        <select name="size" class="Field Text Prompt" id="amountButton" >
                            <option selected value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </td>
                     <td><input align="center" type="submit" name="reserveButton" value="Забронировать номер" class="Text" id="ReserveButton"></td>
                     <td><input align="center" type="submit" name="exitButton" value="Выйти" class="Text" id="ExitButton"></td>
                </tr>
                   
                
            </table>
        </div>
    </div>
</form>
</body>
</html>