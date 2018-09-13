/*
    배열 - 1
     - 배열 생성 : [], Array()
       
*/

var arr1 = []
var arr2 = new Array()
console.log("------------------------------------------------------------")
console.log(arr1.length, arr2.length)

/*
    배열은 여러가지의 데이터 타입을 하나의 배열에 입력할 수 있다. 
    크기가 지정되어 있는 않은 경우에도 데이터의 입력이 가능하다. (동적 배열)
    배열의 길이는 가장 큰 인덱스 + 1 한 값이다. 
*/

arr1[0] = 10
arr1[2] = 30
console.log("------------------------------------------------------------")
console.log(arr1[0], arr1[1], arr1[2])

arr1[3] = "문자열"
arr1[4] = {}
arr1[5] = [1,2,3]
arr1[6] = true
arr1["id"] = "aaronppa"
console.log("arr1.length: w/ \"id\": " + arr1.length) // index key값이 숫자가 아니기 때문에 arr1.length=7
arr1["99"] = "과연??"
console.log("arr1.length w/ \"99\": " + arr1.length)
console.log("------------------------------------------------------------")
arr1.forEach(function(val){
    console.log(val)
})



