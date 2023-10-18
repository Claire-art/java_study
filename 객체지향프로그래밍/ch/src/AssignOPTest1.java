public class AssignOPTest1 {
    public static void main(String args[]){

        int a = 10;
        System.out.println("a = "+a);

        a += 4; //int a +=4 로 안해도 된다.
        System.out.println("a+=4" +a);

        a %= 4;
        System.out.println(a);

        a <<= 4; // 2를 왼쪽으로 4비트 시프트, 32 출력
        System.out.println(a);

        boolean b = false;
        b &= a > 2;
        System.out.println(b);

        b |= a > 2;
        System.out.println(b);
    }
}
