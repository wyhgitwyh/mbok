package com.example.mytoolbk.entiy;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * className:Gua
 * packaae:com.example.mytoolbk.entiy
 * Desrciption:
 *
 * @Date:2022/5/12 13:00
 * @Author:86150
 */
@Data
@TableName("gua")
public class Gua {
    private  Integer id;
    private  Integer accountId;
    @TableField("`describe`")
    private  String describe;
    private  String guaText;
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;




}
