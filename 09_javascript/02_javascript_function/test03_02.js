// 화살표 함수 - 2 (실행문장 중심)
var func1 = function(num){
    return num * num
}
console.log(func1(100))

func1 = num =>{return num * num}
console.log(func1(200))

func1 = num =>{num * num}
console.log(func1(7)) // undefined, return없음 

// 실행할 문장이 한 문장일 경우에는 {}의 생략이 가능 
func1 = num => num * num // {}를 생략하면 return이 자동으로 처리 되는데 return을 쓰면 에러나고 {}을 쓰면 Return을 써야 함 
console.log(func1(7)) // 49

func1 = num => console.log(123)
console.log(func1(7)) // undefined, 넘겨주는 return 값이 없는 경우 

// 실행 문장이 하나 이상일 경우 {}를 써야 함 
func1 = num => { 
    console.log(num)
    return num*num
}
console.log(func1(6))

var func1 = () => () => {console.log("Hello")}

var func1 = function(){
    return function(){
        console.log("Hello")
    }
}

func1()() // func1 내부에 있는 익명 함수 호출 