package bhz.springcloud.service.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bhz.springcloud.entity.User;

@RestController
public class UserController {

	@RequestMapping(value = "/getUser", method = { RequestMethod.GET })
	public User getgetUser(@RequestParam("id") String id) {
		System.err.println("client 1 ----------id:" + id);
		return new User(id,"张三",10);
	}
	@RequestMapping(value = "/postUser", method = { RequestMethod.POST })
	public User postUser(@RequestParam("id") String id) {
		System.err.println("client 1 ----POST------id:" + id);
		return new User(id,"李四",19);
	}
	@RequestMapping(value = "/insertUser",produces = {"application/json;charset=UTF-8"},consumes = {"application/json;charset=UTF-8"}, method = { RequestMethod.POST })
	public User insertUser(@RequestBody User user) {
		System.err.println("client 1 -----POST-----insertUser:" + user.getId());
		return user;
	}
	@RequestMapping(value = "/putUser",produces = {"application/json;charset=UTF-8"},consumes = {"application/json;charset=UTF-8"}, method = { RequestMethod.PUT })
	public User putUser(@RequestBody User user,@RequestParam("id")String id) {
		System.err.println("client 1 ----PUT------putUser:" + id);
		return new User(id,"7777",19);
	}
	@RequestMapping(value = "/deleteUser", method = { RequestMethod.DELETE })
	public User deleteUser(@RequestParam("id")String id) {
		System.err.println("client 1 ----DELETE------deleteUser:" + id);
		return new User(id,"88888",19);
	}
}
