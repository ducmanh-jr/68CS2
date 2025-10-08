class NV {
    private String a1;
    private String a2;
    private String a3;

    public NV(String a1, String a2, String a3) {

        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public String aa1() {
        return a1;
    }

    public String aa2() {
        return a2;
    }

    public String aa3() {
        return a3;
    }
}

class PW extends NV {
    private int a4;
    private double a5;

    public PW(String a1, String a2, String a3, int a4, double a5) {
        super(a1, a2, a3, a4);
        this.a4 = a4;
        this.a5 = a5;
    }

    public int aa4() {
        return a4;
    }

    public double aa5() {
        return a5;
    }
}

class TL extends PW {
    private double a6;
    private int a7;
    private int a8;

    public TL(String a1, String a2, String a3, int a4, double a5, double a6, int a7, int a8) {
        super(a1, a2, a3, a4, a5);
        this.a6 = a6;
        this.a7 = a7;
        this.a8 = a8;
    }

    public double aa6() {
        return a6;
    }

    public int aa7() {
        return a7;
    }

    public int aa8() {
        return a8;
    }
}

public class Main {
    public static void main(String[] args) {
        TL tl = new TL("nguyen duc manh", "000-K", "01/11/1111", 1, 1111, 111111, 111, 11111);
        System.out.println("fff" + tl.aa1());
        System.out.println("fff" + tl.aa2());
        System.out.println("fff" + tl.aa3());
        System.out.println("fff" + tl.aa4());
        System.out.println("fff" + tl.aa5());
        System.out.println("fff" + tl.aa6());
        System.out.println("fff" + tl.aa7());
        System.out.println("fff" + tl.aa8());

    }
}