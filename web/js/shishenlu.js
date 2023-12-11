window.onload = function () {
    load(null);
}

function load(getName) {
    let httpRequest = new XMLHttpRequest(); // 创建一个XMLHttpRequest对象
    httpRequest.open('POST', '/ShiShen', true); // 设置请求方法、URL和是否异步
    console.log(httpRequest.responseURL.toString()); // 打印请求的响应URL到控制台
    httpRequest.setRequestHeader("Content-type", "application/json"); // 设置请求头的Content-type为application/json
    let get = getName;
    let json = JSON.stringify({ // 将JSON对象转换为字符串
        caozuo: "getList",
        shishenname: get
    });
    httpRequest.send(json); // 发送请求
    httpRequest.onreadystatechange = function () { // 设置一个onreadystatechange事件处理函数
        if (httpRequest.readyState === 4 && httpRequest.status === 200) { // 如果请求完成且状态码为200
            let response = httpRequest.responseText; // 获取响应的文本内容
            let json = JSON.parse(response);
            console.log("json" + json);
            for (let i = 0; i < Object.keys(json.shishen).length; i++) {
                //初始化对象
                Initshishenitem(json.shishen[i].shiShenName, i);
                //设置图片
                document.getElementById("image" + i).src = json.shishen[i].jueXingQianIcon;
            }
        }
    }
}

function Initshishenitem(name, i) {
    let parent = document.getElementById("shishen_wrap");
    let p = document.createElement("div");
    p.setAttribute("class", "shishen_item");

    let c1 = document.createElement("a");
    c1.setAttribute("href", "式神详情页面");

    let c2 = document.createElement("span");
    c2.setAttribute("class", "pic_wrap");
    let c2_1 = document.createElement("img");
    c2_1.setAttribute("class", "shishenicon");
    c2_1.setAttribute("id", "image" + i);
    c2.appendChild(c2_1);
    let c2_2 = document.createElement("span");
    c2_2.setAttribute("class", "cover");
    c2.appendChild(c2_2);
    c1.appendChild(c2);

    let c3 = document.createElement("span");
    c3.setAttribute("class", "name");
    c3.innerText = name;
    c1.appendChild(c3);

    let c4 = document.createElement("span");
    c4.setAttribute("class", "hover");
    let c4_1 = document.createElement("em");
    c4.appendChild(c4_1);
    c1.appendChild(c4);

    p.appendChild(c1);

    parent.appendChild(p);
}

function searchShiShen() {
    let s = document.getElementById("searchInput").value;
    document.getElementById("shishen_wrap").innerText = "";
    console.log(s);
    load(s.toString());
}