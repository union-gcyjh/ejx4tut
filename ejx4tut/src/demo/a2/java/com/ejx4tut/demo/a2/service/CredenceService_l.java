package com.ejx4tut.demo.a2.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejx4tut.training.a1.domain.entity.Credence_l;
import com.ejx4tut.training.a1.mapper.CredenceMapper_l;
import com.tienon.framework.persistence.mybatis.paginator.domain.PageBounds;
import com.tienon.framework.persistence.mybatis.paginator.domain.PageList;
import com.tienon.framework.supports.ActionResult;
import com.tienon.framework.supports.InternalActionResult;
import com.tienon.web.support.PageGrid;
import com.tienon.web.support.PageResult;

@Service (value = "credenceService") //必须加,或改配置文件spring默认以类名小写首字母生产实例
public class CredenceService_l {
	@Resource
	CredenceMapper_l credenceMapper_l;

	public ActionResult add(Credence_l credence_l) {
		// TODO: 参数检查之类的
		credence_l.setSt(new Date());
		credence_l.setCredenceExp("20150101");
		credenceMapper_l.insert(credence_l);
		ActionResult result = new ActionResult(true, "数据已插入", credence_l);
		return result;
	}
	

	// 以下是A4练习部分

	@Transactional
	public Object listCredence(PageGrid input) {
		int page = input.getPage();
		int pageSize = input.getRows();
		PageBounds pageBounds = new PageBounds(page, pageSize, true);
		PageList<Credence_l> rows = credenceMapper_l.selectList(input.getSearchCondition(), pageBounds);
		// 获得结果集条总数
		int total = rows.getPaginator().getTotalCount();
		return new ActionResult(new PageResult(total, rows));
	}

	// 和 listCredence() 等价
	@Transactional
	public Object listCredence2(PageGrid input) {
		PageList<Credence_l> rows = credenceMapper_l.selectList(input.getSearchCondition(), input.getPageBounds());
		return new ActionResult(new PageResult(rows));
	}

	@Transactional
	public Object addCredence(Credence_l credence_l){
		// TODO 验证数据合法性
		Date date = new Date();
		credence_l.setSt(date); // 设置时间戳
		credenceMapper_l.insert(credence_l);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("credence_l", credence_l);
		return  new ActionResult(resMap);
	}

	@Transactional
	public Object updateCredence(Credence_l credence_l){
		// TODO 验证数据合法性
		Date date = new Date();
		credence_l.setSt(date); // 设置时间戳
		credenceMapper_l.update(credence_l);
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("credence_l", credence_l);
		return  new ActionResult(resMap);
	}

	@Transactional
	public Object removeCredence(HashMap<String,Object> input){
		Object credenceIds = input.get("credenceIds");
		if(credenceIds instanceof List){
			List<String> list = (List<String>) credenceIds;
			for (String credenceId : list) {
				credenceMapper_l.deleteById(credenceId);
			}
			return new InternalActionResult(true, "凭证删除成功！");
		} else {
			return new InternalActionResult(false, "凭证删除失败！");
		}
	}

}
