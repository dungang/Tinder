/**
 * TODO
 * 上午02:42:22
 */
package cn.tinder.das.dao;

import java.util.List;

import cn.tinder.das.domain.po.JobInfo;

/**
 * @author Administrator
 *
 */
public interface JobInfoDao
{
    public void addJobInfo(JobInfo job);
    public void deleteJobInfo(JobInfo job);
    public List<JobInfo> getAllJobInfo();
}
