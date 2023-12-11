//保存常量

//觉醒按钮类名
const person_tab = "person-tab-btn1";//普通状态按钮类名
const person_tab_awake = "person-tab-btn2 awake";//觉醒状态按钮类名

//TODO:以下数据需要在服务器中获取并初始化
const zhuanJi1 =
    "我的名字是 ﹁ 桃花 ﹂ ，是桃花的妖怪。\n" +
    "当我还是桃花树的时候，就经常被认成樱花。所以在化成\n" +
    "人形的时候，特地变成了和 ﹁ 樱 ﹂ 完全不一样的\n" +
    "样子。\n" +
    "我不是讨厌 ﹁ 樱 ﹂ 哦 ！ 可是她居然爱上人类\n" +
    "，她还是早点放弃比较好 ！ \n" +
    "因为， ﹁ 想要和人类结成夫妇 ﹂ 什么的，怎么可\n" +
    "能啦 ~  ~  ！ \n";
const zhuanJi2 = "樱她最后，也一定会因为这个受到伤害的。\n" +
    "……诶？如果「妖怪能和人类结成夫妇」的话？\n" +
    "我又不是什么不讲理的恶鬼，如果真的出现那种奇迹的话，我也会好好地、真心真意地祝福她。\n" +
    "但这只是「妖怪能和人类结成夫妇」的假设而已！\n" +
    "不过如果樱是真的想要和那个人在一起的话，我也不得不认真起来了。\n" +
    "因为樱她真的只知道一根筋地努力向前，那个笨蛋……！\n";
const zhuanJi3 = "我必须看好她，帮她善后。在危机关头，我要保护她才行！\n" +
    "……嗯，我变成什么样都可以，没关系的。\n" +
    "而且以后不跟樱在一起，我就再也不用担心被认错了，整个人都轻松起来了！\n" +
    "……樱，你一定要幸福啊。\n";

//初始调用
window.onload = function () {
    PersonTab(1);
    InitZhuanJi(1);
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
        zhuanJiP = zhuanJi1;
    } else if (zhuanJiId === 2) {
        zhuanJiP = zhuanJi2;
    } else {
        zhuanJiP = zhuanJi3;
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

function OnMouseIn(e) {
    e.parentNode.querySelector(".skill_info").setAttribute("class","skill_info show");
}

function OnMouseOut(e) {
    e.parentNode.querySelector(".skill_info.show").setAttribute("class","skill_info");
}