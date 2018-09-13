// 콜백방식으로 반복되는 부분을 function으로 만들기 

// arr 배열의 합계를 구하시오
var arr = [1,2,3,4,5];
var sum = 0
/*
for(var i=0;i<arr.length;i++){
    sum+= arr[i]
}
*/
arrFor(arr, function(val){sum+=val})
console.log("합: "+sum)


// arr 배열에서 홀수 번째 인덱스 위치 요소들의 합
sum=0
for(var i=0;i<arr.length;i++){
    if(i%2==1) sum+= arr[i]
}
console.log("홀수번째 인덱스 요소의 합: "+sum)

sum=0
arrFor(arr, function(val,i){
    if (i%2==1){
        sum+=val
    }
})
console.log("홀수번째 인덱스 요소의 합(콜백방식): "+sum)

function arrFor(arr, cb){
    for(var i=0;i<arr.length;i++){
        cb(arr[i],i)
    }
}
sum = 0
arr.forEach(function(val, i, array){
    sum+= val
})

console.log(sum)