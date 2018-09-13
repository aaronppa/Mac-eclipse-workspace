/*
    특정한 시간마다 반복적으로 호출된다. 
     var id = setInterval(CallBack(),milliseconds)
     clearInterval
*/

function func(){
    var date = new Date()
    var time = date.toLocaleTimeString()
    console.log(time)
}

var id = setInterval(func,1000)

setTimeout( function() { clearInterval(id) }, 11100)

