
//script per la gestione della checkbox, object è una delle checkbox
function filter(object)
{
	if(object.value=="dip")
	{
		document.getElementById("stipendioNew").removeAttribute("Style");
		document.getElementById("idAziendaNew").removeAttribute("Style");
	}	
	else
	{
		document.getElementById("stipendioNew").style.display="none";
		document.getElementById("idAziendaNew").style.display="none";
	}
	
}