
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

    <div id="carousel" class="carousel">
    <button class="arrow prev">⇦</button>
    <div class="gallery">
      <ul class="images">
        <li><img src="https://js.cx/carousel/1.png"></li>
        <li><img src="https://js.cx/carousel/2.png"></li>
        <li><img src="https://js.cx/carousel/3.png"></li>
        <li><img src="https://js.cx/carousel/4.png"></li>
        <li><img src="https://js.cx/carousel/5.png"></li>
        <li><img src="https://js.cx/carousel/6.png"></li>
        <li><img src="https://js.cx/carousel/7.png"></li>
        <li><img src="https://js.cx/carousel/8.png"></li>
        <li><img src="https://js.cx/carousel/9.png"></li>
        <li><img src="https://js.cx/carousel/10.png"></li>
      </ul>
    </div>
    <button class="arrow next">⇨</button>
  </div>
        
</form>
<script>
    /* этот код помечает картинки, для удобства разработки */
    var lis = document.getElementsByTagName('li');
    for (var i = 0; i < lis.length; i++) {
      lis[i].style.position = 'relative';
      var span = document.createElement('span');
      // обычно лучше использовать CSS-классы,
      // но этот код - для удобства разработки, так что не будем трогать стили
      span.style.cssText = 'position:absolute;left:0;top:0';
      span.innerHTML = i + 1;
      lis[i].appendChild(span);
    }

    /* конфигурация */
    var width = 130; // ширина изображения
    var count = 3; // количество изображений

    var carousel = document.getElementById('carousel');
    var list = carousel.querySelector('ul');
    var listElems = carousel.querySelectorAll('li');

    var position = 0; // текущий сдвиг влево

    carousel.querySelector('.prev').onclick = function() {
      // сдвиг влево
      // последнее передвижение влево может быть не на 3, а на 2 или 1 элемент
      position = Math.min(position + width * count, 0)
      list.style.marginLeft = position + 'px';
    };

    carousel.querySelector('.next').onclick = function() {
      // сдвиг вправо
      // последнее передвижение вправо может быть не на 3, а на 2 или 1 элемент
      position = Math.max(position - width * count, -width * (listElems.length - count));
      list.style.marginLeft = position + 'px';
    };
  </script>
</body>
</html>
