/*
    변수 이해하기 - 11(ECMA2015, ES6)

    let
     - 선언된 블럭에서만 사용 가능 
     - 호이스팅 대상에서 제외됨...
*/

"use strict"

var msg = 1
if(msg==1){
    let msg = 2 // 호이스팅 대상 제외...
    console.log(msg)
}

console.log(msg)

{
    let msg2 = 3
}

console.log(msg2)

/* 
let msg = 3

console.log(msg)

SyntaxError: Identifier 'msg' has already been declared
*/