$(function () {

    function check(){

            $.ajax({
                url: "/simpleBook/user/loginOn",
                data: {unameAndEmail: $("#session_email_or_mobile_number").val(), password: $("#session_password").val()},
                method: "post",
                success: function (data) {
                    if (data.flag == false) {
                        alert("用户名或密码错误");
                    } else {
                        location.href = "/simpleBook/index.jsp";
                    }
                }, error: function () {
                    $(".tip").text("服务器繁忙");
                }
            });

    }

    $("#sign-in-form-submit-btn").submit(function(){
        // var flag = true;
        // if (!checkUser()) flag = false;
        // if (!checkPwd()) flag = false;
        // return flag;
    })
    $("#sign-in-form-submit-btn").click(function () {

        if (!checkUser()){
            return;
        } else {
            if (!checkPwd()){
                return;
            }else {
                check();
            }
        }
    })


});

function checkUser(){
    if ($("#session_email_or_mobile_number").val()=="") {
        alert("用户名不能为空！");
        return false;
    }
    return true;
}

function checkPwd(){
    var pwd=/^[a-zA-Z0-9]{6,16}$/;
    if ($("#session_password").val()=="") {
        alert("密码不能为空！");
        return false;
    }

    if (!pwd.test($("#session_password").val())) {
        alert("密码为6-16个字符，包含字母和数字！");
        return false;
    }
    return true;
}