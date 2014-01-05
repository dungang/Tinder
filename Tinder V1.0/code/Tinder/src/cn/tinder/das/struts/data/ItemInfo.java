/**
 * TODO
 * 上午01:41:04
 */
package cn.tinder.das.struts.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class ItemInfo
{
    private String type;
    private String name;
    private String handle;
    private String limit;
    private String value;
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getHandle()
    {
        return handle;
    }
    public void setHandle(String handle)
    {
        this.handle = handle;
    }
    public String getLimit()
    {
        return limit;
    }
    public void setLimit(String limit)
    {
        this.limit = limit;
    }
    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        this.value = value;
    }
    @Override
    public String toString()
    {
        return "ItemInfo [type=" + type + ", name=" + name + ", handle="
                + handle + ", limit=" + limit + ", value=" + value + "]";
    }
    
    

}
