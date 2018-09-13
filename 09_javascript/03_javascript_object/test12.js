// ES6: 객체의 프로퍼티 단축 사용 
var id = "hong",
    name = "홍길동",
    age = 22

var member1 = {
    id: id,
    name: name,
    age: age,
    info: function(){console.log("info")}
}

var member2 = {
    id,
    name,
    age,
    info: function(){console.log("info")}
}

var member3 = {
    id,
    name,
    age,
    info(){console.log("info")}
}

