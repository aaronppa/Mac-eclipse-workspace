// 논리연산자의 활용
// 조건문을 대신해서 처리 

"use strict"
var num = 10
if((num%2)==0){
    console.log("num is even")
}

// 참일 경우에만 && 이후 실행 
((num%2)==0) && console.log("num is even");

// 거짓일 경우 || 이후 실행
((num%2)!=0) || console.log("num is odd");

if(msg){
    msg = "^^^"
}

var msg;
msg = msg || "^^^" // 대입이 마지막에 실행 됨. undefined가 false이기 때문에 "^^^^"를 읽고 msg= 에 대입함 
console.log(msg);
