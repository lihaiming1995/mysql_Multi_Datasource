package com.hnrd.Multi_DataSource.controller;

import java.util.HashMap;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hnrd.Multi_DataSource.mapper.master.EntInfoCollectMapper;
import com.hnrd.Multi_DataSource.mapper.slave.EntInfoCollectSlaveMapper;
import com.hnrd.Multi_DataSource.pojo.EntInfoCollect;
import com.hnrd.Multi_DataSource.utils.StringToLocalDateTimeUtils;

@RequestMapping("testMasterDataSource")
@RestController
public class TestController {
	
	private static final Logger log = LoggerFactory.getLogger(TestController.class);

	@Autowired(required=true)
	private EntInfoCollectMapper entInfoCollectMapper;
	
	@Autowired(required=true)
	private EntInfoCollectSlaveMapper entInfoCollectSlaveMapper;
	@PostMapping("insert")
	public ResponseEntity<Map<String, String>> insertEnterpriserInfo(@RequestBody EntInfoCollect entInfoCollect){
		log.info(entInfoCollect.toString());
		Map<String, String> map =new HashMap<>();
		map.put("msg","添加成功！");
		map.put("code","20000");
		entInfoCollect.setEnterprise("阿里巴巴");
		entInfoCollect.setSocialCreditCode("9581564931350400");
		entInfoCollect.setCreatAt(StringToLocalDateTimeUtils.getStringLocalDateTimeCTT());
		entInfoCollect.setUpdateAt(StringToLocalDateTimeUtils.getStringLocalDateTimeCTT());
		try {
			entInfoCollectMapper.insert(entInfoCollect);
			entInfoCollectSlaveMapper.insert(entInfoCollect);
			return new ResponseEntity<>(map,HttpStatus.OK);
		} catch (Exception e) {
			log.info(e.getMessage());
			map.put("msg","添加失败！服务器异常！");
			map.put("code","40001");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
	}
	//https://github.com/lihaiming1995/mysql_Multi_Datasource.git
}
