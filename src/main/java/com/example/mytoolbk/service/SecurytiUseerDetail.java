package com.example.mytoolbk.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.mytoolbk.entiy.Account;
import com.example.mytoolbk.mapper.AccountMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * className:SecurytiUseerDetail
 * packaae:com.example.mytoolbk.service
 * Desrciption: 权限认证的类，操作数据库
 *
 * @Date:2022/5/12 10:51
 * @Author:86150
 */
@Service("userDetailsService")
public class SecurytiUseerDetail  implements UserDetailsService {



    AccountMapper accountMapper;

    @Autowired
    public void setAccountMapper( AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
        SecurytiUseerDetail.accountMapperStatic=accountMapper;
    }

    static AccountMapper accountMapperStatic;


    static Map<String ,Account> map=new HashMap<>();

    public static  Account getUser() throws UsernameNotFoundException {
        User u= (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(ToStringBuilder.reflectionToString("看下有没有先："+u));
        Account account = map.get(u.getUsername());
        if (account == null) {
//            System.out.println("查询一次");
            QueryWrapper<Account> query = Wrappers.query();
            query.eq("username",u.getUsername());
            account = accountMapperStatic.selectOne(query);
            if (account == null) {
                throw   new UsernameNotFoundException("用户名不存在！");
            }
            map.put(u.getUsername(),account);
        }
        return  account;

    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("验证用户名："+username);

        QueryWrapper<Account> query = Wrappers.query();
        query.eq("username",username);
        Account account = accountMapper.selectOne(query);
        if(account==null)
            throw  new UsernameNotFoundException("用户名不存在！");
        //用户的权限，角色，角色使用ROLE_ 开头比如  admin -> ROLE_admin
        Collection<? extends GrantedAuthority> auth= AuthorityUtils.
                commaSeparatedStringToAuthorityList("role,ROLE_admin");
        //添加进入缓存，方便获取
        map.put(username,account);
        return new User(account.getUsername(),new BCryptPasswordEncoder().encode(account.getPassword()),auth);
    }
}
