"use strict"

var prompt = require('prompt-sync')();
var dateFormat = require('dateformat');

var boardNo = 0
var writer
var title
var content
var regDate
var board
var boardlist = new Array();

mainMenu()

function mainMenu(){
console.log(`-------------------------------------------------
1. 전체 게시물 조회
2. 글번호 조회
3. 글 등록
4. 글 수정
5. 글 삭제
0. 종료
-------------------------------------------------`)
var menu = parseInt(prompt('메뉴 중 처리할 항목을 선택하세요 : '))
menuSwitch(menu)
}

function menuSwitch(menu){
    switch(menu){
        case 1: showBoard(); break;
        case 2: showContentDetail(); break;
        case 3: writeContent(); break;
        case 4: updateContent(); break;
        case 5: deleteContent(); break;
        case 0: process.exit(); break;
    }
}

function showBoard(){
    if(boardlist[0]!=undefined){
        console.log("조회된 게시글: "+boardlist.length)
        console.log("-------------------------------------------------") 
        console.log("글번호"+"   "+"작성자"+"   "+"제목"+"   "+"등록일")
        console.log("-------------------------------------------------") 
        for(var i=boardlist.length-1;i>=0;i--){
            console.log(boardlist[i].boardNo+"   "+boardlist[i].writer+"   "+boardlist[i].title+"   "+boardlist[i].regDate)
        }
        mainMenu()
    } else {
        console.log("조회할 글이 없습니다.")
        mainMenu()
        }
}

function showContentDetail(){
    if(boardlist[0]!=undefined){
        var no = parseInt(prompt('상세 조회할 글 번호를 입력하세요 : '))
        for(var i=0;i<boardlist.length;i++){
            if(boardlist[i].boardNo==no){
                board = boardlist[i]
                for(var key in board){
                console.log(key+":",board[key])
                } 
            break;
            } else {
                console.log("입력된 번호는 존재 하지 않습니다.")
                mainMenu()
                }
            mainMenu()
        }
    }
    console.log("글이 존재 하지 않습니다.")
    mainMenu()
}

function writeContent(){
    boardNo=boardNo+1
    writer = prompt('작성자 : ')
    title = prompt('제목 : ')
    content = prompt('글내용 : ')
    var now = new Date();
    regDate = dateFormat(now, "yyyy/mm/dd HH:MM:ss")
    board = {boardNo, writer, title, content, regDate}
    boardlist.push(board)
    console.log("글이 등록되었습니다.")
    mainMenu()
}

function deleteContent(){
    var no = parseInt(prompt('삭제할 글 번호를 입력하세요 : '))
    for(var i=0;i<boardlist.length;i++){
        if(boardlist[i].boardNo==no){
            var deleteNo = i
            boardlist.splice(i,1)
            console.log("선택하신 글이 삭제되었습니다.")
            break;
        } else {
            console.log("선택하신 글이 존재하지 않습니다.")
        }
    }
    mainMenu()
}

function updateContent(){
    var no = parseInt(prompt('수정할 글 번호를 입력하세요 : '))
    for(var i=0;i<boardlist.length;i++){
        if(boardlist[i].boardNo==no){
            board = boardlist[i]
            board.title = prompt('수정할 제목 : ')
            board.content = prompt('수정할 내용 : ')
            var now = new Date();
            board.regDate = dateFormat(now, "yyyy/mm/dd HH:MM:ss")
            console.log(board.title,board.content)
            boardlist[i] = board
            console.log("글이 수정되었습니다.")
            break;
        } else {
            console.log("선택하신 글이 존재하지 않습니다.")
        }
    }
    mainMenu()
}