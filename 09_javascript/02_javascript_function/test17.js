// JSON.parse - ES5
// 문자열의 내용이 JSON 객체 형태일 경우 객체로 변환
// 외부 사이트의 데이터를 가져오거나 데이터베이스의 내용을 스크립트해서 사용할 때
// Ajax - 데이터를 XML 또는 json 형태로 받는다. 

"use strict"
var data = '{"id":"abc","name":"hong","email":"abc@a.com"}'
var obj = JSON.parse(data)
console.log("id",obj.id)


