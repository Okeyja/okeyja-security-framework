# Okeyja Security Framework Sample *Service-Hi*
## Introduction
This service is set to test the TOKEN-AUTH at service port 8101.

The *service-hi* module is the resource server and the authentication client ata the same time. 
It requires a *ResourceServerConfigurerAdapter* config class:
```$xslt
//cn.okeyja.mysecurity.servicehi.config.ResourceServerConfigurer

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/user/registry").permitAll()   //不需要验证的端口
                .anyRequest().authenticated();                             //其他都需要验证
    }
}
```