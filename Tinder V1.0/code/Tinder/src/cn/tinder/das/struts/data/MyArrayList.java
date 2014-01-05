/**
 * TODO
 * 上午01:13:38
 */
package cn.tinder.das.struts.data;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class MyArrayList extends ArrayList
{
    private Class itemClass;   
      
    public MyArrayList(Class itemClass) 
    {                 
        this.itemClass = itemClass;               
    }   
    public Object get(int index) 
    { 
        try 
        {  
            while (index >= size()) 
            {   
                add(itemClass.newInstance());   
            }   
         } 
         catch (Exception e)
         {   
             e.printStackTrace();   
         } 
         return super.get(index);   
     }   

}
