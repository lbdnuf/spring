package bhz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient // 表示服务提供/消费者 注册到服务中心
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
    }
}
