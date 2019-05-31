function userDelete(_userNum)
{
	$.ajax
	(
	{
		type : "POST",
		url : "userDelete.do",
		data : 
			{
			userNum : _userNum
			},
		success : function(result)
		{			
			if(result == 1)
			{
				alert("삭제 성공");
			}
			else
			{
				alert("삭제 실패");
			}
		}
	}
	);
	location.reload();
}