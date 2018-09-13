var cal = calClosure(10,2);
console.log(cal("+")); //12
console.log(cal("-")); //8
console.log(cal("*")); //20
console.log(cal("/")); //6

function calClosure(num1, num2){
    return function (cal) {
        switch (cal) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
        }
    }
}

