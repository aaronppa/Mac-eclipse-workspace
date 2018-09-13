/*
    회원 여러명의 데이터를 관리
    조조    33  남  성남
    유비    22  남  현덕
    장비    44  남  장수
    관우    11  남  수염
*/
"use strict"

function createMember(name, age, gender, addr){
    return {name: name, age:age, gender:gender, addr:addr}
}

var m1 = createMember("조조",33,"남","성남")
var m2 = createMember("유비",22,"남","현덕")
var m3 = createMember("장비",44,"남","장수")
var m4 = createMember("관우",11,"남","수염")

var list = []
list.push(m1)
