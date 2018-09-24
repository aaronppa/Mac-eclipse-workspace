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

/*
 *  options: 사용자에게 원하는 값을 설정해서 넘길 수 있도록 객체 형태를 사용
 *  
 *   type    : GET/POST 
 *   url     : /10_ajax/ajax/test03
 *   async   : true / false
 *   data    : parameter
 *   success : function(callback)
 *   error   : function(callback)
 *   dataType: xml, json,  
 */

$.ajax = function(options){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 ){
			if(xhr.status == 200){
				var result = xhr.responseText;
				// 결과처리 - 사용자마다 다르게 구현된다. 
				if(options.dataType == "json"){
					result = JSON.parse(xhr.responseText);
				}
				options.success(result);
				console.log(result)
			};
		};
	};
	var method = options.type ? options.type : "GET"; // options.type에 값이 GET이 아니면 undefined == false
	if(method!="GET" && method!="POST") method = "GET";
	
	var params = "";
	if(options.data){
		if(typeof(options.data)=="string"){
			params = options.data;
		} else {
			for(var key in options.data){
				if(params !=""){
					params += "&";
				};
				params += `${key}=${opions.data[key]}`;
			};
		};
	};
	
	var url = options.url;
	if(method=="GET" && params !=""){
		url += "?"+params;
	};
	
//	xhr.open("(요청방식)사용자마다 다름", "(요청페이지주소) 사용자마다 다름", "(true/false) 사용자마다 다름");
//	xhr.send("사용자마다 다를수 있다.(POST 방식일때 파라미터 설정)");
//	xhr.open(options.type, options.url, options.async);
	xhr.open(method, url, options.async != undefined ? options.async : true);
	
	if(method == "POST"){
		xhr.setRequestHeader("Content-Type", "application/x-www.form-urlencoded");
	}; 
	
	xhr.send(method == "POST" ? params : null);
	
};
