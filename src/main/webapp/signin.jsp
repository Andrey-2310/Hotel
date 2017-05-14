<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/SignIn.css">
</head>
<body>
<form method="post" action="hotel">


    <table>
        <tr>
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

    <table id="Reg_table">
        <tr>
            <td class="Text Prompt">Login</td>
            <td><input type="text" name="login" class="Field"></td>
        </tr>
        <tr>
            <td class="Text Prompt">Password</td>
            <td><input type="password" name="password" class="Field"></td>
        </tr>
        <tr>
            <td align="right"><input type="submit" name="cancelEnterButton" value="Cancel" id="cancelButton"></td>
            <td align="right"><input type="submit" name="signinButton" value="Enter" id="EnterButton"></td>
        </tr>
        
    </table>
        

    
</form>

</body>
</html>
