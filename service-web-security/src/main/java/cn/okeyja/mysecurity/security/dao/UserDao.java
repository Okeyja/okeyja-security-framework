package cn.okeyja.mysecurity.security.dao;

import cn.okeyja.mysecurity.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
