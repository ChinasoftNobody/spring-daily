var ajaxUtil = {
    /**
     * post
     * @param url 地址
     * @param data 数据（json）
     * @param success 成功回调
     * @param error 失败回调
     */
    ajaxPost: function ajaxPost(url, data, success, error) {
    if (!error) {
        error = function (err) {
            console.error(err);
        }
    }
    if (!success)
    {
        success = function (data) {
            console.log(data)
        }
    }
    var option = {
        url:url,
        data: JSON.stringify(data),
        type:'post',
        dataType:'json',
        contentType:"application/json",
        cache:false,
        async:true,
        error: function (err) {
            console.error(data.error);
            error(err);
        },
        success:function (data) {
            if (!data.success){
                console.error(data.error);
                error(data.error);
            }else {
                success(data.result);
            }
        }
    };
    $.post(option);
},

/**
 * ajax post form
 * @param url url
 * @param selector 表单选择器
 * @param success 成功回调
 * @param error 失败回调
 */
ajaxPostForm:function ajaxPostForm(url,selector,success,error) {
    if (!success){
        success = function (data) {
            console.log(data);
        };
    }
    if (!error){
        error = function (err) {
            console.log(err);
        };
    }
    var option = {
        url:url,
        data: JSON.stringify(paramUtil.urlParamsToJson(selector.serialize())),
        type:'post',
        dataType:'json',
        cache:false,
        async:true,
        contentType:"application/json",
        error: function (err) {
            console.error(data.error);
            error(err);
        },
        success: function (data) {
            if (!data.success){
                console.error(data.error);
                error(data.error);
            }else {
                success(data.result);
            }
        }
    };
    console.log(1);
    $.post(option);
}
};

var paramUtil = {
    /**
     * 查询参数转化为对象格式
     * @param urlParams
     * @returns {{}}
     */
    urlParamsToJson: function (urlParams) {
        var result = {};
        if (!urlParams)
        {
            return result;
        }
        var kvs = urlParams.split('&');
        for (var i = 0; i < kvs.length; i++){
            var kv = kvs[i].split('=');
            if (kv.length === 2){
                result[kv[0]] = kv[1];
            }
        }
        console.log(result);
        return result;
    }
};
