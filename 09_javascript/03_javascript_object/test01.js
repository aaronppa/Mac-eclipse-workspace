/*
객체 이해하기 -1
객체는 문자열로 이름을 붙인 값들의 집합체
*/
//빈객체생성
var member = {}
//member객체에 id프로퍼티가 존재하지 않으면 추가,
//member객체에 id프로퍼티가 존재하면 수정!
//객체.프로퍼티 명 = 값
member.id = "hong"
member.id = "kim"
//객체["프로퍼티명"] = 값
// 없으면 추가 있으면 수정!!
member["email"] = "kim@a.coms"

//객체의 프로퍼티 확인
//객체.프로퍼티명
//객체["프로퍼티명"]
console.log(member)
console.log(member.id)
console.log(member)
//객체["프로퍼티먕]형태로 사용해야 하는 경우?
//프로퍼티명에 공백 또는 특수문자가 포함된 경우
//member.home-page = "http:www.hong.com"-> 에러발생, 이유 : home-page의 -를 마이너스 연산으로 인식하기때문  ;member.home   -   page
member["home-page"] = "http:www.hong.com"
console.log(member["home-page"] )