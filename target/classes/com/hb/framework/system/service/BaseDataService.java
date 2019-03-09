package com.hb.framework.system.service;

import java.text.ParseException;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hb.framework.superhelp.task.QuartzManager;
import com.hb.framework.superhelp.task.TargetJob;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.dao.BaseDataDao;
import com.hb.framework.system.entity.BaseData;
@Transactional
@Service("baseDataService")
public class BaseDataService{
	@Autowired
	private BaseDataDao baseDataDao;
	public void add(BaseData baseData) {
		baseDataDao.add(baseData);
		if("100".equals(baseData.getType())){
			setTask(baseData);
		}
	}
	
	public PageView query(PageView pageView, BaseData baseData) {
		List<BaseData> list = baseDataDao.query(pageView, baseData);
		pageView.setRecords(list);
		return pageView;
	}
	public List<BaseData> findType(String type) {
		return baseDataDao.findType(type);
	}
	public void delete(String id) {
		BaseData baseData=this.getById(id);
		if("100".equals(baseData.getType())){
			shutdownTaskByEnName(baseData.getAlias());
		}
		baseDataDao.delete(id);
	}

	public BaseData getById(String id) {
		return baseDataDao.getById(id);
	}

	public void modify(BaseData baseData) {
		baseDataDao.modify(baseData);
		if("100".equals(baseData.getType())){
			setTask(baseData);
		}
	}
	
	public BaseData findByAlias(String alias) {
		return baseDataDao.findByAlias(alias);
	}
	
	/**
	 * 添加所有需要执行的任务
	 */
	public void setAllTask() {
		List<BaseData> list = baseDataDao.findTask();
		for (BaseData task : list) {
			setTask(task);
		}
	}
	
	/**
	 * 根据用户设定的值添加任务
	 * @param task 
	 */
	private void setTask(BaseData task) {
		String class_method_cron=task.getValue();
		//判断配置参数是否符合条件
		if(null!=class_method_cron && !"".equals(class_method_cron) && class_method_cron.indexOf("#")>-1){
			String params[]=class_method_cron.split("#");
			String targetObject = params[0];//执行的类
			String targetMethod = params[1];//方法
			String cronExpression = params[2];//时间配置
			String alias = task.getAlias();//时间配置
			try {
				shutdownTaskByEnName(alias);
				if(task.getStatus()==1){
					Job job = new TargetJob();
					JobDataMap jobDataMap = new JobDataMap();
					jobDataMap.put(TargetJob.TARGET_OBJECT, targetObject);
					jobDataMap.put(TargetJob.TARGET_METHOD, targetMethod);
					QuartzManager.addJob(alias, job, cronExpression, jobDataMap);
				}
			} catch (SchedulerException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
	}
    /**
     * 移除某个任务
     * @param enName 添加任务时取的名称
     */
	public void shutdownTaskByEnName(String class_method_cron) {
		try {
			Scheduler sched = QuartzManager.sf.getScheduler();
			Trigger trigger = sched.getTrigger(class_method_cron,QuartzManager.TRIGGER_GROUP_NAME);
			if (trigger != null) {
				QuartzManager.removeJob(class_method_cron);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
}
