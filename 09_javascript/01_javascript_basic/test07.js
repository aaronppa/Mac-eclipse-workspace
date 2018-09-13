// 자바스크립트 형변환

//명시적 형변환
console.log(true, Number(true))
console.log(false, Number(false))
console.log("=======================================")

// 묵시적 형변환
console.log(true + 1)
console.log(false + 1)
console.log(true + false)
console.log("=======================================")

// 문자열은 빈문자열 또는 공백문자열은 숫자로 변경시 0
// 문자열 중에서 숫자로 변경이 불가한 경우에는 NaN
console.log("",Number("")) // 0
console.log(" ",Number(" ")) // 0
console.log("12",Number("12")) // 12
console.log("12",parseInt("12")) // 12
console.log("hello",Number("hello")) // NaN
console.log("hello",parseInt("hello")) // NaN
console.log("=======================================")
console.log("100원",Number("100원")) // NaN
console.log("100원",parseInt("100원")) // 100
console.log("=======================================")
console.log("$100",Number("$100")) // NaN
console.log("$100",parseInt("$100")) // NaN parseInt는 문자열 맨 왼쪽 부터 숫자를 읽어서 parse하는데 처음이 숫자가 아니면 숫자로 인식하지 않음 
console.log("=======================================")

// 문자열로 변환하기 
console.log(true, String(true))
console.log(false, String(false))
console.log(false, false + "")
console.log(12, String(12))

