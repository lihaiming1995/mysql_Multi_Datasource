package com.hnrd.wasteRecycle.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
public class ActiveMqConfig {

	@Bean
	public ActiveMQConnectionFactory jsConnectionFactoryBean() {//配置activeMQ服务器的用户名，密码和地址端口，安装后账户密码都默认为admin，访问端口固定为61616
		return new ActiveMQConnectionFactory("admin", "admin", "tcp://192.168.2.42:61616");
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {//配置队列模式bean
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setConnectionFactory(connectionFactory);
		return bean;
	}

	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {//配置主题模式bean
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		// 设置为发布订阅方式, 默认情况下使用的生产消费者方式
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(connectionFactory);
		return bean;
	}

}
