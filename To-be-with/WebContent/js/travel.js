$(document).ready(loadTravel());


function loadModal(title,content)
{	
	$("#myModalLabel_2").text(title);
	$("#modal-body_2").text(content);
	$("#fullHeightModalRight").modal();
}

function travelDelete(_travelNum)
{
	$.ajax
	(
	{
		type : "POST",
		url : "travelDelete.do",
		data : 
			{
			travelNum : _travelNum
			},
			success : function(result)
			{			
				if(result == 1)
				{
					alert("승인 성공");
				}
				else
				{
					alert("승인 실패");
				}
			}
	}
	);
	location.reload();
}
function loadTravel()
{
	var isLoaded = 0;
	
	$("#browsers").append("<option value = \"대한민국\">");
	$("#browsers").append("<option value = \"프랑스\">");
	$("#browsers").append("<option value = \"일본\">");	 
	
	$('#country').change
	(
		function()
		{
			var country = $("#country").val();			
			$("#browsers_2").empty();
			$("#region").val("");
			if(country == "대한민국")
			{
				
				$("#browsers_2").append("<option value = \"서울\">");
				$("#browsers_2").append("<option value = \"대구\">");
				$("#browsers_2").append("<option value = \"부산\">");	
				$("#browsers_2").append("<option value = \"대전\">");					
				
			}
			
			if(country == "일본")
			{				
				$("#browsers_2").append("<option value = \"오사카시\">");
				$("#browsers_2").append("<option value = \"나고야시\">");
				$("#browsers_2").append("<option value = \"고베시\">");	
				$("#browsers_2").append("<option value = \"사이타마시\">");					
				
			}
			
			if(country == "프랑스")
			{				
				$("#browsers_2").append("<option value = \"그랑빌\">");
				$("#browsers_2").append("<option value = \"나르본\">");
				$("#browsers_2").append("<option value = \"뇌이쉬르센\">");	
				$("#browsers_2").append("<option value = \"드뢰\">");										
			}
		}		
	)
	
		
}


