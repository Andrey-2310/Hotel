<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reserve</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/resultOfReserve.css">
</head>
<body>
<form method="post" action="hotel">
    <div id="BG">
        <div id="Reserve">
             <table align="center">
                    <tr><p id="Congrats" class="Text">Поздравляем!</p></tr>
                    <tr><p id="Description" class="Text">Ваш заказ успешно оформлен</p></tr>
                    <tr><p id="EmailInfo"class="Text">Подробности отправлены на электронный ящик</p></tr>
            
                <tr>
                     <td><input align="center" type="submit" name="continueButton" value="Продолжить" class="Text" id="ContinueButton"></td>
                     <td><input align="center" type="submit" name="exitButton" value="Выйти" class="Text" id="ExitButton"></td>
                </tr>
                   
                
            </table>
        </div>
    </div>
</form>
</body>
</html>