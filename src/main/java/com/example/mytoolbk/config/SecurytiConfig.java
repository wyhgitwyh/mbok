package com.example.mytoolbk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * className:SecurytiConfig
 * packaae:com.example.mytoolbk.config
 * Desrciption:
 *
 * @Date:2022/5/12 10:43
 * @Author:86150
 */
@Configuration
public class SecurytiConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
        super.configure(auth);
    }

    @Bean
    PasswordEncoder password() {
        return  new BCryptPasswordEncoder();
    }

    //  配置自动 记住我 开始
    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){

        JdbcTokenRepositoryImpl jdbcTokenRepository=new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //自动建表
//        jdbcTokenRepository.setCreateTableOnStartup(true);
        return  jdbcTokenRepository;


    }
    //  配置自动 记住我 结束



    @Override
    protected void configure(HttpSecurity http) throws Exception {



         //配置没有权限页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        //配置爱退出，logout 随便写的。 、index是跳转的页面
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/index").permitAll();

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/user/login")
                .defaultSuccessUrl("/index").permitAll() //登录成功跳转首页
                .and().authorizeRequests()
                    .antMatchers("/","/index","/tool/free/**",
                            "/user/login","/login"
                    ,"/css/**","/js/**").permitAll()//放行
                .antMatchers("/admin/**").hasAnyRole("admin,user")//配置多个角色，逗号分隔
                .antMatchers("/power").hasAnyAuthority("power,power2")//配置多个权限逗号分隔
                .anyRequest().authenticated()
                .and()
                    .rememberMe()//开启记住我
                    .tokenRepository(persistentTokenRepository())//
                    .tokenValiditySeconds(60)//设置超时时长 单位秒
                    .userDetailsService(userDetailsService)//使用哪个操作数据的
                .and().csrf().disable();

    }
}
