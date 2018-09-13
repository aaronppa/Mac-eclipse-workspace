/*
    함수 - 선언적 함수
    
    선언적 함수란?
     - 함수의 이름이 존재하는 것 
     - 컴파일 시점에 함수 정보를 등록(함수의 호이스팅)
     - 함수를 선언하기 이전에 호출이 가능
     - 함수의 별도의 return문 사용하지 않는 경우 디폴트로 undefined가 반환된다. 

*/

"use strict"

function func1(num1, num2){
    return num1 + num2
}

var result = func1(10,100)
console.log("func1(): "+result)

result = func2()
console.log("func2(): "+result)
function func2(){
    return "선언전에 호출가능?"
}

function func3(){
    console.log("func3번 실행")
}
console.log(func3()) // 리턴값이 없음, func()은 실행해서 func3()내부 코드가 실행되지만, 정작 console.log(func3())
// 때에는 func3()의 리턴 값이 없기 때문에 undefined가 출력됨. 

/*
    호이스팅 순서 

    function func1; - 주소
    var result;
    function func2; - 주소

    result = func1(10,100)
    console.log("func1(): "+result)

    result = func2()
    console.log("func2(): "+result)

*/