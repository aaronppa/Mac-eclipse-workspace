/*
    즉시 실행 함수
     - 함수를 정의함과 동시에 바로 실행
     - 최초 한번만 실행하는 코드를 처리하기에 적합함
     - 대다수의 라이브러리가 초기 정보를 메모리에 올릴떄 사용

     형식
     (함수정의)([parameter,...])
*/

"use strict"
;
(function(){console.log("즉시 실행 함수")})();

(function(msg){console.log("즉시 실행 함수",msg)})("테스트");
