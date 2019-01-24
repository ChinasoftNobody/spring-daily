//user 相关
var userService = {
    login: function () {
        var form = $('#loginForm');
        var model = $('#LoginModal');
        ajaxUtil.ajaxPostFormJson('/daily/user/login', form, function (data, textStatus, request) {
            var token = request.getResponseHeader("token");
            if(token){
                TokenUtil.setToken(token);
                model.modal('toggle');
                location.reload();
            }else {
                console.error('login failed');
            }
        })
    },
    register: function () {
        var form = $('#registerForm');
        var model = $('#RegisterModal');
        ajaxUtil.ajaxPostFormJson('/daily/user/register',form,function (data) {
            model.modal('toggle');
        })
    },
    logout: function () {
        TokenUtil.removeToken();
    }
};