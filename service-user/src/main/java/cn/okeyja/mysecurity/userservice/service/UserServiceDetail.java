package cn.okeyja.mysecurity.userservice.service;

import cn.okeyja.mysecurity.userservice.entity.JWT;
import cn.okeyja.mysecurity.userservice.domain.User;
import cn.okeyja.mysecurity.userservice.entity.UserLoginDTO;
import cn.okeyja.mysecurity.userservice.exception.UserLoginException;
import cn.okeyja.mysecurity.userservice.repository.UserDao;
import cn.okeyja.mysecurity.userservice.service.feign.AuthServiceClient;
import cn.okeyja.mysecurity.userservice.util.BPwdEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceDetail {
    @Autowired
    private UserDao userRepository;

    public User insertUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));
        return userRepository.save(user);
    }

    @Autowired
    AuthServiceClient client;

    public UserLoginDTO login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UserLoginException("Wrong Username.");
        }
        if (!BPwdEncoderUtil.matches(password, user.getPassword())) {
            throw new UserLoginException("Wrong Password.");
        }
        // 认证方式Basic user-service:123456
        JWT jwt = client.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==", "password", username, password);
        if (null == jwt) {
            throw new UserLoginException("Internal Error");
        }
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setJwt(jwt);
        userLoginDTO.setUser(user);
        return userLoginDTO;
    }
}
