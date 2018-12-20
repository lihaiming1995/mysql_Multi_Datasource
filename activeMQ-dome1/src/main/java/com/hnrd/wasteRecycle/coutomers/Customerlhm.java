package com.hnrd.wasteRecycle.coutomers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
@Component
public class Customerlhm {//消费者类，从队列中接收消息
	/**
	 * @JmsListener注解：destination对应服务器上创建的队列名称，containerFactory后的值为配置队列的bean名称，这里只有一个队列工厂类的bean，我直接使用方法名也生效
	 * @param text
	 * @return
	 */
	@JmsListener(destination="lhmQueue",containerFactory = "jmsListenerContainerQueue")
	@SendTo("lhmQueue")
	public String reciveMsg(String text) {
		System.out.println("来自队列lhmQueue的消息！"+text);
		return "李海明回复了的消息：你好！";
	}
	
	@JmsListener(destination = "lhmTopic", containerFactory = "jmsListenerContainerTopic")
	public void receive(String text){
	        System.out.println("海纳仁东发布了一条新消息！" + text);
	}

}
