/*
    객체 이해하기 - 2
    객체 생성시 값의 초기화 및 프로퍼티 삭제하기 

*/

var member = new Object()
var member = {"id":"hong","name":"Won Choi"} // JSON 표현법, key는 항상 ""을 써야함 
member.email = "choi@a.com"

console.log(member)

// 프로퍼티 삭제하기: delete 객체.프로퍼티명
delete member.email
console.log(member)

// 객체 자체는 삭제 불가능함..
delete member
console.log(member)

// 객체는 프로퍼티 이름 선언시 ""를 생략할 수 있다. 특수문자가 들어간 경우에는 "" 필수 
var member2 = {id:"kim", name:"김철수"}
console.log(member2)
