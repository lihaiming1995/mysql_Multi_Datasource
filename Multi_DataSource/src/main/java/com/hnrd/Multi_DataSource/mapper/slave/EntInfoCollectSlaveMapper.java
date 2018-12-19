package com.hnrd.Multi_DataSource.mapper.slave;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hnrd.Multi_DataSource.pojo.EntInfoCollect;

@Mapper
public interface EntInfoCollectSlaveMapper {

	int insert(EntInfoCollect record);

    List<EntInfoCollect> selectAll();
}
