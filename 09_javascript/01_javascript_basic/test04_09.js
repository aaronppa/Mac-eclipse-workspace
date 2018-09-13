/*
    변수 이해하기 - 10 

    변수의 범위

*/

"user strict"

var msg = 1
if(msg==1){
    var msg = 2
    console.log(msg)
}

console.log(msg)

{ 
    var msg2 = 3
}
console.log(msg2)

/*
    호이스팅

    var msg
    var msg2

    msg = 1
    if(msg==1){
        msg = 2
        console.log(msg) // 2
    }

    console.log(msg) // 2

    { 
        msg2 = 3
    }
    console.log(msg2) // 3
*/