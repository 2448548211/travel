//注册
const REGISTER_URL = "http://localhost:8080/travel/regist";

$(function () {
    //注册点击事件
    $("#registerBtn").click(function () {
        if ($("#username").val() !== "" || $("#password").val() !== "") {
            let username = $("#username").val();
            let password = $("#password").val();
            let email = $("#email").val();
            let name = $("#name").val();
            let telephone = $("#telephone").val();
            let sex = $("#sex").val();
            let birthday = $("#birthday").val();
            let check = $("#check").val();
            let params = {
                username: username,
                password: password,
                email: email,
                name: name,
                telephone: telephone,
                sex: sex,
                birthday: birthday,
                check: check
            };
            $.post(REGISTER_URL, params, function (result) {
                if (result.code === 200) {
                    location.href = "index.html?";
                } else {
                    alert(result.msg);
                    $("#error").text(result.msg).show();
                }
            })
        } else {
            alert("用户名和密码不可为空 ")
        }
    })
})