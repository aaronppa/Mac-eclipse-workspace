// Error 처리


function isMan(juminNo){
    console.log(juminNo.length)
    if(juminNo.length !=13){
        throw new Error("주민번호는 13자리 입니다.")
    }

    return juminNo.charAt(6) == '1' || juminNo.charAt(6) == '3';
}

// true 일경우 남자, false 일 경우 여자
// try{
// var result = isMan("123456")
//     console.log(result ? "남자" : "여자")
// } catch(e){
//     console.log("실행중 에러 발생함")
//     console.log(e)
// }

try{
    var result = isMan("1234569144458")
        console.log(Number(result))
        console.log(result)
        console.log(result ? "남자" : "여자")
    } catch(e){
        console.log("실행중 에러 발생함")
        console.log(e)
    }

console.log("종료됨...")
