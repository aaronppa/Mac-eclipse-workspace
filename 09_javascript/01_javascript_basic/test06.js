/*
    자바스크립트 false

    null, undefined, 0, '', NaN(Not a Number)
*/

console.log("!0 : ", !0)
console.log("!!0 : ", !!0)
console.log("!!'' : ", !!'')
console.log("!!null : ", !!null)
console.log("!!undefined : ", !!undefined)
console.log("!!NaN : ", !!NaN)

var id
if(id){
    console.log("id가 값이 있음")
} else{
    console.log("id가 값이 없음")
    id = "값 채움"
}

console.log(id)

// 숫자는 0 이외는 모두 true이다. 
console.log("!!0 : ", !!0)
console.log("0 : ", Boolean(0))

// 문자열은 빈문자열(space는 빈문자열이 아님) 이외는 모두 true 
console.log("", Boolean(""))
console.log("", Boolean(" "))
console.log("Hello : ", Boolean("Hello"))