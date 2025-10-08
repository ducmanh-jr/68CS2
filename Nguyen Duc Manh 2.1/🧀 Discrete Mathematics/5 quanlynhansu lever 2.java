
class NV {
    private String a1; // a1 = ten
    private String a2; // a2 = ma so
    private String a3; // a3 = ngay thue

    public NV(String a1, String a2, String a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public String geta1() {
        return a1;
    }

    public String geta2() {
        return a2;
    }

    public String geta3() {
        return a3;
    }
}

class PW extends NV {
    private int a4; // a4 = ca lam viec
    private double a5; // a5 = luong 1 gio

    public PW(String a1, String a2, String a3, int a4, double a5) {
        super(a1, a2, a3);
        this.a4 = a4;
        this.a5 = a5;
    }

    public int geta4() {
        return a4;
    }

    public double geta5() {
        return a5;
    }

}

public class Main {

    public static void main(String[] args) {
        PW nv = new PW("Nguyen Duc Manh", "000-k", "01/3/2023", 1, 1220);
        System.out.println("Ten            :  " + nv.geta1());
        System.out.println("Ma so          :  " + nv.geta2());
        System.out.println("Ngay thue      :  " + nv.geta3());
        System.out.println("Ca lam viec    :  " + nv.geta4());
        System.out.println("Luong hang gio :  " + nv.geta5());
    }
}
