package com.lgh.spring.boot.service.login.impl;

import com.lgh.spring.boot.common.Const;
import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.developer.TokenUser;
import com.lgh.spring.boot.service.login.TokenService;
import com.lgh.spring.boot.util.TokenUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    private static final Log LOG = LogFactory.getLog(TokenServiceImpl.class);

    private static final long TOKEN_EXPIRE_TIME = 30 * 60 * 1000;

    @Override
    public boolean userLogin(MUser user, HttpServletResponse response, HttpSession session) {
        if (user == null) {
            return false;
        }
        TokenUser tokenUser = new TokenUser();
        BeanUtils.copyProperties(user, tokenUser);
        tokenUser.setLoginTime(System.currentTimeMillis());
        tokenUser.setExpireTime(TOKEN_EXPIRE_TIME);
        String encodeToken = TokenUtil.encodeToken(tokenUser);
        response.addHeader("token", encodeToken);
        session.setAttribute("token", encodeToken);
        session.setAttribute(Const.SESSION_USER_KEY, tokenUser);
        LOG.info(user.getName() + " 于" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s").format(new Date()) + "登陆，有效期" + (TOKEN_EXPIRE_TIME / 60 / 1000) + "分钟");
        return true;
    }

    @Override
    public boolean userLogout(HttpSession session) {
        session.removeAttribute("token");
        session.removeAttribute(Const.SESSION_USER_KEY);
        return true;
    }

    @Override
    public TokenUser checkLogin(String token) {
        return TokenUtil.getUser(token);
    }
}
