/*
    특정한 시간뒤에 함수를 한번 실행시키기
    setTimeout(콜백함수, 밀리세컨드)
    clearTimeout(id) // id에 해당하는 값을 취소시킨다. 
*/

var id;
function func(){
    var date = new Date()
    var time = date.toLocaleTimeString()
    console.log(time)

    // setTimeout(function(){console.log("실행됨..")},1000)
    id=setTimeout(func,1000)

    clearTimeout(id) // 
}
func();
