// 변수 이해하기 - 9, 동적타입 이기 때문에 하나의 변수에 다양한 값을 대입할 수 있다,

"use strict"
var val = 10
console.log(val, typeof (val))

val = "hello"
console.log(val, typeof (val))

val = true
console.log(val, typeof (val))

val = new Object()
console.log(val, typeof (val))

val = undefined
console.log(val, typeof (val))

val = null
console.log(val, typeof (val))