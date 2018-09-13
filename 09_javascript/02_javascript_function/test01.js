/*
    function[functionName](parameter,..){
        실행할 명령어..
        실행할 명령어..
        실행할 명령어..
        실행할 명령어..
        [return returnValue;]
    }
*/

// 1. 파라미터와 반환타입이 없는 경우
function func1(){
    console.log("1번")
}

func1()

// 2. 파라미터는 없고 반환타입이 있는 경우 
function func2(){
    console.log("2번")
    return 1;
}

var a = func2()
console.log(a)

// 3. 파라미터가 있고 반환값이 없는 경우
function func3(val){
    console.log("3번: "+val)
}

func3(100)

// 4. 파라미터와 반환값이 있는 경우 
function func4(val){
    console.log("4번: "+val)
    return val * val
}

console.log(func4(10))

