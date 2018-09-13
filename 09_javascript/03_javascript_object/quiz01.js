// MyMap 객체 정의...

function MyMap(){
    this.data = {}
    this.count = 0
}

MyMap.prototype = {
    put: function (key, value){
        this.data[key] = value;
        this.count++
    },
    size: function(){return this.count},
    get: function(key) {return this.data[key]},
    del: function (key){
        delete this.data[key]
        this.count--
    },
    clear: function (){
        this.data = {},
        this.count = 0
    }

}

var mData = new MyMap();

mData.put("id","sss")
mData.put("name","홍짜장")

console.log(mData.size()) // 2
console.log(mData.get("id")) // sss
mData.del("id")
console.log(mData.get("id")) // undefined
mData.clear()
console.log(mData.size()) // 0