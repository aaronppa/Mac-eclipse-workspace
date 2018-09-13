"use strict"
const players = ["황의조","손흥민","남태희","황인범","기성용","이승우","홍철","김영권","이용","김민재","조현우"]

var id;
var count = 10
/*
function func(){
    console.log(no--)

    id = setTimeout(func,1000)
    if(count==0){

        console.log(players[parseInt(Math.random()*players.length)])
        clearTimeout(id)
    }
}
func();
*/

var id= setInterval(() => {
    if(count==0){
        console.log(players[parseInt(Math.random()*players.length)])
        clearInterval(id);
        return;
    }
    console.log(count--)
})
