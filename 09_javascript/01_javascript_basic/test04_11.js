/*
    변수 이해하기 - 12

    let 
     - 중복 선언 불가능

     const
      - 상수로 사용(값을 할당하면 값을 변경할 수 없다.)
      - 선언할 때 값을 할당해야 한다.
      - 호이스팅 대상 제외 
      - {}이 scope로 적용됨 
      - let은 값의 변경이 가능하지만 const는 값의 변경이 불가능함. 

*/
"use strict"

var msg1 = 1
var msg1 = 2
console.log(msg1)

let msg2 = 3
// let msg2 = 4
console.log(msg2) // Identifier 'msg2' has already been declared 중복 불가 (나중 변수에 let을 빼면 변수에 덮어쓰기)

const msg3 = "상수"
// msg3 = "변수"
console.log(msg3) // Assignment to constant variable.

const msg4;
// msg4 = "선언시 값을 할당해야 한다."
console.log(msg4) // Missing initializer in const declaration

