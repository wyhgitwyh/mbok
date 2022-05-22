package com.example.mytoolbk.entiy;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * className:BasicMemory
 * packaae:com.example.mytoolbk.entiy
 * Desrciption:基础记忆类
 *
 * @Date:2022/5/18 8:36
 * @Author:86150
 */
@Data
@TableName("basic_memory")
public class BasicMemory {

    @TableId(type=IdType.AUTO)
    private  Integer id;
    private  String symbol;
    private String meaning;
    private String lable;
    private String collectSign;
    private String forgetNum;
    @TableField(fill = FieldFill.UPDATE)
    private String update_time;

}
