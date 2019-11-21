$(function () {

    //用户注册
    $("#sign_up_btn").click(function () {
        $.ajax({
            url: "/simpleBook/user/register",
            data:{uname: $("#user_nickname").val(),email:$("#user_mobile_number").val(), password: $("#user_password").val()},
            method: "post",
            uccess: function (data) {
                if (data == "true") {
                    location.href = "/simpleBook/activate_skip.jsp";
                }else {
                    alert(data.errorMsg());
                }
            }, error: function () {
                alert("服务器繁忙，稍后重试")
            }
        });
    })



})