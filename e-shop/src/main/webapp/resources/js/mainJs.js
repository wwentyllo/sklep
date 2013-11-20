	function searchFocus()
	{
		if($('#szukanaFraza').val() == "Wpisz czego szuaksz...")
			$('#szukanaFraza').val("");
	}
	function searchFocusOut()
	{
		$('#szukanaFraza').val("Wpisz czego szuaksz...");
	}
	function sprawdzSlowo()
	{
		var ob = $('#szukanaFraza');
		var p = ob.position();
		var left = p.left+10;
		var top = p.top + 37;
		if(ob.val() != "" && ob.val().length >= 3)
		{
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
		}else{
			 ukryjPodpowiedzi();
		}
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