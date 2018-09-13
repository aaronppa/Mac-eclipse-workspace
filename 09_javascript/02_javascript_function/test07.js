/*
    내부함수
     - 함수안에 선언된 함수
     - 내부함수의 호출은 자신이 선언된 외부함수안에서만 접근할 수 있다, 
*/

"use strict"

 function outerFn(){
     console.log("otherFn")
     function innerFn(){
         console.log("innerFn")
     }
     // 내부함수 호출
     innerFn()
 }

 outerFn()
//  innerFn() // ReferenceError: innerFn is not defined
