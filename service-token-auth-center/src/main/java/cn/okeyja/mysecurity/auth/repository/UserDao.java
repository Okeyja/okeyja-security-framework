package cn.okeyja.mysecurity.auth.repository;

import cn.okeyja.mysecurity.auth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
