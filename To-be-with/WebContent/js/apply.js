function applyInsert(_travelNum,_userNum)
{
	$.ajax
	(
	{
		type : "POST",
		url : "applyInsert.do",
		data : 
			{
			travelNum : _travelNum,
			userNum : _userNum,
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

function applyAccept(_applyNum,_travelNum)
{
	$.ajax
	(
	{
		type : "POST",
		url : "applyAccept.do",
		data : 
			{
			applyNum : _applyNum
			},
		success : function(result)
		{
			if(result == 0)
			{
				alert("수락실패 : 이미 인원수가 다참");
			}
			else if(result == 1)
			{
				$.ajax
				(
				{
					type : "POST",
					url : "travelIncreaseCount.do",
					data : 
						{
							travelNum : _travelNum
						},
					success : function(result)
					{
						if(result == 1)
						{
							alert("수락성공");
						}
						else
						{
							alert("수락실패 2");
						}
					}
				}		
				)				
			}
		}
	}
	);
	location.reload();
}
function applyCancel(_applyNum,_travelNum)
{
	$.ajax
	(
	{
		type : "POST",
		url : "applyDelete.do",
		data : 
			{
			applyNum : _applyNum
			},
		success : function(result)
		{
			if(result == 0)
			{
				alert("취소 실패");
			}
			else if(result == 1)
			{
				$.ajax
				(
				{
					type : "POST",
					url : "traveldecreaseCount.do",
					data : 
						{
							travelNum : _travelNum
						},
					success : function(result)
					{
						if(result == 1)
						{
							alert("수락성공");
						}
						else
						{
							alert("수락실패 2");
						}
					}
				}		
				)				
			}
		}
	}
	);
	location.reload();
}