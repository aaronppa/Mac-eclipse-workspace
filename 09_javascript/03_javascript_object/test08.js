/*
    객체 이해하기 - 8
*/

function Member(id, name, email) {
    this.id = id
    this.name = name
    this.email = email
    this.info = function(){
        console.log(this.id,this.name,this.email)
    }
}

var m1 = new Member("choi","최","choi@a.com")
var m2 = new Member("park","박","park@a.com")

m1.info()
m2.info()

