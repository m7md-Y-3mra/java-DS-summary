public class staff {
    private String managerName;
    private double slaray;
    private String staffName;

   
    public staff(String managerName, double slaray, String staffName) {
        this.managerName = managerName;
        this.slaray = slaray;
        this.staffName = staffName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public double getSlaray() {
        return slaray;
    }

    public void setSlaray(double slaray) {
        this.slaray = slaray;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }


    public String toString() {
        return " managerName: " + managerName + ", slaray: " + slaray + ", staffName: " + staffName + " \n";

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((managerName == null) ? 0 : managerName.hashCode());
        long temp;
        temp = Double.doubleToLongBits(slaray);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((staffName == null) ? 0 : staffName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        staff other = (staff) obj;
        if (managerName == null) {
            if (other.managerName != null)
                return false;
        } else if (!managerName.equals(other.managerName))
            return false;
        if (Double.doubleToLongBits(slaray) != Double.doubleToLongBits(other.slaray))
            return false;
        if (staffName == null) {
            if (other.staffName != null)
                return false;
        } else if (!staffName.equals(other.staffName))
            return false;
        return true;
    }

    
}
