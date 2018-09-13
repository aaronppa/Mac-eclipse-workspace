function foo(){
    console.log(1);
}

foo();

var foo = function(){
    console.log(2);
}

foo();

function foo(){
    console.log(3);
}

/*
    function foo(){
        console.log(1);
    }

    var foo;

    function foo(){
        console.log(3);
    }

    foo()

    var foo = function(){
        console.log(2);
    }

    foo()

    function foo(){
        console.log(3);
    }
*/