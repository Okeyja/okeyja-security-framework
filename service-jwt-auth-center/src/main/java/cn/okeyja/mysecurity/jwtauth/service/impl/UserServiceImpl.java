package cn.okeyja.mysecurity.jwtauth.service.impl;


import cn.okeyja.mysecurity.jwtauth.domain.User;
import cn.okeyja.mysecurity.jwtauth.repository.UserDao;
import cn.okeyja.mysecurity.jwtauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	//private final Logger log = LoggerFactory.getLogger(getClass());

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private UserDao userDao;

	@Override
	public void create(User user) {

		User existing = userDao.findByUsername(user.getUsername());
		// Assert.isNull(existing, "user already exists: " + user.getUsername());

		String hash = encoder.encode(user.getPassword());
		user.setPassword(hash);
		userDao.save(user);

	}
}
