const nameInput = document.querySelector("input[placeholder='请输入你的名字']");
const idInput = document.querySelector("input[placeholder='请输入你的学号']");
const textarea = document.querySelector("textarea");
const submit = document.querySelector(".submit");
const score = document.querySelector(".score");
const select = document.querySelector("select");

let isshow=false;
score.addEventListener("click",()=>{
    const course=["高等数学上","程序设计基础","程序设计实践","计算机导论"];
    const data=[86,90,92,70];
    if(!isshow){
    score.innerText = "";
    for(let i=0;i<course.length;i++){
        score.innerHTML += `${course[i]}:${data[i]}分&nbsp;&nbsp;`;
        }
        isshow=true;
    }
    else{
        score.innerHTML = "查看2025-2026-1期末成绩";
        isshow=false;
    }
})
submit.addEventListener("click", ()=>{
    const userName = nameInput.value.trim(); 
    const userId = idInput.value.trim();
    const desc = textarea.value.trim();
    const city =select.value;
    if(userName === ""){
        alert("提示：姓名不允许为空！");
        return;
    }
    if(userId.length !== 8|| isNaN(Number(userId))){
        alert("提示:学号必须是8位数字!");
        return;
    }
    if(desc === ""){
        alert("提示：请填写自我介绍！");
        return;
    }
    
    if(city==="选择所在城市"){
        alert("提示:请选择所在城市!");
        return;
    }
    alert(`提交完成！
姓名：${userName}
学号：${userId}
所在城市：${city}
自我介绍：${desc}
`);
})