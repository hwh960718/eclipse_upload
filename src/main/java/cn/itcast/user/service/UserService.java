package cn.itcast.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.itcast.user.bean.EasyUIResult;
import cn.itcast.user.mapper.NewUserMapper;
import cn.itcast.user.pojo.QueryInfo;
import cn.itcast.user.pojo.User;

@Service
public class UserService {
	@Autowired
	private NewUserMapper newUserMapper;

	// private UserMapper userMapper;

	public EasyUIResult queryUserList(QueryInfo queryInfo) {
		// 设置分页参数
		PageHelper.startPage(queryInfo.getPage(), queryInfo.getRows());
		List<User> users = this.newUserMapper.select(null);
		// 获取分页之后的信息
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		return new EasyUIResult(pageInfo.getTotal(), users);
	}

}
