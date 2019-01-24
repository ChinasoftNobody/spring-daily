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
        var option = this.initOptionJson(url, JSON.stringify(data), success, error, 'post');
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
        var option = this.initOptionJson(url, '', success, error, 'get');
        $.get(option);
    },

    /**
     * ajax post form
     * @param url url
     * @param selector 表单选择器
     * @param success 成功回调
     * @param error 失败回调
     */
    ajaxPostFormJson: function ajaxPostFormJson(url, selector, success, error) {
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
        var option = this.initOptionJson(url, JSON.stringify(paramUtil.urlParamsToJson(selector.serialize())), success, error, 'post');
        $.post(option);
    },
    /**
     * 表单提交 不转参数信息
     * @param url url
     * @param selector selector
     * @param success success
     * @param error error
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
        var option = this.initOptionForm(url, selector, success, error, 'post');
        $.ajax(option);
    },

    initOptionForm: function (url, selector, success, error, type) {
        return {
            url: url,
            data: new FormData(selector[0]),
            type: type,
            cache: false,
            async: true,
            processData:false,
            contentType: false,
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
    },

    initOptionJson: function (url, data, success, error, type) {
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
                var names = kv[0].split('.');
                if (names.length > 1) {
                    var temp = {};
                    for (var m = 0; m < names.length; m++) {
                        var name = names[m];
                        if (m === 0) {
                            if (!result[name]) {
                                result[name] = {};
                            }
                            temp = result[name];
                        } else if (m < names.length - 1) {
                            if (!temp[name]) {
                                temp[name] = {};
                            }
                            temp = temp[name];
                        } else {
                            if (!temp[name]) {
                                temp[name] = {};
                            }
                            temp[name] = kv[1];
                        }
                    }
                } else {
                    result[kv[0]] = kv[1];
                }
            }
        }
        console.log(result);
        return result;
    }
};

var TokenUtil = {
    tokenName: 'token',
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
    get: function (name) {
        return $.cookie(name);
    },
    set: function (name, value, expires) {

        if (!expires) {
            expires = new Date();
            expires.setMinutes(expires.getMinutes() + 30);
        }
        $.cookie(name, value, {expires: expires})
    },
    remove: function (key) {
        $.removeCookie(key);
    }
};

$(function () {
    $('[data-toggle="tooltip"]').tooltip();
    $('[data-toggle="popover"]').popover();
});
