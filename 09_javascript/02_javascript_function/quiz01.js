/*
    1. arr이 없을 경우 0을 반환
    2. start 없을 경우 0을 할당해서 계산
    3. end 없을 경우 배열의 길이를 할당해서 계산
    4. 배열의 중간에 숫자가 아닌 값이 있을 경우 빼고 계산
*/
var result=0
function sum(arr,start,end){
    if(!arr) return 0;
    if(!start) start = 0;
    if(!end) end = arr.length;
    let result = 0;
    for(var i=start;i<end;i++){
        console.log(typeof(arr[i]))
        if(typeof(arr[i]) != 'number') continue;
        result+=arr[i];
    }
    return result
}

let arr = [1, 2, '홍', 4, 5];
console.log( sum(arr, 0, arr.length) );  // 12
console.log( sum(arr, 0, 4) );           // 7
console.log( sum(arr, 0) );              // 12
console.log( sum(arr, 2) );              // 9
console.log( sum(arr) );                 // 12
console.log( sum() );                    // 0