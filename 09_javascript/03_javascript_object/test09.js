/*
    객체 이해하기 - 9
*/

function Member(id, name, email) {
    this.id = id
    this.name = name
    this.email = email
    // this.info = function(){
    //     console.log(this.id,this.name,this.email)
    // }
}

// 메모리 효율성 제고 한다. Member를 생성할때마다 function(){console.log(this.id,this.name,this.email)}을 생성하지 않아도 부모의 prototype property 한개만 찾아가면 된다. 
Member.prototype.info = function(){
        console.log(this.id,this.name,this.email)
}

var m1 = new Member("choi","최","choi@a.com")
var m2 = new Member("park","박","park@a.com")

m1.info()
m2.info()

