package com.example.mytoolbk.entiy;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
@TableName("poetrys")
public class Poetrys implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String author;

    private String kind;

    private static final long serialVersionUID = 1L;
    /**
     * 翻译
     */
    private String translation;
}