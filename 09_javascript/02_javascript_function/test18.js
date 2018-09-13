/*
    ES6 - 파라미터 디폴트 처리

*/

function func(num1, num2){
    if(!num1) num1 = 0
    if(!num2) num2 = 0

    console.log(num1,num2)
}

func()
func(100)
func(100,1000)

function func2(num1 = 0, num2 = 0){

    console.log(num1,num2)
}

func2()
func2(100)
func2(100,1000)