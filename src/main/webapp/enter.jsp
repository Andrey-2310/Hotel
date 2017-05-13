
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enter</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/Enter.css">
</head>
<body>

<form method="post" action="hotel">
   
       
    <table>
        <tr>
            <td><input type="submit" name="regButton" value="Registration" id="RegistrationButton"></td>
            <td align="right"><input type="submit" name="entButton" value="  Sign in " id="SignUpButton"></td>
            <td>
                <select name="lang" class="Field_Text">
                    <option selected value="RU" class="Field_Text">Русский</option>
                    <option value="EN" class="Field_Text">English</option>
                </select>
            </td>
            <td> <input type="submit" name="langButton" value="OK" id="LangButton"></td>
        </tr>
    </table>
            

    <p id="HotelName">Hotel Albatros</p>
    <p id="Motto">Enjoy Pastime</p>
        
</form>
</body>
</html>
