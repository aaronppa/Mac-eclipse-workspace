/*
    글로벌 변수와 로컬 변수의 이름을 동일하게 선언해도 상관없음..
*/

"use strict"
var msg="글로벌 변수"
console.log("msg", msg)

function func(){
    var msg = "Local Variable"
    console.log("msg: ",msg)
}
func()

console.log(msg)