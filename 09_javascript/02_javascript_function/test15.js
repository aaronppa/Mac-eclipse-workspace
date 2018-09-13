/*
    클로저
     - 함수내의 지역변수를 함수 외부에서 사용할 수 있게 하는 기술이다.
     - 생명주기가 종료된 함수의 변수를 참조하게 한다. 

*/
function outer0(val){
    var msg = "당신의 메세지: "+val
    return msg
}

console.log(outer0())

function outer(val){
    var msg = "당신의 메세지: "+val
    return function(){return msg}
}

var fn = outer("hi~")

console.log(fn())