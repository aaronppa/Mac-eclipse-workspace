/*
    객체 이해하기 - 7
    자바스크립트 생성자
     - 일반함수와 동일하게 선언 
     - 생성자는 관례적으로 함수이름의 첫글자를 대문자로 시작 
     - Number, Date, Object, Boolean, String... 
     - 생성자로 사용하기 위해서는 new 와 함께 사용해야 함.. 
     - new와 함께 사용하는 함수는 this의 해석이 달라진다. 

     모든 함수 객체는 prototype이란 property(이것도 객체)를 가지고 있고, 
     일반 객체는 --proto라는 property를 가지는데 그 일반객체가 함수객체를 생성하는 것이면, 이는 부모함수객체의 prototype을 참조한다. 
     prototype chaining 
*/
"use strict"

function Member(){
    console.log(this)
}

var m1 = Member() // 생성자가 아님, undefined
console.log(m1) // return되는 값이 없으니깐, undefined

// Member 함수를 기준으로 한 새로운 객체를 생성 (this)
// 생성된 객체를 반환한다. 
// 생성자 함수 안에서의 this는 새롭게 생성된 객체를 나타낸다. 
var m2 = new Member() 
console.log(m2)

