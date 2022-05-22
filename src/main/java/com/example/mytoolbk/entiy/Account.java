package com.example.mytoolbk.entiy;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * className:Account
 * packaae:com.example.mytoolbk.entiy
 * Desrciption:
 *
 * @Date:2022/5/12 11:28
 * @Author:86150
 */
@Data
@TableName("account")
public class Account {

    private  Integer id;
    private  String username;
    private String password;



}
