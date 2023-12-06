class C1 {
    private static int x = 100;
    public static int y = x;
    static int z=x;
    public static int cc() {return x;}
}

class C2 extends C1{
    public static String x;
    static int y;
}

class InheritanceTest3 {
    public static void main(String args[]){
        System.out.println("클래스 메소드 C1.cc()값: " + C1.cc()); //100
        System.out.println("클래스 변수 C1.y값: " + C1.y); //100
        System.out.println("클래스 변수 C1.z값: " + C1.z); //100
        System.out.println("클래스 변수 C2.x값: "+ C2.x); // !!!!null!!!!
        System.out.println("클래스 변수 C2.y: "+C2.y); // ...?왜 0이 나오는거야
        System.out.println("클래스 변수 C2.z"+C2.z); //100
        System.out.println("클래스 메소드 C2.cc() 값: " + C2.cc()); //100

        C2.x = "처음시작하는 자바";
        C2.y = 200;
        C1.z = 300; //C2.z = 300; 도 가능하다.

        System.out.println("클래스 변수 C2.x 값: " + C2.x); // 처음시작하는 자바
        System.out.println("클래스 변수 C2.y 값: " + C2.y); // 200
        System.out.println("클래스 변수 C2.z 값: " + C2.z); // 300
    }
}
