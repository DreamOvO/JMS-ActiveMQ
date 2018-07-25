package springJMS;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerTest {

	@Autowired
	private Producer producer;
	
	@Autowired
	private Publisher publisher;


	@Test
	public void contextLoads() {
		for (int i = 0; i < 10; i++) {
			producer.sendMsg("test.queue", "Queue Message " + i);
		}
	}
	
    @Test
	public void test() {
    	//Publisher publisher = new Publisher();
		for (int i = 0; i < 10; i++) {
			publisher.publish("test.topic", "Topic Message " + i);
		}
	}

}
