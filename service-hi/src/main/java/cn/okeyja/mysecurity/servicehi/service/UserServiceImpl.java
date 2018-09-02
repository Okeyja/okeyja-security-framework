package cn.okeyja.mysecurity.servicehi.service;


import cn.okeyja.mysecurity.servicehi.entity.User;
import cn.okeyja.mysecurity.servicehi.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserDao userDao;


    public User create(String username, String password) {

        User user = new User();
        user.setUsername(username);
        String hash = encoder.encode(password);
        user.setPassword(hash);
        User u = userDao.save(user);
        return u;

    }
}
