<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page contentType="text/html;charset=UTF-8" %> 
<%@ page session="true"%>
<html>
<head>
<meta name="description" content="Portal aukcyjny" />
	<meta name="keywords" content="aukcja, kupic, sprzedac, licytacja, portal" />
	<meta name="author" content="Cebul, Jez" />
	<meta content="pl" http-equiv="Content-Language">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>e-shop</title>
<link href="${pageContext.request.contextPath}/resources/css/index.css" type="text/css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/reg.css" type="text/css" rel="stylesheet">
<script src="<c:url value='/resources/js/jquery.js' />" type="text/javascript" ></script>
<script>
function month()
{
var m = $("#miesiac").val();
var r = $("#rok").val();
var d = $("#dzien");
var str = "";
str = "<option value='null'>dzień:</option>";
if(m != 2 && (m % 2 == 0))
{
for(var i=1; i<=31; i++)
{
str += "<option value='"+i+"'> "+i+"</option>";
}
d.html(str);
}else if(m ==2 && (r % 4 == 0)){
for(var i=1; i<=29; i++)
{
str += "<option value='"+i+"'> "+i+"</option>";
}
d.html(str);
}else if(m ==2){
for(var i=1; i<=28; i++)
{
str += "<option value='"+i+"'> "+i+"</option>";
}
d.html(str);
}else if(m % 2 == 1){
for(var i=1; i<=30; i++)
{
str += "<option value='"+i+"'> "+i+"</option>";
}
d.html(str);
}
} 

function doAjaxPost() 
{
   //alert("sakdjlajla");
	// get the form values
    var username = $('#login').val();
    $.ajax({
	    type: "POST",
		    url: "/jez/register/ajax.do",
		    data: "username=" + username,
		    success: function(response)
		    {
		    	if(response != "")
		    	{
		    		$("#login_error").text("Taki użytkownik juz istnieje!");
		    	}else{
		    		$("#login_error").text("");
		    	}
				
	    	}
    });
}
</script>
</head>
<body>
<div id='contener'>
		<div id='top'>
			<div id="top-left">
				<ul type="square" style="margin-top: 25px; font: 700 12px/22px 'Lato',Arial,sans-serif; list-style-image: url(<c:url value='/resources/images/punktor.jpg' />)">
			        <li>Atrakcyjny ceny</li>
			        <li>Szeroki asortyment</li>
			        <li>Zakupy z Nami to przyjemność</li>
			    </ul>
			</div>
			
			<div id="top-mid">
				<div id='imgCont' align="center">
					<a href="<c:url value='/' />" style="border: none;">
						<img  style='height: 80px;' src="<c:url value='/resources/images/logo.jpg' />">
					</a>
				</div>
			</div>
			
			<div id="top-right">
				${sessionScope.test}
				<div>
					<a style='margin-top: 40px;' href='<c:url value='/logowanie' />'>Zaloguj</a>
					<a href='<c:url value='/rejestracja' />'>Rejestracja</a>
				</div>
			</div>
		</div>
		<div id='searchDiv'>
			<form action="" method="GET">
				<table>
					<tr>
						<td>
							<input style="padding: 2px; padding-left: 8px;height: 35px; width: 400px; margin-left: 10px; margin-top: 5px;" id='szukanaFraza' type="text" value="Wpisz czego szuaksz..." onfocus="searchFocus();" onfocusout="searchFocusOut();">	
						</td>
						<td>
							<select name='szukanaKat' id='szukanaKat' style="height: 35px; width: 160px; margin-top: 5px; background-color: #EDEDED;">
								<option value="0">WSZĘDZIE
								</option>
								<c:forEach items="${kategoryList}" var="element"> 
									<option value="${element.nazwa}">
										${element.nazwa}
									</option>
									
								</c:forEach>
							</select>	
						</td>
						<td>
							<input type="submit" value="Szukaj" style="height: 35px; width: 100px; margin-top: 5px; background-image: linear-gradient(#6E6E6E 0%, #343434 100%); color: white;">	
						</td>
						<td>
							<div style="border-left: 1px solid black; padding-left: 10px;">
								<a href="<c:url value='/koszyk' />" style="font-weight:bold; font-size: 16px;;text-decoration: none; border: none; color: black;">MOJE KONTO</a>
							</div>
						</td>
						<td>
							<div style="border-left: 1px solid black; padding-left: 10px; ">
								<a href="<c:url value='/koszyk' />" style="font-weight:bold; font-size: 16px;;text-decoration: none; border: none; color: black;">KOSZYK</a>
							</div>
						</td>
						
					</tr>
				</table>
			</form>
		</div><div id='main'>
		<div id='main-cenetr' align='center'>
				
		<p>Wybierz rodzaj produktu jaki chcesz dodać: </p>
		
		<sf:form method="POST" action="/jez/mojekonto/dodajProdukt/wybierzRodzajProd">
			<fieldset style='border: none;'>
			<table>
			<tr>
				<td> <label>Produkt Kup Teraz</label> </td>
				<td>
					<input style='width: 50px;' type="radio" name='wyborProd' value="KupTeraz" checked="checked" />
				</td>	
			</tr>
			<tr>
				<td> <label>Produkt Licytuj</label> </td>
				<td>
				
					<input style='width: 50px;' type="radio" name='wyborProd' value="Licytuj" />
				</td>
			</tr>
			<tr>
				<td cols="2" align='center'>
					<input class="sub" style='margin: 0px;' type="submit" value="Kolejny krok" /> 
				</td>
			</tr>
			</table>
			</fieldset>
		</sf:form>
	<a class="zakoncz" href="<c:url value='/mojekonto/dodajProdukt/zakoncz/' />" >Zakończ dodawanie zdjęć</a>
	</div>
</div>
</body>
</html>