function reportModalLoad(_travelNum)
{
	$("#fullHeightModalRight_report").modal();
	$("#travelNum").val(_travelNum);
}

function reportInsert_travel(_reporterNum)
{
	_travelNum = $("#travelNum").val();
	_title = $("#reportTitle").val();
	_content = $("#reportContent").val();
	$.ajax
	(
	{
		type : "POST",
		url : "reportInsert.do",
		data : 
			{
			objectNum : _travelNum,
			reporterNum : _reporterNum,
			title : _title,
			content : _content
			},
		success : function(result)
		{
			if(result == 0)
			{
				alert("신청실패");
			}
			else if(result == 1)
			{
				alert("신청성공");
			}
		}
	}
	);
	location.reload();
}




function reportApproved(_type,_objectNum)
{
	if(_type == 0)
	{
		$.ajax
		(
		{
			type : "POST",
			url : "reportApprove.do",
			data : 
				{
				objectNum : _objectNum,
				type : _type
				},
			success : function(result)
			{
				if(result == 0)
				{
					alert("승인실패");
				}
				else if(result == 1)
				{
					alert("승인성공");
				}
			}
		}
		);
	}
}