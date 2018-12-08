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
        if (!success) {
            success = function (data) {
                console.log(data)
            }
        }
        var option = this.initOption(url, JSON.stringify(data), success, error, 'post');
        $.post(option);
    },
    ajaxGet: function ajaxGet(url, success, error) {
        if (!error) {
            error = function (err) {
                console.error(err);
            }
        }
        if (!success) {
            success = function (data) {
                console.log(data)
            }
        }
        var option = this.initOption(url, '', success, error, 'get');
        $.get(option);
    },

    /**
     * ajax post form
     * @param url url
     * @param selector 表单选择器
     * @param success 成功回调
     * @param error 失败回调
     */
    ajaxPostForm: function ajaxPostForm(url, selector, success, error) {
        if (!success) {
            success = function (data) {
                console.log(data);
            };
        }
        if (!error) {
            error = function (err) {
                console.log(err);
            };
        }
        var option = this.initOption(url, JSON.stringify(paramUtil.urlParamsToJson(selector.serialize())), success, error, 'post');
        $.post(option);
    },
    initOption: function (url, data, success, error, type) {
        return {
            url: url,
            data: data,
            type: type,
            dataType: 'json',
            cache: false,
            async: true,
            contentType: "application/json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("token", TokenUtil.getToken());
            },
            error: function (err) {
                console.error(data.error);
                error(err);
            },
            success: function (data, textStatus, request) {
                if (!data.success) {
                    console.error(data.error);
                    error(data.error);
                } else {
                    success(data.result, textStatus, request);
                }
            }
        }
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
        if (!urlParams) {
            return result;
        }
        var kvs = urlParams.split('&');
        for (var i = 0; i < kvs.length; i++) {
            var kv = kvs[i].split('=');
            if (kv.length === 2) {
                result[kv[0]] = kv[1];
            }
        }
        console.log(result);
        return result;
    }
};

var TokenUtil = {
    tokenName:'token',
    getToken: function () {
        return CookieUtil.get(this.tokenName);
    },
    setToken: function (token) {
        CookieUtil.set(this.tokenName, token);
    },
    removeToken: function () {
        CookieUtil.remove(this.tokenName);
    }
};

var CookieUtil = {
    get:function(name){
        return $.cookie(name);
    },
    set:function (name, value, expires) {

        if (!expires){
            expires = new Date();
            expires.setMinutes(expires.getMinutes() + 30);
        }
        $.cookie(name,value,{expires:expires})
    },
    remove: function (key) {
        $.removeCookie(key);
    }
};
