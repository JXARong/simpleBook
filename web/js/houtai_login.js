
$(function () {

    $("#login_btn").click(function () {

        verifyUser();

        // 判断验证码是否正确
        function verifyCode() {
            $.ajax({
                method: "post",
                url: "/simpleBook/admin/verifyCode",
                data: {code: $("#code").val()},
                success: function (data) {
                    if (data == "false") {
                        $("#code").val("");
                        $("#code").focus();
                        $(".tip").text("验证码错误");
                        $(".codeImage").attr("src", "/simpleBook/admin/generateCode?" + Math.random());
                    } else {
                        login();
                    }
                }
            });
        }

        // 验证用户名与密码格式
        function verifyUser() {
            var username = $("#username").val();
            var password = $("#password").val();
            var tip = "";
            if (username.length > 16 || username == null || username == "") {
                $(".tip").text("用户名格式输入错误");
                $("#username").focus();
                $(".codeImage").attr("src", "/simpleBook/admin/generateCode?" + Math.random());
                return false;
            } else if (password == null || password.length > 16 || password == "") {
                $(".tip").text("请输入正确的密码");
                $("#password").focus();
                $(".codeImage").attr("src", "/simpleBook/admin/generateCode?" + Math.random());
                return false;
            }
            // 调用判断验证码函数
            verifyCode();
        }

        // 用户登录
        function login() {
            $.ajax({
                url: "/simpleBook/admin/login",
                data: {username: $("#username").val(), password: $("#password").val()},
                method: "post",
                success: function (data) {
                    if (data == "false") {
                        $(".tip").text("用户名或密码错误");
                    } else {
                        location.href = "/simpleBook/houtai/index.jsp";
                    }
                }, error: function () {
                    $(".tip").text("服务器繁忙");
                }
            });
        }
    });

    // 点击“看不清‘’连接切换验证码
    $(".switchCode").click(function () {
        $(".codeImage").attr("src", "/simpleBook/admin/generateCode?" + Math.random());
    });

    // 点击验证码切换新的验证码
    $(".codeImage").click(function () {
        $(".codeImage").attr("src", "/simpleBook/admin/generateCode?" + Math.random());
    });

    // 点击忘记密码
    $(".forgetPwd").click(function () {
        $(".bidTitle").text("找回密码");
        $("#forget").show();
        $("#login").hide();
    });

    // 忘记密码：验证用户名和邮箱
    function verifyNameAndEmail() {
        var email = $("#forget_email");
        var username = $("#forget_username");
        var emailReg = new RegExp("^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$");
        if (username == null || username.val() == "") {
            $(".tip").text("请输入用户名");
            username.focus();
            return false;
        }
        if (!emailReg.test(email.val())) {
            $(".tip").text("邮箱格式不正确");
            email.focus();
            return false;
        }
        return true;
    }

    // 点击发送邮箱
    $(".sendEmail").click(function () {
        if (!verifyNameAndEmail()) {
            return;
        }
        $.ajax({
            method: "post",
            url: "/simpleBook/admin/sendCodeToEmail",
            data: {username: $("#forget_username").val(), email: $("#forget_email").val()},
            success: function (data, status) {
                $(".tip").text(data);
            },
            error: function () {
                $(".tip").text("服务器繁忙,发送失败");
            }, beforeSend: function () {
                $(".tip").text("正在发送验证码，请稍等")
            }
        });
    });

    // 验证邮箱验证码
    $("#sub_emailCode").click(function () {
        if (!verifyNameAndEmail()) {
            return;
        }
        $.ajax({
            method: "post",
            url: "/simpleBook/admin/verifyEmailCode",
            data: {emailCode: $("#forget_code").val()},
            success: function (data) {
                if (data != "false") {
                    $("#updateAdmin").show();
                    $("#forget").hide();
                    $("#login").hide();
                    $(".tip").text("");
                    $("#update_id").val(data);
                } else {
                    $(".tip").text("验证码错误");
                }
            }, error: function () {
                $(".tip").text("服务器繁忙,请稍后重试");
            }
        });
    });

    // 修改密码
    $("#sub_updatePwd").click(function () {
        var pwd = $("#update_pwd");
        var pwdTwo = $("#update_pwdTwo");
        if (pwd.val().length > 16 || pwd.val().length == 0 || pwd.val().length < 6) {
            $(".tip").text("密码格式不正确");
            pwd.css({"border": "1px red solid"});
            return;
        } else {
            pwd.css({"border": "0px"});
        }
        if (pwdTwo.val().length > 16 || pwdTwo.val().length == 0 || pwdTwo.val().length < 6) {
            $(".tip").text("密码格式不正确");
            pwdTwo.css({"border": "1px red solid"});
            return;
        }else if(pwdTwo.val()!=pwd.val()){
            $(".tip").text("两次密码不同");
            pwdTwo.css({"border": "1px red solid"});
            return;
        }else {
            pwdTwo.css("border","0px");
        }
        // 清空提示语
        $(".tip").text("");
        // 发送修改密码请求
        $.ajax({
            method:"post",
            url:"/simpleBook/admin/updatePwd",
            data:{id:$("#update_id").val(),pwd:$("#update_pwdTwo").val()},
            success:function (data) {
                if(data=="true")
                    $(".tip").html("修改成功,<a href='/simpleBook/index.html'>登录</a>");
                else
                    $(".tip").text("修改失败");
            },error:function () {
                $(".tip").text("服务器繁忙，修改失败");
            }
        });
    });
});