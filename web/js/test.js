function test() {
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', '/test', true);
    console.log(httpRequest.responseURL.toString());
    httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    httpRequest.send("username=12333");

    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState === 4 && httpRequest.status === 200) {
            var json = httpRequest.responseText;

            //读取图片
            /*// 将 base64 编码的图片数据转为二进制数据
            const binaryImageData = atob(json);

            // 创建一个 ArrayBuffer 对象，将二进制数据存储进去
            const buffer = new ArrayBuffer(binaryImageData.length);
            const view = new Uint8Array(buffer);
            for (let i = 0; i < binaryImageData.length; i++) {
                view[i] = binaryImageData.charCodeAt(i);
            }

            // 将 ArrayBuffer 对象转为 Blob 对象
            const blob = new Blob([buffer], {type: "image/png"});

            // 创建一个 URL 对象，用于表示图片的地址
            const imageUrl = URL.createObjectURL(blob);

            // 创建一个 Image 对象，用于显示图片
            const imageElement = new Image();
            imageElement.onload = function () {
                // 图片加载完成后，将其添加到页面上
                document.body.appendChild(imageElement);
            };
            imageElement.src = imageUrl;*/

            //简单读取数据
            /* var e = document.createElement("output");
             e.textContent ="<h2>"+ json+"</h2>";
             var p = document.getElementById("out");
             p.appendChild(e);
             console.log("js" + json);*/
        }
    }
}

function getList() {
    let httpRequest = new XMLHttpRequest(); // 创建一个XMLHttpRequest对象
    httpRequest.open('POST', '/ShiShen', true); // 设置请求方法、URL和是否异步
    console.log(httpRequest.responseURL.toString()); // 打印请求的响应URL到控制台
    httpRequest.setRequestHeader("Content-type", "application/json"); // 设置请求头的Content-type为application/json
    let json = JSON.stringify({ // 将JSON对象转换为字符串
        caozuo: "getList"
    });
    httpRequest.send(json); // 发送请求
    httpRequest.onreadystatechange = function () { // 设置一个onreadystatechange事件处理函数
        if (httpRequest.readyState === 4 && httpRequest.status === 200) { // 如果请求完成且状态码为200
            let response = httpRequest.responseText; // 获取响应的文本内容
            console.log(response); // 打印响应到控制台
        }
    }
}