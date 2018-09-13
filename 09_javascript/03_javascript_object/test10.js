// 객체 이해하기
// prototype 자체를 새롭게 변경할 수 있다.

function Member(id, name){
    this.id = id
    this.name = name
}

Member.prototype.setId = function(id){ this.id = id}
Member.prototype.getId = function(id){ return this.id}
Member.prototype.setName = function(name){ this.name = name}
Member.prototype.getName = function(name){ return this.name}

// 위와 동일한 기능이지만, 새로운 공간을 만들고 prototype property 전체를 새로 만들어 prototype이 가지고 있는 주소를 새롭게 가져간다.
// 기존에 있던 prototype property 객체는 이때 constructor를 내부에서 만들어서 기존의 함수 객체를 가르친다. 
// 새롭게 생성된 prototype property는 생성시 constructor가 생성되지 않는다. 
Member.prototype = {
    setId: function(id){ this.id = id},
    getId: function(id){ return this.id},
    setName: function(name){ this.name = name},
    getName: function(name){ return this.name}
}

// 만약 constructor를 새로운 prototype property 객체에 유지시키고 싶다면, 만들어줘야 한다.  
Member.prototype.constructor = Member

