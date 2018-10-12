package cn.itcast.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.user.bean.EasyUIResult;
import cn.itcast.user.pojo.QueryInfo;
import cn.itcast.user.service.UserService;

@RequestMapping("user")
@Controller
/**
 * user控制器
 * @author Administrator
 *
 */
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String toUsersPage() {
		return "users";
	}

	@RequestMapping(value = "data/list", method = RequestMethod.GET)
	@ResponseBody
	public EasyUIResult queryUserList(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "rows", defaultValue = "5") Integer rows) {
		QueryInfo queryInfo = new QueryInfo(page, rows);

		return this.userService.queryUserList(queryInfo);
	}

}
