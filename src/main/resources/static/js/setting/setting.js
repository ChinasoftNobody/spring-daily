var settingService = {

    /**
     * 下哈寻模块列表
     */
    queryModules: function () {
        //TODO 这里使用header头信息进行管理用户登陆信息 不使用session
        ajaxUtil.ajaxGet("/daily/module/modules",function(result){
            console.log(result.length);
        })
    }
};

//初始化查询
// === $(document).ready(function) === $().ready(function)
$(function () {
    settingService.queryModules();

});