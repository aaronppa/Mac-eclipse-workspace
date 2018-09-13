/*
    문자열 - 3

    - 여러줄 입력 처리 방식
    - 템플릿 리터럴 이라는 새로운 유형 도입함..

*/

"use strict"
var name = "최원영"
var msg1 = "저의 " +
"이름은 " +
name+" 입니다."
console.log("msg1: ",msg1)

var msg2 = "저의 \
이름은 "
+name+" 입니다."
console.log("msg2: ",msg2)

// `` 입력된 형태 그대로 출력된다. 
var msg3 = `저의 
이름은 
최원영 입니다.`
console.log("msg3: ",msg3)

var msg4 = `저의 이름은 ${name} 입니다.`
console.log("msg4: ",msg4)

var msg5 = `저의 
이름은 
${name} 입니다.`
console.log("msg5: ",msg5)