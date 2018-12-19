package com.hnrd.Multi_DataSource.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages=MasterDataSourceConfig.MAPPER_PACKAGE,sqlSessionFactoryRef="masterSessionFactory")
public class MasterDataSourceConfig {
	static final String MAPPER_LOCATION="classpath:mapper/master/*.xml";
	static final String MAPPER_PACKAGE="com.hnrd.Multi_DataSource.mapper.master";
	@Bean(name="masterDataSource")
	@Primary
	public DataSource masterDataSource() {
		DruidDataSource druidDataSource=new DruidDataSource();
		druidDataSource.setUrl("jdbc:mysql:///testmaster?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=Asia/Shanghai");
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("root");
		return druidDataSource;
		
	}
	@Bean(name="masterSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlsessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MasterDataSourceConfig.MAPPER_LOCATION));
		return sqlSessionFactoryBean.getObject();
	}
	
	
	@Bean(name="masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

}
