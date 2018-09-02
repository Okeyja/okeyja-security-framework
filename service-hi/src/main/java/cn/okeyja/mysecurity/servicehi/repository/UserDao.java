package cn.okeyja.mysecurity.servicehi.repository;

import cn.okeyja.mysecurity.servicehi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {

	User findByUsername(String username);

}
