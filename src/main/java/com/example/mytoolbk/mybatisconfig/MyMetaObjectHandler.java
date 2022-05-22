package com.example.mytoolbk.mybatisconfig;

import java.time.LocalDateTime;
//import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

	/**
	 * 本质是entity的属性设置！
	 */
	@Override
	public void insertFill(MetaObject metaObject) {
//		Date date = new Date();
		this.fillStrategy(metaObject, "createTime",LocalDateTime.now());		
	}
	
	/**
	 * 本质是entity的属性设置！
	 */
	@Override
	public void updateFill(MetaObject metaObject) {
//		Date date = new Date();
		this.fillStrategy(metaObject, "updateTime",LocalDateTime.now());
	}
	

}
