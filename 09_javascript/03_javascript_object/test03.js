// 객체 이해하기 -3
// 객체를 변수에 저장하면 변수에는 객체의 주소가 참조(저장)된다. 
"use strict"

var member1 = {id:"choi", email:"choi@toy.com"}
var member2 = member1

member2.id = "hong"

console.log(member1)
console.log(member2)

// 객체의 프로퍼티를 가져오기
for(var key in member1){
    console.log(key, member1[key])
}

// 객체는 배열과 마찬가지로 모든 타입의 데이터를 저장할 수 있다. 
var obj = {
    str:"최원영",
    num: 100,
    bool: true,
    arr: [1,2],
    obj: {email:"a@a.com"},
    fn:function(){console.log("함수프로퍼티")}
}
