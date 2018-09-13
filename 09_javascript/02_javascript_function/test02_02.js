/*
    함수 - 익명함수

    익명함수
     - 함수의 이름을 선언하지 않은 형태 
     - 함수를 호출하기 위해서 변수에 담아서 사용한다. 
     - 함수의 호이스팅에서 제외된다. 
*/

var f1 = "adfasdf...."

var func1 = function (){
    console.log("이름 없는 함수 : 익명함수...")
}

// 익명함수 호출하기
func1()

// 익명함수 호출
var func2 = function(val){
    return val * val
}
var result = func2(100)
console.log(result) // 10000

// 익명함수 호출시 함수는 호이스팅에 제외되어 뒤에 선언된 익명함수는 오류남 
var func3

func3()

var func3 = function(){
    console.log("func3 호출됨")
}
