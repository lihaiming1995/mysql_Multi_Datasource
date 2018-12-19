package com.hnrd.Multi_DataSource;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class GeneratorDisplay {
	public void generator() throws Exception{
		
		List<String> warnings=new ArrayList<>();
		boolean overWrite= true;
		 
		File configFile=new File("generatorConfig.xml");
		ConfigurationParser cParser=new ConfigurationParser(warnings);
		Configuration configuration=cParser.parseConfiguration(configFile);
		DefaultShellCallback callback=new DefaultShellCallback(overWrite);
		MyBatisGenerator myBatisGenerator=new MyBatisGenerator(configuration, callback, warnings);
		myBatisGenerator.generate(null);
		
	}
	public static void main(String[] args) {
		GeneratorDisplay generatorDisplay=new GeneratorDisplay();
		try {
			generatorDisplay.generator();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
