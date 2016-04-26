package com.ejx4tut.training.a1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ejx4tut.training.a1.domain.entity.Credence_l;
import com.tienon.framework.persistence.mybatis.paginator.domain.PageBounds;
import com.tienon.framework.persistence.mybatis.paginator.domain.PageList;

public interface CredenceMapper_l {

	/**
	 * Grid查询
	 * @param condition 可以是实体，VO，或者Map对象
	 * @param pageBounds 分页参数
	 * @return
	 */
	public PageList<Credence_l> selectList(Object condition, PageBounds pageBounds);
	
	
	/**
	 * 保存凭证信息
	 */
	public void insert(Credence_l credence);

	/**
	 * 查询凭证信息
	 * 
	 * @param userId
	 *            用户ID
	 * @param authTypeCode
	 *            认证方式代码前两位，静态口令11
	 * @return
	 */
	public Credence_l findByUserAndAuthType(@Param("userId") String userId, @Param("authTypeCode") String authTypeCode);

	/**
	 * 根据用户ID查询凭证信息
	 * 
	 * @param userId
	 *            用户ID
	 * @return userId 不是唯一索引
	 */
	public List<Credence_l> findByUserID(String userId);

	/**
	 * 根据唯一索引查询凭证信息
	 */
	public Credence_l findById(String credenceId);

	/**
	 * 修改凭证信息
	 */
	public int update(Credence_l credence);

	/**
	 * 删除
	 * @param credenceId credenceId唯一索引
	 */
	public int deleteById(String credenceId);

}
