/*
    문자열 - 1

     - ""
     - ''
     - 문자열을 "+"를 사용
     - ""또는 ''을 문자열로 출력할 경우 "\"를 앞에 붙여서 사용 

*/

"use strict"

var msg = "자바스크립트 문자열"
console.log(msg)

msg = '자바스크립트 문자열'
console.log(msg)

msg = "나의 이름은 \"최원영입\"니다."
console.log(msg)

/*
    <input type='text' onclick='alter("안녕")' />
*/

var html = "<input type=\'text\' onclick=\'alter(\"안녕\")\' />"
console.log(html)

var html = "<input type='text' onclick='alter(\"안녕\")' />"
console.log(html)