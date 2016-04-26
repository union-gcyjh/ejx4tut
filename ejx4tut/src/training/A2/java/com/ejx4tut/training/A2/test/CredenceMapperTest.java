package com.ejx4tut.training.A2.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;

import com.ejx4tut.common.UnitTestEnv;
import com.ejx4tut.training.a1.domain.entity.Credence_l;
import com.ejx4tut.training.a1.mapper.CredenceMapper_l;

public class CredenceMapperTest extends UnitTestEnv{
	@Resource
	CredenceMapper_l credenceMapper_l;

	/**
	 * 新建记录
	 * @param x 后缀
	 * @return
	 */
	private Credence_l newObject(String x) {
		Credence_l credence_l = new Credence_l();
		credence_l.setAuthTypeCode(x);
		credence_l.setCredenceExp("2012-01-01 00:00:" + x);
		credence_l.setRemark("remark-test" + x);
		credence_l.setSt(new Date()); // now
		credence_l.setUserId("userId-" + x);
		return credence_l;
	}
	
	/**
	 * CRUD单元测试
	 */
	@Test
	public void testAll(){
		
		// 新建记录
		int n = 1;
		String x = String.format("%02d", n);
		Credence_l credence_l = newObject(x);
		String credenceId = credence_l.getCredenceId();
		Credence_l o;
		
		// 插入
		credenceMapper_l.insert(credence_l);
		
		// 查找
//		o = credenceMapper_l.findByUserAndAuthType("userId-"+ x, x);
//		Assert.assertEquals(credenceId, o.getCredenceId());
//
//		List<Credence_l> list = credenceMapper_l.findByUserID("userId-"+ x);
//		Assert.assertEquals(1, list.size());
//		o = list.get(0);
//		Assert.assertEquals(credenceId, o.getCredenceId());
//
//		// 更新
//		o.setRemark("remark-update");
//		int ret = credenceMapper_l.update(o);
//		Assert.assertEquals(1, ret);
//		o = credenceMapper_l.findById(credenceId);
//		Assert.assertEquals("remark-update", o.getRemark());
//		
//		// 删除
//		ret = credenceMapper_l.deleteById(credenceId);
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
//			credenceMapper_l.insert(newObject(x));
//		}
	}
	
}
