// undefined, null, NaN

"use strict"

// undefined의 경우 변수는 존재하지만 값을 지정하지 않아서 타입을 모르는 경우
var msg1;

if(msg1 == undefined){
    console.log("변수는 존재하지만 값이 없는 상태임")
}

var msg2 = 20
msg2 = undefined // 존재하는 변수를 undefined로 설정할 수 있다. 

msg2 == undefined && console.log("undefined는 직접 비교가 가능함")

// null
var msg3 =  null // 특정 객체가 주소를 가리키지 않은 상태를 지정할 떄 null을 사용

if(msg3 == null) console.log("msg3는 null 상태임")


var msg4 = 10 - "a"
console.log(msg4) // NaN

var msg5 = 10 - msg3
console.log(msg5) // 10, Number(null)==0

// NaN
if(msg4 == NaN){
    console.log("msg4는 NaN이다.") // NaN과 NaN는 비교 불가, 출력되지 않음(false)
}

// 값의 비교를 위해서 isNaN 함수를 활용
if(isNaN(msg4)) console.log("msg4는 NaN이다.")

var msg6 = 10 - null
console.log(Number(null))

var msg7 = 10 * undefined
console.log(msg7)