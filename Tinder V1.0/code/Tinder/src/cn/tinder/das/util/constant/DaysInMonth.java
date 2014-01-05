package cn.tinder.das.util.constant;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.tinder.das.domain.po.GasInformation;

public class DaysInMonth
{
    public static int daysMap[] =
    { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    public static int daysLeapMap[] =
    { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static int getDays(String str)
    {

        int year = Integer.valueOf(str.substring(0, 4));
        int month = Integer.valueOf(str.substring(4, 6));

        if (year % 4 == 0 || year % 400 == 0)
        {
            return daysLeapMap[month - 1];
        } else
        {
            return daysMap[month - 1];
        }
    }

}
