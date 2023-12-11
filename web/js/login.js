function login() {
    console.log("test"); // 打印"test"到控制台
    let username = document.loginForm.username.value; // 获取用户名输入框的值
    let password = document.loginForm.password.value; // 获取密码输入框的值
    let s = {
        username: `${username}`, // 设置请求体中的username字段为用户名的值
        password: `${password}`, // 设置请求体中的password字段为密码的值
        caozuo: "login" // 设置请求体中的caozuo字段为"login"
    }
    PostMsg(JSON.stringify(s));
    console.log(JSON.stringify(s)); // 打印请求体的JSON字符串到控制台

}

function register() {

    let registerName = document.registerForm.registerName.value;
    let registerPassword = document.registerForm.registerPassword.value;
    let registerEmail = document.registerForm.registerEmail.value;
    let s = {
        username: `${registerName}`,
        password: `${registerPassword}`,
        email: `${registerEmail}`,
        caozuo: "register"
    }
    PostMsg(JSON.stringify(s));
}

/*注册和登录窗口弹出*/
function popDiv() {
    let popBox = document.getElementById("popDiv");
    let popLayer = document.getElementById("popLayer");

    //控制隐藏
    popBox.style.display = "block";
    popLayer.style.display = "block";
}

function closePop() {
    let popDiv = document.getElementById("popDiv");
    popDiv.style.display = "none";
}

function PostMsg(json) {
    let httpRequest = new XMLHttpRequest(); // 创建一个XMLHttpRequest对象
    httpRequest.open('POST', '/Account', true); // 设置请求方法、URL和是否异步
    console.log(httpRequest.responseURL.toString()); // 打印请求的响应URL到控制台
    httpRequest.setRequestHeader("Content-type", "application/json"); // 设置请求头的Content-type为application/json
    httpRequest.send(json); // 发送请求
    httpRequest.onreadystatechange = function () { // 设置一个onreadystatechange事件处理函数
        if (httpRequest.readyState === 4 && httpRequest.status === 200) { // 如果请求完成且状态码为200
            let response = httpRequest.responseText; // 获取响应的文本内容
            console.log(response); // 打印响应到控制台
            let json = JSON.parse(response); // 将响应的字符串解析为JSON对象

            if (json.msg === "用户名或密码错误") { // 如果响应中的msg字段为"用户名或密码错误"
                alert(`用户名或密码错误`); // 弹出提示框显示用户名、密码和错误消息
            } else if (json.msg === "成功") {
                window.location.href = "/shishenlu.html";
            } else if (json.msg === "注册成功") {
                window.location.href = "/index.html";
            } else {
                alert(json.msg);
            }
        }
    }
}