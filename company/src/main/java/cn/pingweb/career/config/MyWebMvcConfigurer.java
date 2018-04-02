package cn.pingweb.career.config;

import cn.pingweb.career.interceptor.ApplicantInterceptor;
import cn.pingweb.career.interceptor.CrossFieldInterceptor;
import cn.pingweb.career.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wpc on 2017/5/21.
 */
@Configuration
public class MyWebMvcConfigurer extends WebMvcConfigurerAdapter {

//    @Autowired
//    private LoginInterceptor loginInterceptor;

//    @Autowired
//    private CrossFieldInterceptor crossFieldInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        ApplicantInterceptor applicantInterceptor = new ApplicantInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("/company/*");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/user/*");
        registry.addInterceptor(new CrossFieldInterceptor());

        super.addInterceptors(registry);
    }
}
