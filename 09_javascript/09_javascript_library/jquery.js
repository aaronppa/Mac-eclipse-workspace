function jQuery(val){
    // console.log("jQuery")

    var elements = [];

    if(typeof(val)=="function"){
        window.onload = val;
        return;
    }

    if(val instanceof HTMLElement){
        elements[0] = val;
    } else {
        switch(val.charAt(0)){
            case "<":
                elements[0] = document.createElement(val.substring(1,val.length-1))
                break;
            default:
                for(let el of document.querySelectorAll(val)){
                    elements.push(el);
                };
        };
    };

    // html 함수 추가
    elements.html = function(html){
        // alert(html);
        // parameter가 있으면 설정
        if(html !=undefined){
            for(var el of this){
                el.innerHTML = html;
            }
            return this;
        } 
        
        return this[0].innerHTML;

    };

    elements.text = function(text){
        if(text!=undefined){
            for(let el of this){
                el.innerText = text;
            }
            return this;
        }
        var result ="";
        for(let el of this){
            result+=el.innerText+ "\n";
        }
        return result;
    };

    elements.val = function(value){
        if(value!=undefined){
            for(let el of this){
                el.value = value;
            }
            return this;
        }

        return this[0].value;
    };

    elements.on = function(eventType,listner){
        for(let el of this){
            el.addEventListener(eventType,listner);
        }
        return this;
    };

    elements.click = function(listener){
        return this.on("click", listener);
    };

    /*
        설정: name의 타입이 객체일 경우, value가 존자하면
        추출: value가 없으면 
    */
    elements.attr = function(name, value){
        // 객체안의 키와 값을 꺼내서 설정
        if(typeof(name)=="object"){
            
            for(let el of this){
                for(let key in name){
                    el.setAttribute(key, name[key]);
                };
            };
            return this;
        };

        if(value!=undefined){
            for(let el of this){
                el.setAttribute(name, value)
            };
            return this;
        };
        return this[0].getAttribute(name)
    };

    elements.css = function(name, value){
        if(typeof(name)=="object"){
            
            for(let el of this){
                for(let key in name){
                    el.style[key] = name[key];
                };
            };
            return this;
        };

        if(value!=undefined){
            for(let el of this){
                el.style[name] = value
            };
            return this;
        };
        return this[0].style[name]
    };
    
    elements.append = function(children){
        for(let el of this){
            for(let child of children){
                el.appendChild(child.cloneNode(true));
            };
        };
        return this;
    };

    // parameter가 없으면 추출
    return elements;

}

var $ = jQuery