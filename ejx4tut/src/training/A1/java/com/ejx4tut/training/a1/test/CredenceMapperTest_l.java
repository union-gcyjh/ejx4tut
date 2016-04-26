package com.ejx4tut.training.a1.test;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ejx4tut.common.UnitTestEnv;
import com.ejx4tut.training.a1.domain.entity.Credence_l;
import com.ejx4tut.training.a1.mapper.CredenceMapper_l;

public class CredenceMapperTest_l extends UnitTestEnv{
	@Resource
	CredenceMapper_l credenceMapper;

	/**
	 * 新建记录
	 * @param x 后缀
	 * @return
	 */
	private Credence_l newObject(String x) {
		Credence_l credence = new Credence_l();
		credence.setAuthTypeCode(x);
		credence.setCredenceExp("2012-01-01 00:00:" + x);
		credence.setRemark("remark-test" + x);
		credence.setSt(new Date()); // now
		credence.setUserId("userId-" + x);
		return credence;
	}
	
	/**
	 * CRUD单元测试
	 */
	@Test
	public void testAll(){
		
		// 新建记录
		int n = 1;
		String x = String.format("%02d", n);
		Credence_l credence = newObject(x);
		String credenceId = credence.getCredenceId();
		Credence_l o;
		
		// 插入
		credenceMapper.insert(credence);
		
		// 查找
//		o = credenceMapper.findByUserAndAuthType("userId-"+ x, x);
//		Assert.assertEquals(credenceId, o.getCredenceId());
//
//		List<Credence_l> list = credenceMapper.findByUserID("userId-"+ x);
//		Assert.assertEquals(1, list.size());
//		o = list.get(0);
//		Assert.assertEquals(credenceId, o.getCredenceId());
//
//		// 更新
//		o.setRemark("remark-update");
//		int ret = credenceMapper.update(o);
//		Assert.assertEquals(1, ret);
//		o = credenceMapper.findById(credenceId);
//		Assert.assertEquals("remark-update", o.getRemark());
//		
//		// 删除
//		ret = credenceMapper.deleteById(credenceId);
//		Assert.assertEquals(1, ret);
//		
//	}
//	
//	/**
//	 * 插入一些测试数据，以便界面调试
//	 */
//	@Test
//	public void testPutTestData() {
//		
//		for (int n = 0; n < 99; n++) {
//			String x = String.format("%02d", n);
//			credenceMapper.insert(newObject(x));
//		}
	}
	
}
