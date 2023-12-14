//保存常量
//觉醒按钮类名
const person_tab = "person-tab-btn1";//普通状态按钮类名
const person_tab_awake = "person-tab-btn2 awake";//觉醒状态按钮类名

//TODO:以下数据需要在服务器中获取并初始化
let shiShen = {
    "shiShenName": "",
    "jueXingQianIcon": "",
    "jueXingHouIcon": ""
}
let shiShenSkill = {
    "skill1": "",
    "skillIcon1": "",
    "skillDescription1": "",
    "skill2": "",
    "skillIcon2": "",
    "skillDescription2": "",
    "skill3": "",
    "skillIcon3": "",
    "skillDescription3": ""
}
let shiShenZhuanJi = {
    "zhuanJi1": "",
    "zhuanJi2": "",
    "zhuanJi3": ""
}
let jueXingQian = {
    "gongJi": 0,
    "shengMing": 0,
    "fangYu": 0,
    "suDu": 0,
    "baoJi": 0.0,
    "baoJiShangHai": 0.0,
    "xiaoGuoMingZhong": 0.0,
    "xiaoGuoDiKang": 0.0,
    "image": ""
}
let jueXingHou = {
    "gongJi": 0,
    "shengMing": 0,
    "fangYu": 0,
    "suDu": 0,
    "baoJi": 0.0,
    "baoJiShangHai": 0.0,
    "xiaoGuoMingZhong": 0.0,
    "xiaoGuoDiKang": 0.0,
    "image": ""
}

console.log(GetRequest("shiShenName"));
//初始调用
window.onload = function () {
    let n = GetRequest("shiShenName");
    let json = {
        "shiShenName": n
    }
    SendMsg("get", json);
}

function GetRequest(name) {
    // 将字符串转换为 URLSearchParams 对象
    const searchParams = new URLSearchParams(window.location.search);
    // 获取指定参数的值
    const value = searchParams.get(name);
    // 如果参数不存在，则返回空字符串
    if (value === null) {
        return "";
    }
    // 返回参数的值
    return value;
}

/**
 * 初始觉醒点击按钮事件
 */
function PersonTab(id) {
    let bs1 = person_tab;
    let bs2 = person_tab_awake;
    if (id === 1) {
        bs1 += " cur";
        document.getElementById("image-con-1").style.display = "";
        document.getElementById("image-con-2").style.display = "none";
    } else {
        bs2 += " cur";
        document.getElementById("image-con-1").style.display = "none";
        document.getElementById("image-con-2").style.display = "";
    }
    document.getElementById("person-tab-btn1").setAttribute("class", bs1);
    document.getElementById("person-tab-btn2").setAttribute("class", bs2);

}

function InitZhuanJi(zhuanJiId) {
    let node = document.getElementById("zhuanJi_txt");
    node.innerText = null;
    let zhuanJiP;
    let btn = document.getElementsByClassName("zj-btn");
    for (let i = 0; i < btn.length; i++) btn[i].setAttribute("class", "zj-btn");
    btn[zhuanJiId - 1].setAttribute("class", "zj-btn cur");
    if (zhuanJiId === 1) {
        zhuanJiP = shiShenZhuanJi.zhuanJi1;
    } else if (zhuanJiId === 2) {
        zhuanJiP = shiShenZhuanJi.zhuanJi2;
    } else {
        zhuanJiP = shiShenZhuanJi.zhuanJi3;
    }
    let zhuanJi = zhuanJiP.split("\n");
    for (let i = 0; i < zhuanJi.length; i++) {
        let spa = document.createElement("p");
        spa.setAttribute("class", "chinese show");
        let txt = document.createElement("span");
        txt.innerText = zhuanJi[i];
        spa.appendChild(txt);
        node.appendChild(spa);
    }
}

function InitShiShen() {
    let r = document.getElementById("person_part");
    document.getElementById("zhuan_ji_name").innerText = shiShen.shiShenName;
    document.getElementById("shishenname").innerText = shiShen.shiShenName;
    document.getElementById("init_image").setAttribute("src", jueXingQian.image);
    document.getElementById("weak_up_image").setAttribute("src", jueXingHou.image);
    document.getElementById("jue_xing_qian_icon").setAttribute("src", shiShen.jueXingQianIcon);
    document.getElementById("jue_xing_hou_icon").setAttribute("src", shiShen.jueXingHouIcon);
}

function OnMouseIn(e) {
    e.parentNode.querySelector(".skill_info").setAttribute("class", "skill_info show");
}

function OnMouseOut(e) {
    e.parentNode.querySelector(".skill_info.show").setAttribute("class", "skill_info");
}

function SendMsg(caozuo, json) {
    const httpRequest = new XMLHttpRequest();
    httpRequest.open('POST', '/ShiShenAttribute', true);
    console.log(httpRequest.responseURL.toString());
    httpRequest.setRequestHeader("Content-type", "application/json");
    let msg = {
        "caozuo": caozuo,
        "data": `${JSON.stringify(json)}`
    };
    httpRequest.send(JSON.stringify(msg));
    httpRequest.onreadystatechange = function () { // 设置一个onreadystatechange事件处理函数
        if (httpRequest.readyState === 4 && httpRequest.status === 200) { // 如果请求完成且状态码为200
            let response = httpRequest.responseText; // 获取响应的文本内容
            let json = JSON.parse(response);
            if (json.msg === "删除成功") window.location.href = "/shishenlu.html";
            shiShenZhuanJi = json.shiShenZhuanJi;
            shiShenSkill = json.shiShenSkill;
            shiShen = json.shiShen;
            jueXingQian = json.shiShenAttribute[0];
            jueXingHou = json.shiShenAttribute[1];
            console.log(JSON.stringify(jueXingQian));
            console.log(JSON.stringify(shiShenZhuanJi));
            PersonTab(1);
            InitZhuanJi(1);
            InitShiShen();
            InitNormalAttribute();
            InitSkill();
        }
    }
}

function InitNormalAttribute() {
    // 获取元素
    const e = document.getElementById("normal_attribute");
    // 创建多个span元素并设置innerText，然后将它们添加到div元素中
    ['gongJi', 'shengMing', 'fangYu', 'suDu', 'baoJi', 'baoJiShangHai', 'xiaoGuoMingZhong', 'xiaoGuoDiKang'].forEach(jueXingQianKey => {
        // 创建div元素
        const temp = document.createElement("div");
        temp.setAttribute("class", "init_state");
        // 创建span元素
        const d = document.createElement("span");
        d.setAttribute("class", "level ");
        // 添加span元素到div元素中
        temp.appendChild(d);
        const da = document.createElement("span");
        da.setAttribute("class", "value");
        let s = "(";
        if (jueXingQianKey === 'baoJi' || jueXingQianKey === 'baoJiShangHai' || jueXingQianKey === 'xiaoGuoMingZhong' || jueXingQianKey === 'xiaoGuoDiKang')
            s += jueXingQian[jueXingQianKey] * 100 + "%)";
        else s += jueXingQian[jueXingQianKey] + ")";
        da.innerText = s;
        temp.appendChild(da);
        // 将div元素添加到获取的元素中
        e.appendChild(temp);
    });
    // 获取元素
    const e1 = document.getElementById("wake_attribute");
    // 创建多个span元素并设置innerText，然后将它们添加到div元素中
    ['gongJi', 'shengMing', 'fangYu', 'suDu', 'baoJi', 'baoJiShangHai', 'xiaoGuoMingZhong', 'xiaoGuoDiKang'].forEach(jueXingQianKey => {
        // 创建div元素
        const temp = document.createElement("div");
        temp.setAttribute("class", "wakeup_state");
        // 创建span元素
        const d = document.createElement("span");
        d.setAttribute("class", "level ");
        // 添加span元素到div元素中
        temp.appendChild(d);
        const da = document.createElement("span");
        da.setAttribute("class", "value");
        let s = "(";
        if (jueXingQianKey === 'baoJi' || jueXingQianKey === 'baoJiShangHai' || jueXingQianKey === 'xiaoGuoMingZhong' || jueXingQianKey === 'xiaoGuoDiKang')
            s += jueXingHou[jueXingQianKey] * 100 + "%)";
        else s += jueXingHou[jueXingQianKey] + ")";
        da.innerText = s;
        temp.appendChild(da);
        // 将div元素添加到获取的元素中
        e1.appendChild(temp);
    });
}

function InitSkill() {
    document.getElementById("skill1_icon").setAttribute("src", shiShenSkill.skillIcon1);
    document.getElementById("skill1_name").innerText = shiShenSkill.skill1;
    const skill1 = document.getElementById("skill1_info");
    let h = document.createElement("h3");
    h.innerText = shiShenSkill.skill1;
    skill1.appendChild(h);
    document.getElementById("skill2_icon").setAttribute("src", shiShenSkill.skillIcon2);
    document.getElementById("skill2_name").innerText = shiShenSkill.skill2;
    const skill2 = document.getElementById("skill2_info");
    h = document.createElement("h3");
    h.innerText = shiShenSkill.skill2;
    skill2.appendChild(h);
    document.getElementById("skill3_icon").setAttribute("src", shiShenSkill.skillIcon3);
    document.getElementById("skill3_name").innerText = shiShenSkill.skill3;
    const skill3 = document.getElementById("skill3_info");
    h = document.createElement("h3");
    h.innerText = shiShenSkill.skill3;
    skill3.appendChild(h);

    let des = shiShenSkill.skillDescription1.split("\n");
    for (let i = 0; i < des.length; i++) {
        let s = document.createElement("p");
        s.innerText = des[i];
        skill1.appendChild(s);
    }
    des = shiShenSkill.skillDescription2.split("\n");
    for (let i = 0; i < des.length; i++) {
        let s = document.createElement("p");
        s.innerText = des[i];
        skill2.appendChild(s);
    }
    des = shiShenSkill.skillDescription3.split("\n");
    for (let i = 0; i < des.length; i++) {
        let s = document.createElement("p");
        s.innerText = des[i];
        skill3.appendChild(s);
    }
}

/*js控制增加和更改窗口弹出*/
function popDiv(opt) {
    GetXiuGaiData(opt);
    let popBox = document.getElementById("popDiv");
    let popLayer = document.getElementById("popLayer");

    //控制隐藏
    popBox.style.display = "block";
    popLayer.style.display = "block";
}

function GetXiuGaiData(opt) {
    document.getElementById("xiugai_shishenName").value = opt === 1 ? shiShen.shiShenName : "";
    document.getElementById("xiugai_zhuanJi1").value = opt === 1 ? shiShenZhuanJi.zhuanJi1 : "";
    document.getElementById("xiugai_zhuanJi2").value = opt === 1 ? shiShenZhuanJi.zhuanJi2 : "";
    document.getElementById("xiugai_zhuanJi3").value = opt === 1 ? shiShenZhuanJi.zhuanJi3 : "";
    document.getElementById("xiugai_zhuangTai").value = "觉醒前";
    document.getElementById("xiugai_gongJi").value = opt === 1 ? jueXingQian.gongJi : "";
    document.getElementById("xiugai_shengMing").value = opt === 1 ? jueXingQian.shengMing : "";
    document.getElementById("xiugai_fangYu").value = opt === 1 ? jueXingQian.fangYu : "";
    document.getElementById("xiugai_suDu").value = opt === 1 ? jueXingQian.suDu : "";
    document.getElementById("xiugai_baoJi").value = opt === 1 ? jueXingQian.baoJi : "";
    document.getElementById("xiugai_baoJiShangHai").value = opt === 1 ? jueXingQian.baoJiShangHai : "";
    document.getElementById("xiugai_xiaoGuoMingZhong").value = opt === 1 ? jueXingQian.xiaoGuoMingZhong : "";
    document.getElementById("xiugai_xiaoGuoDiKang").value = opt === 1 ? jueXingQian.xiaoGuoDiKang : "";
    document.getElementById("xiugai_juexinghou_zhuangTai").value = "觉醒后";
    document.getElementById("xiugai_juexinghou_gongJi").value = opt === 1 ? jueXingHou.gongJi : "";
    document.getElementById("xiugai_juexinghou_shengMing").value = opt === 1 ? jueXingHou.shengMing : "";
    document.getElementById("xiugai_juexinghou_fangYu").value = opt === 1 ? jueXingHou.fangYu : "";
    document.getElementById("xiugai_juexinghou_suDu").value = opt === 1 ? jueXingHou.suDu : "";
    document.getElementById("xiugai_juexinghou_baoJi").value = opt === 1 ? jueXingHou.baoJi : "";
    document.getElementById("xiugai_juexinghou_baoJiShangHai").value = opt === 1 ? jueXingHou.baoJiShangHai : "";
    document.getElementById("xiugai_juexinghou_xiaoGuoMingZhong").value = opt === 1 ? jueXingHou.xiaoGuoMingZhong : "";
    document.getElementById("xiugai_juexinghou_xiaoGuoDiKang").value = opt === 1 ? jueXingHou.xiaoGuoDiKang : "";
}

function closePop() {
    let popDiv = document.getElementById("popDiv");
    popDiv.style.display = "none";
}

function getData() {
    let newShiShen = shiShen;
    let newZhuanJi = shiShenZhuanJi;
    let newJueXingQian = jueXingQian;
    let newJueXingHou = jueXingHou;

    newShiShen.shiShenName = document.getElementById("xiugai_shishenName").value;
    newZhuanJi.zhuanJi1 = document.getElementById("xiugai_zhuanJi1").value;
    newZhuanJi.zhuanJi2 = document.getElementById("xiugai_zhuanJi2").value;
    newZhuanJi.zhuanJi3 = document.getElementById("xiugai_zhuanJi3").value;
    newJueXingQian.gongJi = document.getElementById("xiugai_gongJi").value;
    newJueXingQian.shengMing = document.getElementById("xiugai_shengMing").value;
    newJueXingQian.fangYu = document.getElementById("xiugai_fangYu").value;
    newJueXingQian.suDu = document.getElementById("xiugai_suDu").value;
    newJueXingQian.baoJi = document.getElementById("xiugai_baoJi").value;
    newJueXingQian.baoJiShangHai = document.getElementById("xiugai_baoJiShangHai").value;
    newJueXingQian.xiaoGuoMingZhong = document.getElementById("xiugai_xiaoGuoMingZhong").value;
    newJueXingQian.xiaoGuoDiKang = document.getElementById("xiugai_xiaoGuoDiKang").value;
    newJueXingHou.gongJi = document.getElementById("xiugai_juexinghou_gongJi").value;
    newJueXingHou.shengMing = document.getElementById("xiugai_juexinghou_shengMing").value;
    newJueXingHou.fangYu = document.getElementById("xiugai_juexinghou_fangYu").value;
    newJueXingHou.suDu = document.getElementById("xiugai_juexinghou_suDu").value;
    newJueXingHou.baoJi = document.getElementById("xiugai_juexinghou_baoJi").value;
    newJueXingHou.baoJiShangHai = document.getElementById("xiugai_juexinghou_baoJiShangHai").value;
    newJueXingHou.xiaoGuoMingZhong = document.getElementById("xiugai_juexinghou_xiaoGuoMingZhong").value;
    newJueXingHou.xiaoGuoDiKang = document.getElementById("xiugai_juexinghou_xiaoGuoDiKang").value;
    return {
        "newShiShen": newShiShen,
        "newZhuanJi": newZhuanJi,
        "newJueXingQian": newJueXingQian,
        "newJueXingHou": newJueXingHou
    }
}

function deleteShiShen() {
    let name = GetRequest("shiShenName");
    let r = confirm(`您正在删除${name},删除后将无法恢复，请确认是否操作`);
    if (r) {
        let json = {
            "shiShenName": name
        }
        SendMsg("delete", json);
    }
}

function getCookie(cookieName) {
    const name = cookieName + "=";
    const decodedCookie = decodeURIComponent(document.cookie);
    const cookieArray = decodedCookie.split(';');
    for (let i = 0; i < cookieArray.length; i++) {
        let cookie = cookieArray[i];
        while (cookie.charAt(0) === ' ') {
            cookie = cookie.substring(1);
        }
        if (cookie.indexOf(name) === 0) {
            return cookie.substring(name.length, cookie.length);
        }
    }
    return "";
}

function SubmitData(caozuo) {
    if (caozuo === "update") {
        let json = getData();
        SendMsg("update", json);
    }
}