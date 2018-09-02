package cn.okeyja.mysecurity.userservice.service.hystrix;

import cn.okeyja.mysecurity.userservice.entity.JWT;
import cn.okeyja.mysecurity.userservice.service.feign.AuthServiceClient;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceHystrix implements AuthServiceClient{

    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        return null;
    }
}
