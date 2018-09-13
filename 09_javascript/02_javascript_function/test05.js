/*
     함수의 매개변수 처리 
      - arguments: 함수의 매개변수를 포함하고 있는 함수 내부 프로퍼티 
      - 유사배열 객체 
      {"length":3,"0":100,"1":200,"2":300}
*/

"use strict"

function func(){
    console.log("-------------------------------")
    console.log(arguments.length)
    for (let i = 0; i < arguments.length;i++){
        console.log(arguments[i])
    }
}

func(1)
func(1,10,100)