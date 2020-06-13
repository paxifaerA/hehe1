package cn.hxzy.Config;

import cn.hxzy.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public abstract class MvcConfig implements WebMvcConfigurer {

    @Bean//此处Bean就是为了产生一个LoginInterceptor对象
    public LoginInterceptor loginInterceptor(){
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        return loginInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry Registry) {
        Registry.addInterceptor(this.loginInterceptor()).addPathPatterns("/**");
    }
}
