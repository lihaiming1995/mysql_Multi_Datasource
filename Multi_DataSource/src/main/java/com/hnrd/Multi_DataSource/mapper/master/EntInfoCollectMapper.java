package com.hnrd.Multi_DataSource.mapper.master;

import com.hnrd.Multi_DataSource.pojo.EntInfoCollect;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface EntInfoCollectMapper {
    int insert(EntInfoCollect record);

    List<EntInfoCollect> selectAll();
}