/*
    ES6 디스트럭쳐링(Destructuring)
    - 객체(배열, 객체)에 입력된 값을 개별적인 변수에 할당하는 간편 방식 
*/
"use strict"
var arr1 = [1,2,3];

var a = arr1[0]
var b = arr1[1]
var c = arr1[2]
console.log(a,b,c)

var arr2 = [10,20,30];

// 변수가 선언이 된 후에만 사용가능 
[a,b,c]= arr2;
console.log(a,b,c);

[a,b,c]= [100,200];
console.log(a,b);

[a,b]= [100,200];
console.log(a,b);

[a,,c]= [1000,2000,3000];
console.log(a,c);

[a,b=0,c=0]= [10000,20000];
console.log(a,b,c);

// 객체를 이런방식으로 하고 싶으면 {}를 사용하고 property를 써라 
