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

function login(n){
	location.href = "member.login?type="+n 
}

function Memberinfo(){
	location.href = "member.info"; 
}

function bye() {
	var ok = confirm("탈퇴 하시겠습니까?");
	if (ok) {
		location.href = "member.bye";
	}
}

function findidgo(){
	location.href="member.findidgo"
}

function findpwgo(){
	location.href = "member.findpwgo"
}

function call(){
	let id = document.myForm.id;
	let pw= document.myForm.pw;
	let pw1 = document.myForm.pw1;
	let name = document.myForm.name;
	let phonesecond = document.myForm.phonesecond;
	let phonethird = document.myForm.phonethird;
	
	if (isEmpty(id)) {
        alert('아이디를 입력해주세요.');
        id.value = "";
        id.focus();

        return false;
	}

	if (isEmpty(pw) || lessThan(pw1, 3)) {
		alert('비밀번호를 입력해주세요.');
		password.value = "";
		password.focus();

		return false;
	}
	if (notEquals(pw, pw1)) {
		alert('비밀번호가 다릅니다.');
		password.value = "";
		password.focus();
		password1.value = "";
		password1.focus();
		return false;
	}

	if (isEmpty(name)) {
        alert('이름을 입력해주세요.');
        name.value = "";
        name.focus();

        return false;
	}
	
	if (isEmpty(phonesecond)) {
        alert('전화번호를 입력해주세요.');
        phonesecond.value = "";
        phonesecond.focus();

        return false;
	}
	
	if (isEmpty(phonethird)) {
        alert('전화번호를 입력해주세요.');
        phonethird.value = "";
        phonethird.focus();

        return false;
	}

	
	if(isNotNumber(phonesecond)){
		alert('전화번호에 숫자만 입력해주세요.');
        phonesecond.value = "";
        phonesecond.focus();

        return false;
	}
	
	if(isNotNumber(phonethird)){
		alert('전화번호에 숫자만 입력해주세요.');
        phonethird.value = "";
        phonethird.focus();

        return false;
	}
	
	if(lessThan(phonesecond,4)){
		alert('전화번호에 4자리를 입력해주세요.');
        phonesecond.value = "";
        phonesecond.focus();

        return false;
	}
	
	if(lessThan(phonethird,4)){
		alert('전화번호에 4자리를 입력해주세요.');
        phonethird.value = "";
        phonethird.focus();

        return false;
	}

	
}

