/*
    변수 이해하기 - 8

    변수의 자료형 검사
     - typeof 데이터 -> 결과가 문자열로 반환
     - typeof (데이터)
     - null 데이터 타입은 반환하는 값이 "null"이 아닌 "object"를 반환 
     
*/

"use strict"

console.log( typeof ("test"))
console.log( typeof (10))
console.log( typeof (true))
console.log( typeof (null)) // object 
var a
console.log( typeof (a))
console.log( typeof ({}))

// function : 함수는 특별한 기능을 가진 객체 (일급 객체)
console.log( typeof (function() {})) // function object

