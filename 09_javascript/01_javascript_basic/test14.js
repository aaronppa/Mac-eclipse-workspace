/*
    NodeJS를 이용한 외부모듈(Third Party) 사용하기 

    promtp-sync install

    npm install prompt-sync
*/
"use strict"

var prompt = require('prompt-sync')();
//
// get input from the user.
//
var name = prompt('이름 : ');
console.log("이름 : "+name)
