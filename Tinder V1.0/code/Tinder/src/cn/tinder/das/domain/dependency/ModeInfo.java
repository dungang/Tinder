package cn.tinder.das.domain.dependency;

import org.junit.Test;

/**
 * 
 * @author Administrator
 *  �Ű෽ʽ��
 */
public class ModeInfo
{
    private String modeName;  //������
    private String modeTime;  //���ʱ��
    private float modeHours;    //���ʱ��
    private float modeAvgNum; //���ƽ������
    
    public ModeInfo(){

	}
    
    ModeInfo(String name,String time ){
		setModeName(name);
		setModeTime(time);
		
	}
    
    
    public String getModeName()
    {
        return modeName;
    }
    public void setModeName(String modeName)
    {
        this.modeName = modeName;
    }
    public String getModeTime()
    {
        return modeTime;
    }
    public String getModeTime(int i)
    {
    	if(modeTime.split(";").length<i+1){
    		return "";
    	}else{
    		return modeTime.split(";")[i];
    	}
    }
    public void setModeTime(String modeTime)
    {
        this.modeTime = modeTime;
    }
    public float getModeHours()
    {
        return modeHours;
    }
    public void setModeHours(float modeHours)
    {
        this.modeHours = modeHours;
    }
    public float getModeAvgNum()
    {
        return modeAvgNum;
    }
    public void setModeAvgNum(float modeAvgNum)
    {
        this.modeAvgNum = modeAvgNum;
    }
    @Override
    public String toString()
    {
        return "ArrangeMode [modeName=" + modeName + ", modeTime=" + modeTime
                + ", modeHours=" + modeHours + ", modeAvgNum=" + modeAvgNum
                + "]";
    }

    

    
    
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + Float.floatToIntBits(modeAvgNum);
        result = prime * result + Float.floatToIntBits(modeHours);
        result = prime * result
                + ((modeName == null) ? 0 : modeName.hashCode());
        result = prime * result
                + ((modeTime == null) ? 0 : modeTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ModeInfo other = (ModeInfo) obj;
        if (Float.floatToIntBits(modeAvgNum) != Float
                .floatToIntBits(other.modeAvgNum))
            return false;
        if (Float.floatToIntBits(modeHours) != Float
                .floatToIntBits(other.modeHours))
            return false;
        if (modeName == null)
        {
            if (other.modeName != null)
                return false;
        } else if (!modeName.equals(other.modeName))
            return false;
        if (modeTime == null)
        {
            if (other.modeTime != null)
                return false;
        } else if (!modeTime.equals(other.modeTime))
            return false;
        return true;
    }

    @Test
    public void test(){
    	//TEST
    	ModeInfo m =new  ModeInfo("A","01:00~02:00;02:00~02:30");
    	System.out.println(m.modeHours);
    }
   
}
    
 
