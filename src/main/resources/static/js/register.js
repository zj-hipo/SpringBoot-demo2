function hideMsg() {
    $("#msg").hide();
}
function nickAjax() {
    $.ajax({
        url:"/checkNickName",
        type:"post",
        data:{nickname:$("#inputName4").val()},
        dataType:"json",
        success:function (data) {
            if(data==false){      //如果这里使用if(data)else的判断出不来
                alert("昵称已存在，请换个昵称")
            }
        }
    })
}