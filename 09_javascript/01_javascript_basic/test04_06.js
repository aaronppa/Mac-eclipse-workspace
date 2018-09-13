/* 
    변수 이해하기 - 7
    변수와 데이터 타입
    
    정적 타입 (엄격 타입)
     - 변수의 선언시 용도를 고정하는 방식
     - 변수를 만들때 선언한 용도로만 값을 넣어야한다. 

    동적 타입 (Javascript)
     - 대입되는 값에 따라서 용도가 변경됨. 
     - javascript, python...

     6 Data Types
     ---------------------------
     기본 데이터 타입
     number
     string
     boolean
     null
     undefined
     ---------------------------
     객체 데이터 타입 (reference type)
     ---------------------------
     object
     ---------------------------
*/

"use strict"
var num1 = 10;
console.log("number: ", num1)

var num2 = 10.3;
console.log("number: ", num2)

var msg = "hi"
console.log("string: ", msg)

var boolean = true
console.log("boolean: ", boolean)

var nullVal = null
console.log("null: ", nullVal)

var unVal
console.log("undefined: ", unVal)

var obj1 = {}
console.log("object: ", obj1)

var obj2 = new Object()
console.log("object: ", obj2)