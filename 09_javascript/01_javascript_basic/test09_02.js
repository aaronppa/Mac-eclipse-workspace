/*
    ES5
    
    forEach 반복문
    
    for ~ in 반복문 : 객체안의 키를 가져온다.

    ES6
    for ~ of 반복문 : 값을 반환
*/

"use strict"

var arr = [10, 20, 30, 40, 50]

for(let i = 0; i<arr.length;i++){
    console.log(arr[i])
}

console.log("------------------------------------------------------")
console.log("for ~ in : 1")
// for ~ in : for (변수선언 in 객체)
// var member = {"id":"aaa","name":"Won Choi"}
// arr = {0:10,1:20.2:30,3:,40,4:50}

for(var key in arr){
    console.log(key)
}

console.log("------------------------------------------------------")
console.log("for ~ in : 2")
// for ~ in : for (변수선언 in 객체)
// var member = {"id":"aaa","name":"Won Choi"}
// arr = {0:10,1:20.2:30,3:,40,4:50}

for(var key in arr){
    console.log(key, arr[key])
}

console.log("------------------------------------------------------")
console.log("forEach")
//forEach 반복문: 배열.forEach(콜백함수), 배열의 요소 수 만큼 콜백함수가 호출된다.
arr.forEach(function(val, i){
    console.log(val, i)
    // 중간에 빠져나올수 없다. 
})
// var a = function(){}

console.log("------------------------------------------------------")
console.log("for ~ of")
for (var val of arr){
    console.log(val)
}
