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

function userApprove(_userNum)
{
	$.ajax
	(
	{
		type : "POST",
		url : "userApprove.do",
		data : 
			{
			userNum : _userNum
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
	
	$.ajax
	(
	{
		type : "POST",
		url : "signUpImageDelete.do",
		data : 
			{
			userNum : _userNum
			}
	}
	);
	location.reload();
}