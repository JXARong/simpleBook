$(function () {

    $("#sign-in-form-submit-btn").click(function () {

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

    })

})