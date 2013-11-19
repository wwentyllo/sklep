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
<link href="${pageContext.request.contextPath}/resources/css/index.css"
	type="text/css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/reg.css" type="text/css" rel="stylesheet">
<script src="<c:url value='/resources/js/jquery.js' />" type="text/javascript" ></script>
<script>

	function searchFocus()
	{
		if($('#szukanaFraza').val() == "Wpisz czego szuaksz...")
			$('#szukanaFraza').val("");
	}
	function searchFocusOut()
	{
		$('#szukanaFraza').val("Wpisz czego szuaksz...");
	}
	function showPodkategorie()
	{
		
	}
	function selectPodpowiedz()
	{
		alert("sdada");
	}
	function sprawdzSlowo()
	{
		var ob = $('#szukanaFraza');
		var p = ob.position();
		var left = p.left+10;
		var top = p.top + 37;
		$.getJSON( "/jez/szukaj/szukaj.json", {"slowo": $('#szukanaFraza').val()})
		.done(function( json ) {
		    
		    var resp = "<ul>";
		    $.each(json.produkty, function( index, value ) {
		    	//alert( index + ": " + value );
		    	resp += '<li  id="li'+index+'" class="test" value="test1">'+value+'</li>';
		    	});
		    resp += "</ul>";
		    
		    $('#podpowiedzi').css("top", top).css("left", left).css("display", "block");
		    $('#podpowiedzi').html(resp);
		    
		   $('.test').on("mousedown",function(){ 
			   var ident = "#"+this.id;
			   $('#szukanaFraza').val($(ident).html());
		});
		    
		  })
		 .fail(function( jqxhr, textStatus, error ) {
		   //alert("error="+error);
		 }); 	
	}
	function ukryjPodpowiedzi()
	{
		 $('#podpowiedzi').css("display", "none");
	}
	function ladujPodkategorie()
	{
		var val = $('#kategoria').val();
			
		$.getJSON( "/jez/dodajProdukt/podkategorie.json", {"podkategory": parseInt(val)})
			.done(function( json ) {
			    
			    var resp = "<option value='0'>WYBIERZ PODKATEGORIE</option>";
			    $.each(json.kategorie, function( index, value ) {
			     	resp += '<option value="'+value.id+'">'+value.nazwa+'</option>';
			    	});
			    
			    $('#podkategoria').html(resp);
			    
			  })
			 .fail(function( jqxhr, textStatus, error ) {
			   //alert("error="+error);
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
					<a href="<c:url value='/' />" style="border: 0 px solid black; text-decoration: none;">
						<img  style='border: 0 px solid black; height: 80px;' src="<c:url value='/resources/images/logo.jpg' />">
					</a>
				</div>
			</div>
			
			<div id="top-right">
				<div>
					<c:choose>
						<c:when test="${!empty sessionScope.sessionUser}">
							  	<span style='display: block; margin-top: 20px; margin-left: 120px;'>Witaj: <span style='color: red; font-size: 18px;'>${sessionScope.sessionUser.getLogin()}</span></span>
							  	<a href="<c:url value="j_spring_security_logout" />"> wyloguj</a>
						</c:when>
	  					<c:otherwise>
	  							<a style='margin-top: 40px;' href='<c:url value='/logowanie' />'>Zaloguj</a>
								<a href='<c:url value='/rejestracja' />'>Rejestracja</a>
	  					</c:otherwise>
  					</c:choose>
					
				</div>
			</div>
		</div>
		<div id='searchDiv'>
			<form action="" method="GET">
				<table>
					<tr>
						<form action="/szukaj" method="post">
							<td>
								<input autocomplete="off" style="padding: 2px; padding-left: 8px;height: 35px; width: 400px; margin-left: 10px; margin-top: 5px;" id='szukanaFraza' type="text" value="Wpisz czego szuaksz..." onblur="ukryjPodpowiedzi();" onkeyup="sprawdzSlowo();" onfocus="searchFocus();" >	
							</td>
							<td>
								<select name='szukanaKat' id='szukanaKat' style="height: 35px; width: 160px; margin-top: 5px; background-color: #EDEDED;">
									<option value="0">WSZĘDZIE
									</option>
									<c:forEach items="${kategoryList}" var="element"> 
										<option value="${element.id}">
											${element.nazwa}
										</option>
										
									</c:forEach>
								</select>	
							</td>
							
							<td>
								<input type="submit" value="Szukaj" style="height: 35px; width: 100px; margin-top: 5px; background-image: linear-gradient(#6E6E6E 0%, #343434 100%); color: white;">	
							</td>
						</form>
						<td>
							<div style="border-left: 1px solid black; padding-left: 10px;">
								<a href="<c:url value='/mojekonto/' />" style="font-weight:bold; font-size: 16px;;text-decoration: none; border: none; color: black;">MOJE KONTO</a>
							</div>
						</td>
						<td>
							<div style="border-left: 1px solid black; padding-left: 10px; ">
								<a href="<c:url value='/koszyk/' />" style="font-weight:bold; font-size: 16px;;text-decoration: none; border: none; color: black;">KOSZYK</a>
							</div>
						</td>
						
					</tr>
				</table>
			</form>
		</div>
		<div id='main'>
			<div id='main-right' style="width: 1000px;" align='center'>
			<p style="font-size: 16pt; margin-top: 30px; color: #8AC74A;" ><b>Wbybierz zdjecie produktu: </b></p>
				<table class='casualTab' style='margin-top: 30px;'>
					<sf:form enctype="multipart/form-data" action="/jez/mojekonto/dodajProdukt/dodajZdjecie">
						<tr>
							<td style="font-weight: bold;">Plik: </td>
							<td>
								<input  name="image" type="file" />
							</td>
						</tr>
						<tr>
							<td style="font-weight: bold;">Zdjęcie główne? </td>
							<td>
								<input style='width: 30px; margin-left: 70px;' type="checkbox" name="mainImage" value="main" />	TAK
							</td>
						</tr>						
						<tr>
							<td cols="2"><input class="sub" style='margin: 0px;' type="submit" value="Dodaj Produkt" /></td>
						</tr>
						
					</sf:form>
				</table>
				</br>
				</br>
				<a class="zakoncz" href="<c:url value='/mojekonto/dodajProdukt/zakoncz/' />" >  >>> Zakończ dodawanie zdjęć <<< </a>
			</div>
		</div>
		<div id='bottom'>
			<span  align="center" style="color: #578921; display: block;"><b>Copyright Ⓒ Cebul & Jeżyk</b></span>
			
		</div>
	</div>
	<div id='podpowiedzi' >
		
	</div>
</body>
</html>
