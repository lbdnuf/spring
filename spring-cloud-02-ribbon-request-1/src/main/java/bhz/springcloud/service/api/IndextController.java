package bhz.springcloud.service.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import bhz.springcloud.entity.User;

@RestController
public class IndextController {

	@Autowired
	private RestTemplate restTemplate;
	
	//http://localhost:7003/get
	@RequestMapping(value = "/get", method = { RequestMethod.GET })
	public String get() {
		
		ResponseEntity<User> response =restTemplate.getForEntity("http://client-service/getUser?id={1}",User.class,"001");
		User User = response.getBody();
		System.err.println(User.getName());
		return "Hello--------------get--------------";
	}
	@RequestMapping(value = "/post", method = { RequestMethod.GET })
	public String post() {
		LinkedMultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
		form.set("id", "002");
		ResponseEntity<User> response = restTemplate.postForEntity("http://client-service/postUser",form, User.class);
		User User = response.getBody();
		System.err.println(User.getName());
		return "Hello--------------post--------------";
	}
	@RequestMapping(value = "/insert", method = { RequestMethod.GET })
	public String insert() {
		User User = new User("003", "wangwu", 20);
		ResponseEntity<User> response = restTemplate.postForEntity("http://client-service/insertUser",User, User.class);
		User responseUser = response.getBody();
		System.err.println(responseUser.getName());
		return "Hello--------------insert--------------";
	}
	@RequestMapping(value = "/put", method = { RequestMethod.GET })
	public String put() {
		User user = new User("003", "wangwu", 20);
		restTemplate.put("http://client-service/putUser?id={1}", user, "003");
		return "Hello--------------put--------------";
	}
	@RequestMapping(value = "/delete", method = { RequestMethod.GET })
	public String delete() {
		restTemplate.delete("http://client-service/deleteUser?id=003");
		return "Hello--------------delete--------------";
	}
	
}
