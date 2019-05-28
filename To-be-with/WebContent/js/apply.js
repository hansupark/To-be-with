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
}