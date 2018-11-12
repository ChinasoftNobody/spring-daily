//user 相关
var userService = {
    login: function () {
        var form = $('#loginForm');
        var model = $('#LoginModal');
        ajaxUtil.ajaxPostForm('/daily/user/login', form, function (data) {
            model.modal('toggle');
            location.reload();
        })
    },
    register: function () {
        var form = $('#registerForm');
        var model = $('#RegisterModal');
        ajaxUtil.ajaxPostForm('/daily/user/register',form,function (data) {
            model.modal('toggle');
        })
    }
};