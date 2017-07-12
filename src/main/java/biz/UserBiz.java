package biz;

import entity.User;

/**
 * Created by wing on 2017/7/10.
 */
public class UserBiz {
    private User user;

    public User getUser(String username,String password) {
        if ("张三".equals(username) || "1234".equals(password)) {
            user = new User();
            user.setUsername(username);
            user.setPassword("1234");
            return user;
        }
        return null;
    }
}
