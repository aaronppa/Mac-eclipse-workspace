// 콜백함수 이해하기 - 3, 함수를 결과로 리턴하자..

function func(){
    function cb(){
        console.log("리턴된 함수 실행")
    }
    return cb
}
func() // 뒤에 () 가 붙어야만 최종 출력 실행
var myCb = func() // 함수를 리턴받음
console.log(typeof(myCb))
myCb() 

function func2(){
    return function() {console.log("func2안의 리턴된 함수 실행됨")}
}
var result = func2()
// var result = function() {console.log("func2안의 리턴된 함수 실행됨")}
result()

function func3(){
    return () => {console.log("func3안의 실행결과 리턴된 함수 실행됨")}
}
func3() // 뒤에 () 가 붙어야만 최종 출력 실행
var cb = func3()
cb()

func3()()