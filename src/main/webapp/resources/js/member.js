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

function membercall(){
	let id = document.myForm.id;
	let id2 = document.myForm.id2;
	let pw= document.myForm.pw;
	let pw1 = document.myForm.pw1;
	let name = document.myForm.name;
	let phonesecond = document.myForm.phonesecond;
	let phonethird = document.myForm.phonethird;
	let kor =  /^[가-힣]+$/;
	
	if (isEmpty(id)) {
        alert('아이디를 입력해주세요.');
        id.value = "";
        id.focus();

        return false;
	}
	

	if (isEmpty(pw) || lessThan(pw1, 3)) {
		alert('비밀번호를 입력해주세요.');
		pw.value = "";
		pw.focus();

		return false;
	}
	if (notEquals(pw, pw1)) {
		alert('비밀번호가 다릅니다.');
		pw.value = "";
		pw.focus();
		pw1.value = "";
		pw1.focus();
		return false;
	}

	if (isEmpty(name)) {
        alert('이름을 입력해주세요.');
        name.value = "";
        name.focus();

        return false;
	}
	
	if(!kor.test(name.value)){
		alert('이름을 정확하게 입력해 주세요.');
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
	
	if(id2.value == 0){
		alert('사용할 수 없는 아이디 입니다.')
		return false;
	} else {
		return true;
	}
		
	

	
}

function logincall(){
	let id = document.loginForm.id;
	let pw= document.loginForm.pw;
	
	
	if (isEmpty(id)) {
        alert('아이디를 입력해주세요.');
        id.value = "";
        id.focus();

        return false;
	}
	
	if (isEmpty(pw)) {
        alert('비밀번호를 입력해주세요.');
        pw.value = "";
        pw.focus();

        return false;
	}	 
	
}

function findidcall(){
	
	let name = document.myForm.name;
	let phonenumber= document.myForm.phonenumber;
	let kor =  /^[가-힣]+$/;
	
	if (isEmpty(name)) {
        alert('이름을 입력해주세요.');
        name.value = "";
        name.focus();

        return false;
	}
	
	if(!kor.test(name.value)){
		alert('이름을 정확하게 입력해 주세요.');
		name.value = "";
        name.focus();

        return false;
	}
	
	if (isEmpty(phonenumber)) {
        alert('전화번호를 입력해주세요.');
        phonenumber.value = "";
        phonenumber.focus();

        return false;
	}	 
	
	if(isNotNumber(phonenumber)){
		alert('전화번호에 숫자만 입력해주세요.');
		phonenumber.value = "";
		phonenumber.focus();

        return false;
        
      if(lessThan(phonenumber,11)){
    	alert('전화번호에 11자리를 입력해주세요.');
    	phonenumber.value = "";
    	phonenumber.focus();

          return false;
          
		  }
	}
}

function findpwcall(){
	let id = document.myForm.id;
	let name = document.myForm.name;
	let phonenumber= document.myForm.phonenumber;
	let kor =  /^[가-힣]+$/;
	let engnum = /^[a-zA-Z0-9]*$/;
	
	if (isEmpty(id)) {
        alert('아이디를 입력해주세요.');
        id.value = "";
        id.focus();

        return false;
	}
	
	if(!engnum.test(id.value)){
		alert('아이디를 정확하게 입력해 주세요.');
		id.value = "";
        id.focus();

        return false;
	}
	
	if (isEmpty(name)) {
        alert('이름을 입력해주세요.');
        name.value = "";
        name.focus();

        return false;
	}
	
	if(!kor.test(name.value)){
		alert('이름을 정확하게 입력해 주세요.');
		name.value = "";
        name.focus();

        return false;
	}
	
	if (isEmpty(phonenumber)) {
        alert('전화번호를 입력해주세요.');
        phonenumber.value = "";
        phonenumber.focus();

        return false;
	}	 
	
	if(isNotNumber(phonenumber)){
		alert('전화번호에 숫자만 입력해주세요.');
		phonenumber.value = "";
		phonenumber.focus();

        return false;
	}
	
	if(lessThan(phonenumber,11)){
		alert('전화번호에 11자리를 입력해주세요.');
		phonenumber.value = "";
		phonenumber.focus();

        return false;
	}
}

