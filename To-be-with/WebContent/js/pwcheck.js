$('#inputConfirmPassword').focusout(
	function()
	{
		pw = $("#inputPassword").val();
		pwcheck = $("#inputConfirmPassword").val();
		
		if(pw != pwcheck)
		{
			alert("비밀번호 다름");
			$("input[name=password]").attr("style","border-color:red;");
			$("input[name=inputConfirmPassword]").attr("style","border-color:red;");
		}
		else	//원상태로 복귀 #ced4da
		{
			$("input[name=password]").attr("style","border-color:#ced4da;");
			$("input[name=inputConfirmPassword]").attr("style","border-color:#ced4da;");
		}
	}

)