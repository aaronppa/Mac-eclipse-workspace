// 변수의 Scope
// 내부함수는 자신을 감싸고 있는 외부함수의 변수를 접근할 수 있다. 

"use strict"

var scope = "전역"
function func(){
    console.log(scope)
    var scope = "지역"
    function inner(){
        console.log(scope)
    }
    inner()
}

func()