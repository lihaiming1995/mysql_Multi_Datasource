package com.hnrd.Multi_DataSource.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages=SlaveDataSourceConfig.MAPPER_PACKAGE,sqlSessionFactoryRef="slaveSessionFactory")
public class SlaveDataSourceConfig {
	static final String MAPPER_LOCATION="classpath:mapper/slave/*.xml";
	static final String MAPPER_PACKAGE="com.hnrd.Multi_DataSource.mapper.slave";
	@Bean(name="slaveDataSource")
	public DataSource slaveDataSource() {
		DruidDataSource druidDataSource=new DruidDataSource();
		druidDataSource.setUrl("jdbc:mysql:///testslave?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai");
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("root");
		return druidDataSource;
		
	}
	@Bean(name="slaveSessionFactory")
	public SqlSessionFactory slaveSqlsessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(SlaveDataSourceConfig.MAPPER_LOCATION));
		return sqlSessionFactoryBean.getObject();
	}
	
	
	@Bean(name="slaveTransactionManager")
    public DataSourceTransactionManager slaveTransactionManager() {
        return new DataSourceTransactionManager(slaveDataSource());
    }

}
