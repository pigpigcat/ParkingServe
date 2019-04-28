package la.chopper.spring.boot.core.service;

import com.github.pagehelper.PageInfo;
import la.chopper.spring.boot.core.domain.UserInfo;

/**
 * @author TonyTonyChopper
 */
public interface UserInfoService {

    PageInfo<UserInfo> queryAll();

    UserInfo getUserByName(String userName);

    /**
     * 登录
     *
     * @param userInfo
     * @return
     */
    int signOn(UserInfo userInfo);

    /**
     * 注册
     *
     * @param userInfo
     * @return
     */
    int signUp(UserInfo userInfo);
}
