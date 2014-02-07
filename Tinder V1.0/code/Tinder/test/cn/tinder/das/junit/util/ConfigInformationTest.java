/**
 * TODO
 * 下午10:25:44
 */
package cn.tinder.das.junit.util;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.tinder.das.util.ConfigInformation;

/**
 * @author Administrator
 *
 */
public class ConfigInformationTest
{

    /**
     * Test method for {@link cn.tinder.das.util.ConfigInformation#getPropertyByName(java.lang.String)}.
     */
    @Test
    public void testGetPropertyByName()
    {
        String str =ConfigInformation.getPropertyByName("SYSTEM_USER");
        System.out.println(str);
        fail("Not yet implemented");
    }

}
