package cn.itcast.user.mapper;

import java.util.List;
import cn.itcast.user.pojo.QueryInfo;
import cn.itcast.user.pojo.User;

public interface UserMapper {

	public List<User> queryUserList();

	public List<User> queryUserPageInfo(QueryInfo queryInfo);

	public int queryUserCount();
}
