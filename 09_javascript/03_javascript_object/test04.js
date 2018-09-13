/*
    객체 이해하기 - 4

    일반적으로 함수내에서의 this는 함수를 호출한 객체이다.
*/

"use strict"

var m1 = {name:"Won Choi"}
var m2 = {name:"Aaron Choi"}

function getName(){
    return this.name
}

m1.getName = getName
m2.getName = getName

console.log(m1.getName())
console.log(m2.getName())

console.log(getName()) // error, browser에서는 this가 window로 대체. 
