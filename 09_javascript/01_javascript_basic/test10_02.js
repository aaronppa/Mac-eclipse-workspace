/*
    배열 - 2
*/
"use strict"

var arr = [10,20,30]

//배열에 요소 추가하기 : 마지막
arr[arr.length] = 40
arr[arr.length] = 50

console.log(arr)
console.log("----------------------------------------")
arr.push(60)
console.log(arr)

var arr2 = arr
console.log(arr2)
arr2.push(70)
console.log(arr2)
console.log(arr)
console.log("----------------------------------------")

// 배열의 요소 삭제 
// splice(삭제할 인덱스 시작위치, 삭제할 데이터의 크기)
arr.splice(1,1)
console.log(arr)
