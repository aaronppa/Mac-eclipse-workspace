/*
    콜백함수 이해하기 - 2
     - 매개변수로 함수 넘기기
     - 매개변수로 익명 함수 넘기기 
*/
"use strict"

function func(cb){
    console.log( typeof(cb))
    cb("hello","hi")
}

// Arrow Function
func(() =>console.log("myCall 호출됨"))

console.log("----------------------------------------------------------")
var myCall = function(){
    console.log("myCall 호출됨")
}
func(myCall)

// 위와 동일 
func(function(){console.log("myCall 호출됨")})
console.log("----------------------------------------------------------")

function myCall(msg, msg2){
    console.log("myCall 호출됨",msg, msg2)
}

// func(myCall()) // return되는 값이 없기때문에 undefined
func(myCall) // 함수명 자체를 func()에 넘겨주기때문에 function이란 타입으로 찍힘 
console.log("----------------------------------------------------------")

