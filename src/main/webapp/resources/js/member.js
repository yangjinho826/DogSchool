function logout(){
	let ok = confirm("로그아웃 하시겠습니까?")
	if (ok) {
		location.href = 'member.logout';

	}
}

function signup(){
	location.href = "member.signup"
}

function signupgo(n){
	location.href = "member.signupgo?type="+n 
}
