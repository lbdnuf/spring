package bhz.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 
    * @ClassName: ConsumerController
    * @Description: TODO(消费者示例)
    * @author::XiaoDongCooding
    * @date 2017年9月12日
    *
 */
@RestController
public class ConsumerController {

	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/getAppName",method = {RequestMethod.GET})
	public String getAppName() {
		//调用地址:http://[协议头]consumer-service/[服务名]provider/[context-path]hello[调用方法地址]
		//如果使用服务名称,不需要使用context-path
		ResponseEntity<String> response =restTemplate.getForEntity("http://provider-service/provider/hello", String.class);
		
		System.out.println(response.getBody());
		return response.getBody();
	}
	/**
	 * 
	    * @Title: getByUrl
	    * @Description: TODO(RestTemplate是一个最简单的http调用模板,与springCloud没有关系)
	    * @param 
	    * @return    参数
	    * @return String    返回类型
	    * @throws
	 */
	@RequestMapping(value="/getByUrl",method = {RequestMethod.GET})
	public String getByUrl() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response =restTemplate.getForEntity("http://localhost:7001/provider/hello", String.class);
		
		System.out.println(response.getBody());
		return response.getBody();
	}
}
