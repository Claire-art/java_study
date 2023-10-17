public class BitOPTest1 {
    public static void main(String args[])
    {
        int a = 14;
        int b = 11; //14에 대한 2진 표현
        System.out.println(" a="+a+"("+Integer.toBinaryString(a)+")"); //정수를 비트 단위로 출력하는 라이브러리 메소드
        System.out.println(Integer.toBinaryString(b));

        //14와 11의 비트 단위의 AND 결과 출력
        System.out.println(Integer.toBinaryString(a&b));

        //14와 11의 비트 단위의 OR 결과 출력
        System.out.println(Integer.toBinaryString(a|b));

        //14와 11의 비트 단위의 XOR 결과 출력
        System.out.println(Integer.toBinaryString(a^b));

        //b의 보수 출력
        System.out.println(Integer.toBinaryString(~b));
    }
}
