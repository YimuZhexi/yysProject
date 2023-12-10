function test() {
    var httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', '/YYS/test', true);
    console.log(httpRequest.responseURL.toString());
    httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    httpRequest.send("username=12333");

    httpRequest.onreadystatechange = function () {
        if (httpRequest.readyState == 4 && httpRequest.status == 200) {
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