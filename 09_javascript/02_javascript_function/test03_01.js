/*
    ES6에서 추가된 화살표 함수

    함수를 심플하게 정의할 수 있도록 해준다.
    (Parameter) => 명령어 
*/
// Parameter가 하나도 없는 경우 
var func1 = function(){
    console.log("익명함수 func1")
}

func1()

func1 = () => {
    console.log("화살표 함수 func1")
}

func1()
console.log("-----------------------------------------------")

// Parameter 가 있는 경우 
var func2 = function(num){
    console.log("익명함수 func2",num)
}

func2(100)

// Parameter가 하나일때는 ()를 생략할 수 있다. 
func2 = num => {
    console.log("화살표 함수 func2",num)
}

func2(200)
console.log("-----------------------------------------------")

var func3 = function(num1,num2){
    console.log("익명함수 func3: "+num1,num2)
}

func3(100,200)

func3 = (num1, num2) => {
    console.log("화살표 함수 func3: "+num1,num2)
}

func3(200,300)
