package com.hb.framework.superhelp.task;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzManager {
	public static SchedulerFactory sf = new StdSchedulerFactory();
	public static String JOB_GROUP_NAME = "TASK_JOB_GROUP";
	public static String TRIGGER_GROUP_NAME = "TASK_TRIGGER_GROUP";
	/**
	 * 添加一个任务到任务集群器
	 * @param 任务名称（根据此名称可以修改，删除任务）
	 * @param job
	 * @param time
	 * @param jobDataMap
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public static void addJob(String jobName, Job job, String time,JobDataMap jobDataMap) throws SchedulerException, ParseException {
		Scheduler sched = sf.getScheduler();
		JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, job.getClass());
		if (jobDataMap != null) {
			jobDetail.setJobDataMap(jobDataMap);
		}
		CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);
		trigger.setCronExpression(time);
		sched.scheduleJob(jobDetail, trigger);
		if (!sched.isShutdown())
			sched.start();
	}
	/**
	 * 添加任务集群
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 * @param job
	 * @param time
	 * @param jobDataMap
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public static void addJob(String jobName, String jobGroupName,String triggerName, String triggerGroupName, Job job, String time,
			JobDataMap jobDataMap) throws SchedulerException, ParseException {
		Scheduler sched = sf.getScheduler();
		JobDetail jobDetail = new JobDetail(jobName, jobGroupName, job.getClass());
		if (jobDataMap != null) {
			jobDetail.setJobDataMap(jobDataMap);
		}
		CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);
		trigger.setCronExpression(time);
		sched.scheduleJob(jobDetail, trigger);
		if (!sched.isShutdown())
			sched.start();
	}

	/**
	 * 根据名称修改任务属性
	 * @param jobName
	 * @param time
	 * @param jobDataMap
	 * @throws SchedulerException
	 * @throws ParseException
	 */
	public static void modifyJob(String jobName, String time,
			JobDataMap jobDataMap) throws SchedulerException, ParseException {
		Scheduler sched = sf.getScheduler();
		Trigger trigger = sched.getTrigger(jobName, TRIGGER_GROUP_NAME);
		if (trigger != null) {
			if (jobDataMap != null) {
				JobDetail jobDetail = sched.getJobDetail(jobName,
						JOB_GROUP_NAME);
				jobDetail.setJobDataMap(jobDataMap);
			}
			CronTrigger ct = (CronTrigger) trigger;
			ct.setCronExpression(time);
			sched.resumeTrigger(jobName, TRIGGER_GROUP_NAME);
			sched.resumeJob(jobName, JOB_GROUP_NAME);
		}
	}

	public static void modifyJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, String time,
			JobDataMap jobDataMap) throws SchedulerException, ParseException {
		Scheduler sched = sf.getScheduler();
		Trigger trigger = sched.getTrigger(triggerName, triggerGroupName);
		if (trigger != null) {
			if (jobDataMap != null) {
				JobDetail jobDetail = sched.getJobDetail(jobName, jobGroupName);
				jobDetail.setJobDataMap(jobDataMap);
			}
			CronTrigger ct = (CronTrigger) trigger;
			ct.setCronExpression(time);
			sched.resumeTrigger(triggerName, triggerGroupName);
			sched.resumeJob(jobName, jobGroupName);
		}
	}

	/**
	 * 根据任务名称移除任务
	 * @param jobName
	 * @throws SchedulerException
	 */
	public static void removeJob(String jobName) throws SchedulerException {
		Scheduler sched = sf.getScheduler();
		sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME);
		sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME);
		sched.deleteJob(jobName, JOB_GROUP_NAME);
	}

	public static void removeJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName)
			throws SchedulerException {
		Scheduler sched = sf.getScheduler();
		sched.pauseTrigger(triggerName, triggerGroupName);
		sched.unscheduleJob(triggerName, triggerGroupName);
		sched.deleteJob(jobName, jobGroupName);
	}
}
