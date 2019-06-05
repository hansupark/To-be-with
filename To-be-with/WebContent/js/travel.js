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
	$("#browsers").append("<option value = \"독일\">");	 
	$("#browsers").append("<option value = \"베트남\">");	 
	$("#browsers").append("<option value = \"영국\">");	 
	$("#browsers").append("<option value = \"스위스\">");	 
	$("#browsers").append("<option value = \"스페인\">");	 
	$("#browsers").append("<option value = \"이탈리아\">");	 
	$("#browsers").append("<option value = \"네덜란드\">");	 
	$("#browsers").append("<option value = \"미국\">");	 

	
	
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
				$("#browsers_2").append("<option value = \"광주\">");
				$("#browsers_2").append("<option value = \"춘천\">");
				$("#browsers_2").append("<option value = \"강릉\">");
				$("#browsers_2").append("<option value = \"여수\">");
				$("#browsers_2").append("<option value = \"동해\">");
				$("#browsers_2").append("<option value = \"목포\">");
				$("#browsers_2").append("<option value = \"보령\">");
				$("#browsers_2").append("<option value = \"수원\">");
				$("#browsers_2").append("<option value = \"안동\">");
				$("#browsers_2").append("<option value = \"경주\">");
				$("#browsers_2").append("<option value = \"제주\">");
				$("#browsers_2").append("<option value = \"삼척\">");
				$("#browsers_2").append("<option value = \"거제\">");
			}
			
			if(country == "일본")
			{				
				$("#browsers_2").append("<option value = \"오사카시\">");
				$("#browsers_2").append("<option value = \"나고야시\">");
				$("#browsers_2").append("<option value = \"고베시\">");	
				$("#browsers_2").append("<option value = \"사이타마시\">");					
				$("#browsers_2").append("<option value = \"히로시마\">");					
				$("#browsers_2").append("<option value = \"도쿄\">");
				$("#browsers_2").append("<option value = \"삿포로\">");
				$("#browsers_2").append("<option value = \"대마도\">");
				$("#browsers_2").append("<option value = \"아키타\">");
				$("#browsers_2").append("<option value = \"가와사카\">");
				$("#browsers_2").append("<option value = \"요코하마\">");
						
				
			}
			
			if(country == "프랑스")
			{
				
				$("#browsers_2").append("<option value = \"그랑빌\">");
				$("#browsers_2").append("<option value = \"나르본\">");
				$("#browsers_2").append("<option value = \"뇌이쉬르센\">");	
				$("#browsers_2").append("<option value = \"드뢰\">");	
				$("#browsers_2").append("<option value = \"파리\">");
				$("#browsers_2").append("<option value = \"리옹\">");
				$("#browsers_2").append("<option value = \"마르세유\">");
				$("#browsers_2").append("<option value = \"니스\">");
				$("#browsers_2").append("<option value = \"디낭\">");
				$("#browsers_2").append("<option value = \"디종\">");
				$("#browsers_2").append("<option value = \"반\">");
				$("#browsers_2").append("<option value = \"르블랑\">");
			}
			

			if(country == "독일")
			{
				
				$("#browsers_2").append("<option value = \"베를린\">");
				$("#browsers_2").append("<option value = \"함부르크\">");
				$("#browsers_2").append("<option value = \"뮌헨\">");	
				$("#browsers_2").append("<option value = \"프랑크푸르트\">");					
				$("#browsers_2").append("<option value = \"드레스덴\">");
			}
			
			
			
			if(country == "베트남")
			{
				
				$("#browsers_2").append("<option value = \"다낭\">");
				$("#browsers_2").append("<option value = \"호찌민\">");
				$("#browsers_2").append("<option value = \"하노이\">");	
				$("#browsers_2").append("<option value = \"풀리\">");					
				$("#browsers_2").append("<option value = \"미토\">");
				$("#browsers_2").append("<option value = \"뚜옌꽝\">");
				$("#browsers_2").append("<option value = \"무이네\">");
				
			}
			
			if(country == "영국")
			{
				
				$("#browsers_2").append("<option value = \"런던\">");
				$("#browsers_2").append("<option value = \"브라이튼\">");
				$("#browsers_2").append("<option value = \"맨체스터\">");	
				$("#browsers_2").append("<option value = \"리버풀\">");					
				$("#browsers_2").append("<option value = \"스완지\">");
				$("#browsers_2").append("<option value = \"버밍엄\">");
				$("#browsers_2").append("<option value = \"리즈\">");
				
			}
			
			if(country == "스위스")
			{
				
				$("#browsers_2").append("<option value = \"취리히\">");
				$("#browsers_2").append("<option value = \"베른\">");
				$("#browsers_2").append("<option value = \"인터라켄\">");	
				$("#browsers_2").append("<option value = \"그린델발트\">");					
				$("#browsers_2").append("<option value = \"바젤\">");
				$("#browsers_2").append("<option value = \"제네바\">");
				$("#browsers_2").append("<option value = \"로잔\">");
				
			}
			
			if(country == "스페인")
			{
				
				$("#browsers_2").append("<option value = \"바르셀로나\">");
				$("#browsers_2").append("<option value = \"마드리드\">");
				$("#browsers_2").append("<option value = \"톨레도\">");	
				$("#browsers_2").append("<option value = \"세비아\">");					
				$("#browsers_2").append("<option value = \"미하스\">");
				$("#browsers_2").append("<option value = \"쿠엥카\">");
				$("#browsers_2").append("<option value = \"콘수에그라\">");
				
			}
			
			if(country == "네덜란드")
			{
				
				$("#browsers_2").append("<option value = \"암스테르담\">");
				$("#browsers_2").append("<option value = \"로테르담\">");
				$("#browsers_2").append("<option value = \"아른헴\">");	
				$("#browsers_2").append("<option value = \"마스트리히트\">");					
				$("#browsers_2").append("<option value = \"히트호른\">");
				$("#browsers_2").append("<option value = \"데벤테르\">");
				$("#browsers_2").append("<option value = \"쯔볼레\">");
				
			}
			
			if(country == "이탈리아")
			{
				
				$("#browsers_2").append("<option value = \"나폴리\">");
				$("#browsers_2").append("<option value = \"소렌토\">");
				$("#browsers_2").append("<option value = \"폼페이\">");	
				$("#browsers_2").append("<option value = \"피렌체\">");					
				$("#browsers_2").append("<option value = \"로마\">");
				$("#browsers_2").append("<option value = \"아시시\">");
				$("#browsers_2").append("<option value = \"티볼리\">");
				
			}
			if(country == "미국")
			{
				
				$("#browsers_2").append("<option value = \"LA\">");
				$("#browsers_2").append("<option value = \"뉴욕\">");
				$("#browsers_2").append("<option value = \"워싱턴\">");	
				$("#browsers_2").append("<option value = \"텍사스\">");					
				$("#browsers_2").append("<option value = \"미네소타\">");
				$("#browsers_2").append("<option value = \"필라델피아\">");
				$("#browsers_2").append("<option value = \"시애틀\">");
				
			}



		}		
	)
	
		
}
