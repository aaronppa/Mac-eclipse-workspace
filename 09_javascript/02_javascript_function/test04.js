/*
    오버로딩을 지원하지 않는다. 
    동일한 이름의 함수가 있을 경우 덮어쓰기 방식으로 처리됨
    함수를 호출 시 매개변수 개수에 영향을 받지 않는다. 

    익명함수
     - 함수의 이름을 선언하지 않은 형태 
     - 함수를 호출하기 위해서 변수에 담아서 사용한다. 
     - 함수의 호이스팅에서 제외된다. 
*/

"use strict"

var func = function(){ // 익명함수는 호이스팅에서 제외 되기 때문에 위로 올라가지 않음 
    console.log(0)
}
func() // 마지막으로 정의된 func()를 호출하게 됨 

function func(){console.log(1)}
func() // 위의 함수정의는 호이스팅으로 위로 올라가서 실행되고 위에라인에서 다시 실행하지 않음. 밑에 있는 func() 값이 엎어치기함

function func(){console.log(2)}
func() // 위의 함수정의는 호이스팅으로 위로 올라가서 실행되고 위에라인에서 다시 실행하지 않음. 밑에 있는 func() 값이 엎어치기함

function func(num1, num2, num3){console.log(3)}
func(1,2,3) // 위의 함수정의는 호이스팅으로 위로 올라가서 실행되고 위에라인에서 다시 실행하지 않음. 밑에 있는 func() 값이 엎어치기함


function func2(num){
    console.log("func2", num)
}

func2()
func2(100)
func2(100,100)