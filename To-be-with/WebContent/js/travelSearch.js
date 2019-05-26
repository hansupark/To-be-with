function travelSearch()
{
	var user_country = $("#country").val();
	var user_region = $("#region").val();
	var user_travelDate = $("#travelDate").val();
	
	$.ajax
	(
	{
		type : "POST",
		url : "travelSearch.do",
		data : 
			{
			country : user_country,
			region : user_region,
			travelDate : user_travelDate
			},
		success : function(data)
		{			
			var parsed = JSON.parse(data);
			var result = parsed.result;
			var array = new Array();
			for(var i = 0 ; i < result.length ; i++)
			{
				var travel = {};
				travel.travelNum = result[i][0];
				travel.userNum = result[i][1];
				travel.travelDate = result[i][2];
				travel.country = result[i][3];
				travel.region = result[i][4];
				travel.maxCount = result[i][5];
				travel.currentCount = result[i][6];
				array.push(travel);				
			}
			loadModal(array);
		}
	}
	);
}

function loadModal(array)
{
	$("#basicExampleModal").modal();
}
