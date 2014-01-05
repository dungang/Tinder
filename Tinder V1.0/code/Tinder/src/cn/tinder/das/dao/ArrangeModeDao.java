/**
 * TODO
 * 上午02:42:22
 */
package cn.tinder.das.dao;

import java.util.List;

import cn.tinder.das.domain.po.ArrangeMode;

/**
 * @author Administrator
 *
 */
public interface ArrangeModeDao
{
    
    public void addArrangeMode(ArrangeMode mode);
    public void deleteArrangeMode(ArrangeMode mode);
    public List<ArrangeMode> getAllMode();

}
