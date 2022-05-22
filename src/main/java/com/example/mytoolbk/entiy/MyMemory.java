package com.example.mytoolbk.entiy;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 
 * 我的记忆表
 */
@Data
@TableName("my_memory")
public class MyMemory implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 记忆键
     */
    private String key;

    /**
     * 内容简介
     */
    private String littleContent;

    /**
     * 分类，可以>随便
     */
    private String lable;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 完整内容
     */
    private String content;

    private static final long serialVersionUID = 1L;
}