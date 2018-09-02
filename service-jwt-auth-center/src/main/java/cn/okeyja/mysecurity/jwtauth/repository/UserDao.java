package cn.okeyja.mysecurity.jwtauth.repository;

import cn.okeyja.mysecurity.jwtauth.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
