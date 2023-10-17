import java.util.Scanner;

public class ShiftOPTest {
    public static void main(String args[]){
        Scanner stdin = new Scanner(System.in);
        System.out.print("두 개의 숫자를 입력: ");

        int a = stdin.nextInt();  //키보드부터 두 개의 정수를 입력
        int b = stdin.nextInt();

        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));

        //왼쪽으로 2비트 시프트한 결과 출력
        System.out.println((a << 2) + "("+(Integer.toBinaryString(a<<2))); //정수(비트)

        //오른쪽으로 2비트 시프트한 결과 출력
        System.out.println((a>>2)+Integer.toBinaryString(a>>2));

        //왼쪽으로 2비트 시프트한 결과 출력
        System.out.println((b << 2) + "("+(Integer.toBinaryString(b<<2))); //정수(비트)

        //오른쪽으로 2비트 시프트한 결과 출력
        System.out.println((b>>2)+Integer.toBinaryString(b>>2));

        //오른쪽으로 2비트 시프트하면서 빈 곳을 0으로 채운 결과 출력
        System.out.println((b>>>2)+Integer.toBinaryString(b>>>2));
    }
}
