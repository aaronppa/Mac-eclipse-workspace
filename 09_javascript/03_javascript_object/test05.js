/*
    객체 이해하기 - 5
     - 객체는 연관성 있는 데이터를 묶어서 관리하고 싶을 때 
     - 데이터와 기능을 분리.. 
*/
"use strict"

var member = {
    id: "aaronppa",
    name: "Won Choi",

    setId: function(id){
        this.id = id
    },
    getId: function(){
        return this.id
    }
}

console.log(member.id, member.getId())

member.id = "kim"

member.setId("cfidelis7")

console.log(member.id, member.getId())