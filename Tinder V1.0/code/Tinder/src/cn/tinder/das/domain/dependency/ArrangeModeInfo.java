package cn.tinder.das.domain.dependency;

/**
 * 
 * @author Administrator
 * ����վ���ܹ��ĵ��Ű�������
 */
public class ArrangeModeInfo
{
    private String arrangeName;
    
    private ModeInfo aMode;
    private ModeInfo bMode;
    private ModeInfo cMode;
    
    private ModeInfo dMode;
    private ModeInfo eMode;
    private ModeInfo fMode;
    
    
    private ModeInfo gMode;
    private ModeInfo hMode;
    private ModeInfo zMode;
    public String getArrangeName()
    {
        return arrangeName;
    }
    public void setArrangeName(String arrangeName)
    {
        this.arrangeName = arrangeName;
    }
    public ModeInfo getaMode()
    {
        return aMode;
    }
    public void setaMode(ModeInfo aMode)
    {
        this.aMode = aMode;
    }
    public ModeInfo getbMode()
    {
        return bMode;
    }
    public void setbMode(ModeInfo bMode)
    {
        this.bMode = bMode;
    }
    public ModeInfo getcMode()
    {
        return cMode;
    }
    public void setcMode(ModeInfo cMode)
    {
        this.cMode = cMode;
    }
    public ModeInfo getdMode()
    {
        return dMode;
    }
    public void setdMode(ModeInfo dMode)
    {
        this.dMode = dMode;
    }
    public ModeInfo geteMode()
    {
        return eMode;
    }
    public void seteMode(ModeInfo eMode)
    {
        this.eMode = eMode;
    }
    public ModeInfo getfMode()
    {
        return fMode;
    }
    public void setfMode(ModeInfo fMode)
    {
        this.fMode = fMode;
    }
    public ModeInfo getgMode()
    {
        return gMode;
    }
    public void setgMode(ModeInfo gMode)
    {
        this.gMode = gMode;
    }
    public ModeInfo gethMode()
    {
        return hMode;
    }
    public void sethMode(ModeInfo hMode)
    {
        this.hMode = hMode;
    }
    public ModeInfo getzMode()
    {
        return zMode;
    }
    public void setzMode(ModeInfo zMode)
    {
        this.zMode = zMode;
    }
    @Override
    public String toString()
    {
        return "ArrangeModeInfo [arrangeName=" + arrangeName + ", aMode="
                + aMode + ", bMode=" + bMode + ", cMode=" + cMode + ", dMode="
                + dMode + ", eMode=" + eMode + ", fMode=" + fMode + ", gMode="
                + gMode + ", hMode=" + hMode + ", zMode=" + zMode + "]";
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aMode == null) ? 0 : aMode.hashCode());
        result = prime * result
                + ((arrangeName == null) ? 0 : arrangeName.hashCode());
        result = prime * result + ((bMode == null) ? 0 : bMode.hashCode());
        result = prime * result + ((cMode == null) ? 0 : cMode.hashCode());
        result = prime * result + ((dMode == null) ? 0 : dMode.hashCode());
        result = prime * result + ((eMode == null) ? 0 : eMode.hashCode());
        result = prime * result + ((fMode == null) ? 0 : fMode.hashCode());
        result = prime * result + ((gMode == null) ? 0 : gMode.hashCode());
        result = prime * result + ((hMode == null) ? 0 : hMode.hashCode());
        result = prime * result + ((zMode == null) ? 0 : zMode.hashCode());
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
        ArrangeModeInfo other = (ArrangeModeInfo) obj;
        if (aMode == null)
        {
            if (other.aMode != null)
                return false;
        } else if (!aMode.equals(other.aMode))
            return false;
        if (arrangeName == null)
        {
            if (other.arrangeName != null)
                return false;
        } else if (!arrangeName.equals(other.arrangeName))
            return false;
        if (bMode == null)
        {
            if (other.bMode != null)
                return false;
        } else if (!bMode.equals(other.bMode))
            return false;
        if (cMode == null)
        {
            if (other.cMode != null)
                return false;
        } else if (!cMode.equals(other.cMode))
            return false;
        if (dMode == null)
        {
            if (other.dMode != null)
                return false;
        } else if (!dMode.equals(other.dMode))
            return false;
        if (eMode == null)
        {
            if (other.eMode != null)
                return false;
        } else if (!eMode.equals(other.eMode))
            return false;
        if (fMode == null)
        {
            if (other.fMode != null)
                return false;
        } else if (!fMode.equals(other.fMode))
            return false;
        if (gMode == null)
        {
            if (other.gMode != null)
                return false;
        } else if (!gMode.equals(other.gMode))
            return false;
        if (hMode == null)
        {
            if (other.hMode != null)
                return false;
        } else if (!hMode.equals(other.hMode))
            return false;
        if (zMode == null)
        {
            if (other.zMode != null)
                return false;
        } else if (!zMode.equals(other.zMode))
            return false;
        return true;
    }
   
    
   
    


    
}
