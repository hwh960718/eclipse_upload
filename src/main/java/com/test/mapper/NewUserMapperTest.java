package com.test.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.abel533.entity.Example;

import cn.itcast.user.mapper.NewUserMapper;
import cn.itcast.user.pojo.User;

public class NewUserMapperTest {

	private NewUserMapper newUserMapper;

	@Before
	public void setUp() throws Exception {
		// 完成newUserMapper的初始化
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/app*.xml");
		newUserMapper = context.getBean("newUserMapper", NewUserMapper.class);
	}

	@Test
	public void testSelectOne() {
		User user = new User();
		user.setId(1L);
		user.setAge(30);
		User selectOne = newUserMapper.selectOne(user);
		System.out.println(selectOne);
	}

	@Test
	public void testSelect() {

		List<User> lists = newUserMapper.select(null);
		for (User user : lists) {
			System.out.println(user);
		}

	}

	@Test
	public void testSelectCount() {
		System.out.println(newUserMapper.selectCount(null));
	}

	@Test
	public void testSelectByPrimaryKey() {
		System.out.println(newUserMapper.selectByPrimaryKey(1L));
	}

	@Test
	public void testInsert() {
	}

	@Test
	public void testInsertSelective() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteByPrimaryKey() {
	}

	@Test
	public void testUpdateByPrimaryKey() {
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
	}

	@Test
	public void testSelectCountByExample() {
		// 根据多个id查询用户信息
		List<Object> ids = new ArrayList<Object>();
		ids.add(1);
		ids.add(2);
		ids.add(3);
		Example example = new Example(User.class);
		example.createCriteria().andIn("id", ids);
		List<User> list = this.newUserMapper.selectByExample(example);
		for (User user : list) {
			System.out.println(user);
		}

	}

	@Test
	public void testDeleteByExample() {
		Example example = new Example(User.class);
		example.createCriteria().andBetween("age", 80, 90);
		newUserMapper.deleteByExample(example);
	}

	@Test
	public void testSelectByExample() {
	}

	@Test
	public void testUpdateByExampleSelective() {
	}

	@Test
	public void testUpdateByExample() {
	}

}
