package cn.tinder.das.util;

import org.junit.Test;

public class FloatChange
{

    public static float meg(float i)
    {
        int b = (int) Math.round(i * 10); // 小数点后两位前移，并四舍五入
        float c = (float) ((float) b / 10.0); // 还原小数点后两位
        if ((c * 10) % 5 != 0)
        {
            int d = (int) Math.round(c); // 小数点前移，并四舍五入
            c = ((float) d); // 还原小数点
        }
        return c;
    }

}