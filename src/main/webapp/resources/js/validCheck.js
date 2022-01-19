// 일반적으로 하는 유효성 검사들


//함수형태로 정리해서
//나중에 필요할때 쓰려고(쓰기 편하게)
//.jar 쓰던것처럼(lib)

//문제가 있을떄 true, 없으면 false

//<input> 을 넣으면..
//거기에 글자가 없으면 true, 있으면 false
function isEmpty(input){
		return !input.value;  //값이 없다
}

//<input>랑 글자수
//그 글자수 보다 적으면 true, 아니면 false

function lessThan(input, length){
	return input.value.length < length;
}

// <input>을 넣으면
// 한글/특수문자가 들어있으면 true 아니면 false

function containKR(input){
	let ok = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM1234567890@_.";
	
	
	for(let i=0; i<input.value.length; i++){
		if(ok.indexOf(input.value[i]) == -1){
			return true;
		}
	}
}	

// <input> *2 넣으면 
// 내용이 다르면 true, 같으면 false
function notEquals(input, input1){
	//if(input.vlaue == input1.value){
	//	return false;
	//}
	
	return input.value != input1.value;
}

//<input>, 문자열 세트
// 문자열 세트가 포함 안되있으면 true
// 들어있으면  false

function notContains(input, set){
	// input : 1qwease 로 입력
	// set   : 123456790 숫자을 반드시 포함시키고 싶을때
	for(let i = 0; i< set.length; i++){
		if(input.value.indexOf(set[i]) != -1){
			return false;
		}
	}
	return true;
}

//<input>을 넣어서
// 숫자가 아니면 true, false
function isNotNumber(input){
	return isNaN(input.value);
}

//<input>, 확장자를 넣게
// 최대한 넓은 범위로 활용하려 하는데
// 사이트마다 다 다를 수 있음
// xxx(photoInput, "jpg")
// 설정한 확장자이면 true, 설정한 확장자가 아니면 false
function isNotType(input, type){
	if(type != "."+jpg || type != "."+png){
		return false;
	}
}