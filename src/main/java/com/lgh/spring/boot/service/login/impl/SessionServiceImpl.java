package com.lgh.spring.boot.service.login.impl;

import com.lgh.spring.boot.model.MUser;
import com.lgh.spring.boot.pojo.developer.SessionUser;
import com.lgh.spring.boot.service.login.SessionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SessionServiceImpl implements SessionService {

    private static final Log LOG = LogFactory.getLog(SessionServiceImpl.class);

    private static final String SESSION_KEY_USER = "user";
    private static final long SESSION_EXPIRE_TIME = 30 * 60 * 1000;

    @Override
    public boolean userLogin(HttpSession session, MUser user) {
        if (user == null || session == null) {
            return false;
        }
        if (session.getAttribute(SESSION_KEY_USER) != null) {
            LOG.info("session中已有用户登陆，无需再次登陆");
            return false;
        }
        SessionUser sessionUser = new SessionUser();
        BeanUtils.copyProperties(user, sessionUser);
        sessionUser.setSessionId(session.getId());
        sessionUser.setLoginTime(System.currentTimeMillis());
        sessionUser.setExpireTime(SESSION_EXPIRE_TIME);
        session.setAttribute(SESSION_KEY_USER, sessionUser);
        LOG.info(user.getName() + " 于" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.s").format(new Date()) + "登陆，有效期" + (SESSION_EXPIRE_TIME / 60 / 1000) + "分钟");
        return true;
    }

    @Override
    public boolean userLogout(HttpSession session) {
        if (session == null)
        {
            return false;
        }
        session.removeAttribute(SESSION_KEY_USER);
        return true;
    }

    @Override
    public SessionUser checkLogin(HttpSession session) {
        Object object = session.getAttribute(SESSION_KEY_USER);
        if (object == null)
        {
            return null;
        }
        try {
            return (SessionUser)object;

        }catch (Exception e)
        {
            LOG.error("session 数据异常，无法获取用户信息");
            return null;
        }
    }
}
