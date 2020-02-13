var joinvalidate = {
	// 결과 메시지 출력하는 사용하는  text

	resultCode : {
	//공통
	 empty_val : {
	 code: 1,
	 desc: '필수 정보입니다.'
	}, 
	space_length_val : {
	code: 2,
	desc :'공백없이  입력해주세요'
	},
	//ID
	succes_id :{

	code: 0,
	desc : '멋진 아이디네요:)'
   },
   specialStr_id : {
   		code: 3,
   		dsec : '아이디는 영문 소문자, 숫자, 특수기호 일부만 사용할 수 있습니다.'
   },
	invalid_id : {
	code: 4,
	desc : '올바른 ID를 입력해주세요.'
  },
  first_special_id : {
  	code : 5,
  	desc : '첫 글자는 특수문자를 사용하실 수 없습니다.'
  },
  length_id : {
    code : 6,
	desc : '아이디는 5자이상 ~ 20자 하여야 합니다'
  },
  overlap_id : {
    code : 7,
	desc : '이미 사용중인 ID 입니다.'
	 },
	 //pw
	 success_pw : {
	    code : 0,
		desc : '사용가능한 비밀번호 입니다.'
	 },
	 equal_success_pw : {
	 	code: 10,
		desc: '입력한 비밀번호가 일치합니다.'
	 },
	 invalid_pw : {
		code: 3,
		desc: '비밀번호는 8자 이상, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.'
	 },
	 stream_pw : {
		code: 4,
		desc: '같은 문자를 4번 이상 사용할 수 없습니다.'
	 },
	 hangul_pw : {
		code: 5,
		desc: '비밀번호에는 한글을 포함할 수 없습니다'
	},
	other_pw : {
		code: 6,
		desc: '입력한 비밀번호가 일치하지 않습니다.'
	},
	equal_pw : {
		code: 7,
		desc: '현재 비밀번호와 다르게 입력해주세요.'
	},
	empty_rpw : {
		code: 8,
		desc: '비밀번호 작성이 필요합니다.'
		},
	//name
	success_name : {
		code : 0,
		desc : '멋진 이름이네요:)'
	},
	invalid_name : {
		code : 3,
		desc : '이름은 표준한글만 입력가능합니다.'
	},
	length_name : {
		code : 4,
		desc : '이름은 2자이상 ~ 4자이하만 가능합니다.'
	}, 
	// phone
	success_phone : {
		code : 0,
		desc : '사용가능한 번호 입니다.'
	},
	invalid_phone : {
		code : 3,
		desc : '휴대폰 번호가 유효하지 않습니다.'
	},
	length_phone : {
		code : 4,
		desc : '(-)없이 10, 11자로 입력해주세요'
	},
	number_phone : {
		code : 5,
		desc : '숫자만 입력해주세요.'
	},
	//email 
	success_email : {
		code : 0,
		desc : '사용가능한 이메일 입니다.'
	},
	invalid_email : {
		code : 3,
		desc : '올바른 이메일을 입력해주세요 '


	},
	// address
		success_addr : {
			code: 0,
			desc: '확인되었습니다.'
		},
		empty_post : {
			code: 3,
			desc: '우편번호가 필요합니다.'
		},
		empty_detail : {
			code: 4,
			desc: '상세주소를 입력해주세요.'
		},
		invalid_addr : {
			code: 5,
			desc: '올바른 주소를 입력해주세요.'
		}
},
		// 아이디 유효성 체크
	 checkid : function(id) {
 	   var regEmpty = /\s/g; // 공백문자 
	   var regEtc = /[~'!@#$%^&*()+=\|\\\{\}\[\]:";'<>.?//]/g; // 특수문자 
	   var regId = /[^a-z0-9-_.]+/g;

			if(id == '' || id.length == 0) { // 1.값이 있는지 없는지 or 스페이스 값으로 으로 공백이 들어가있는지 
			
           return this.resultCode.empty_val;
		} else if (id.match(regEmpty)) { // 2. 값사이에  공백값
				
			return this.resultCode.space_length_val;
		} else if(id.match(regEtc)) { // 3. 특수문자 
			
			return this.resultCode.specialStr_id;
        } else if(id.match(regId)) { // 4. 아이디 정규식 체크
            
        	return this.resultCode.invalid_id;
		} else if(id.charAt(0) == '_' || id.charAt(0) == '-') { // 5.첫글자 특수문자 사용 여부				

			return this.resultCode.first_special_id;
		} else if(id.length < 5 || id.length > 20) {  
		
			return this.resultCode.length_id;
		}else {
			return this.resultCode.succes_id;
		}

	},

	 // 비밀번호 유효성 체크 

	 checkpw : function(pw, rpw) {

	 	// 값이 있으면 true를 보냄 
		var regEmpty = /\s/g;   // 공백문자
		// 값이 있으면 false를 보냄 ^가 그걸 바꿈
		var regPw = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&_.*-]).{8,}$/;
		var regHangul = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;

		if(pw == '' || pw.length == 0){ // 1. 값이 있는지 체크
			return this.resultCode.empty_val;
		
		}else if(pw.match(regEmpty)){ // 2. 공백값이 있는지 체크
			return this.resultCode.space_length_val;
		
		} else if(/(\w)\1\1\1/.test(pw)){ // 3. 같은 값이 4번연속으로 사용했는지 체크
			return this.resultCode.stream_pw;
		
		} else if(regHangul.test(pw)){ // 4. 한글 사용 체크
			return this.resultCode.hangul_pw;
		
		} else if(!pw.match(regPw)) { // 5. 유효한 비밀번호 체크
			// ^가 있어서 !로 반대로 해줘야함
			return this.resultCode.invalid_pw;	
		// 값이 없는데 값이 같은지 다른지 체크하면 아직 재확인 pw를 적지않았는데도 두개가 같지않다고 나옴 
		// 그래서 값이 있는지 없는지를 먼저 체크해야함
		
		} else if(rpw != '' || rpw.length != 0){ // 6. 비밀번호 재확인 값이 있으면 실행
			if(pw == rpw){
				return this.resultCode.equal_success_pw;
			} else{
				return this.resultCode.other_pw;
			}
		} else {
			return this.resultCode.success_pw;
		}
	 },
	  checkRpw : function(pw, rpw, pwFlag){
		// 비밀번호의 유효성체크를 통과한 값과 비밀번호 재확인값이 같다면 
		// 비밀번호 재확인 값은 유효성 체크를 할 필요가 없음
		if(rpw == '' || rpw.length == 0){ // 1. 값이 있는지 체크
			return this.resultCode.empty_val;

		} else if(!pwFlag){	// 3. pw가 올바르지 않을때 
			return this.resultCode.invalid_pw;
		} else { // 4. 비밀번호 재확인 값이 있으면 실행
			if(pw == rpw && pwFlag){
				return this.resultCode.equal_success_pw;
			} else{
				return this.resultCode.other_pw;
			}
		} 
	},
	 checkName : function(name){
		var regEmpty = /\s/g;   // 공백문자
		var regName = /^[가-힣a-zA-Z]+$/;

		if(name == '' || name.length == 0){ // 1. 값유무
			return this.resultCode.empty_val;
		} else if(name.match(regEmpty)){ // 2. 공백유무
			return this.resultCode.space_length_val;
		} else if(!name.match(regName)){ // 3. 유효한 이름
			return this.resultCode.invalid_name;
		} else if(name.length < 2 || name.length > 20){ // 3. 2~20자
			return this.resultCode.length_name;
		} else {	// 통과!
			return this.resultCode.success_name;
		}
	},
		checkPhone : function(phone){
		var regEmpty = /\s/g;   // 공백문자
		var regPhone = /^01([0|1|6|7|8|9])([0-9]{3,4})([0-9]{4})$/g;
		if(phone == '' || phone.length == 0){ // 1. 값유무
			return this.resultCode.empty_val;
		} else if(phone.match(regEmpty)){ // 2. 공백유무
			return this.resultCode.space_length_val;
		} else if(!phone.match(regPhone)) { // 3. 유효한 번호
			return this.resultCode.invalid_phone;
		} else {
			return this.resultCode.success_phone;
		}


	},
	
	checkAddr : function(addrDetail, addrPost){
		// 영어대문자, 영어소문자, 한글, -, 공백외에 전부 체크
		var regAddr = /^[가-힣a-zA-Z0-9\-@\s]+$/;

		if(addrPost == '' || addrPost.length == 0){ // 1. 우편번호 값유무
			return this.resultCode.empty_post; //3
		} else if(addrDetail == '' || addrDetail.length == 0){ // 2. 상세주소 값유무
			return this.resultCode.empty_detail; //4
		} else if(!addrDetail.match(regAddr)){	// 3. 정규식 체크
			return this.resultCode.invalid_addr; //5
		} else{
			return this.resultCode.success_addr; //0
		}
 
	}


}


