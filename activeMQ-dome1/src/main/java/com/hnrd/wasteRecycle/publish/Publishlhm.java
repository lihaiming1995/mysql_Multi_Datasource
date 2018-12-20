package com.hnrd.wasteRecycle.publish;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("queue")
public class Publishlhm {
	@Autowired
	private JmsMessagingTemplate jms;
	/**
	 * jms.convertAndSend方法：参数("队列对象("队列名")","消息内容") 此方法用于将消息发送到指定的队列中，队列通过配置成bean后直接注入更方便，这里为了简单就不写了
	 * @param mString
	 * @return
	 */
	@RequestMapping("queue")
	public String queue(String mString) { 
		jms.convertAndSend(new ActiveMQQueue("lhmQueue"),mString);//通过jms对像发送消息至消息队列，主题-订阅模式也一样		
		return "queue 发送成功";
	}
	/**
	 * 主题-订阅模式
	 * @param mString
	 * @return
	 */
	@RequestMapping("topic")
	public String topic(String mString) {
		jms.convertAndSend(new ActiveMQTopic("lhmTopic"),"海纳仁东新消息！"+mString);
		return "topic 发布成功！";
		
	}

}
