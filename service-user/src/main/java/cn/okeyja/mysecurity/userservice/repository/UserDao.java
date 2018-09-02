package cn.okeyja.mysecurity.userservice.repository;

import cn.okeyja.mysecurity.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
