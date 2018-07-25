package springJMS;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMsg(String destinationName, String message) {
        System.out.println("============>>>>> 发送queue消息 " + message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
    

	@JmsListener(destination="out.queue")
	public void consumerMessage(String text){
		System.out.println("从out.queue队列收到的回复报文为:"+text);
	}
}
