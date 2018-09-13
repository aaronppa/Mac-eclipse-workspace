/*
    변수의 범위

    글로벌 변수, 로컬 변수 
     - 글로벌 변수 :  함수 밖에 선언, 전역에서 사용가능 
     - 로컬 변수 :  함수 안에 선언, 함수 내에서 사용 가능,    

*/

"use strict"
var msg="글로벌 변수"
console.log("msg", msg)

function func(){
    var localMsg = "Local Variable"
    console.log("localMsg: ",localMsg)
}
func()

console.log(localMsg)

/*
클로저 기술을 통해서 노컬 변수를 사용할 수 있음. 


function outer(val){
    var msg = "당신의 메세지: "+val
    return function(){return msg}
}

var fn = outer("hi~")

console.log(fn())

*/