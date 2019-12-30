$(function () {

    function reg() {
        //用户注册
        var email = $("#user_mobile_number").val();
        $.ajax({
            url: "/simpleBook/user/register",
            data: {uname: $("#user_nickname").val(), email: email, password: $("#user_password").val()},
            method: "post",

            success: function (data) {
                if (data.flag == true) {
                    location.href = "/simpleBook/activate_skip.jsp?email=" + email;
                } else {
                    alert(data.errorMsg());
                }
            }, error: function () {
                alert("服务器繁忙，稍后重试")
            }
        });

    }


    //用户名验证
    $("#user_nickname").blur(function () {
        var userName = $("#user_nickname").val();
        $.ajax({
            url: "/simpleBook/user/verificationUser",
            data: {uname: userName},
            method: "post",
            async: false,

            success: function (data) {
                if (!data.flag) {
                    alert(data.errorMsg);
                    $("#sign_up_btn").attr("disabled", true);
                }
            }, error: function () {
                alert("服务器繁忙，稍后重试")
            }
        });
    })


    //邮箱验证
    $("#user_mobile_number").blur(function () {
        $.ajax({
            url: "/simpleBook/user/verificationEmail",
            data: {email: $("#user_mobile_number").val()},
            method: "get",
            async: false,

            success: function (data) {

                if (!data.flag) {
                    alert(data.errorMsg);
                    $("#sign_up_btn").attr("disabled", true);
                }
            }, error: function () {
                alert("服务器繁忙，稍后重试")
            }
        })
    });


    $("#sign_up_btn").click(function () {
        if (!checkUser()) {
            return;
        } else {
            if (!checkEmail()) {
                return;
            } else {
                if (!checkPwd()) {
                    return;
                } else {
                    reg();
                }
            }
        }
    })

});

function checkUser() {
    var reg = /^[a-zA-Z][\w_]{3,15}$/;
    if ($("#user_nickname").val() == "") {
        alert("用户名不能为空！");
        return false;
    }

    if (!reg.test($("#user_nickname").val())) {
        alert("用户名不正确！");
        return false;
    }
    return true;
}

function checkEmail() {
    var email = /^\w+@\w+(\.[a-zA-z]{2,3}){1,2}$/;
    if ($("#user_mobile_number").val() == "") {
        alert("电子邮件不能为空！");
        return false;
    }

    if (!email.test($("#user_mobile_number").val())) {
        alert("电子邮件格式不正确！");
        return false;
    }
    return true;
}

function checkPwd() {
    var pwd = /^[a-zA-Z0-9]{6,16}$/;
    if ($("#user_password").val() == "") {
        alert("密码不能为空！");
        return false;
    }

    if (!pwd.test($("#user_password").val())) {
        alert("密码为6-16个字符，包含字母和数字！");
        return false;
    }
    return true;
}