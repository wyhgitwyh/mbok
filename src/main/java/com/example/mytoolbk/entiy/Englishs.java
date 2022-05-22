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
@TableName("englishs")
public class Englishs implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String originaltext;

    private String translation;

    private String slug;

    private static final long serialVersionUID = 1L;
}