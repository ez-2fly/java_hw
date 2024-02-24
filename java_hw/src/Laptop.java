public class Laptop {
    String ram;
    String hd;
    String os;
    String vendor;

    @Override
    public String toString() {
        return "RAM: " + ram + ", HD: " + hd + ", OS: " + os + ", Vendor: " + vendor;
    }

    public String getRam(){
        return ram;
    }

    public String getHd(){
        return hd;
    }

    public String getOs(){
        return os;
    }

    public String getVendor(){
        return vendor;
    }
}

