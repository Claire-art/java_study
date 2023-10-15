public class CharacterType {
    public static void main(String args[])
    {
        char c1 = '한';
        char c2 = '국';
        char c3 ='韓';
        char c4 = '國';

        char c5 = 'K';
        char c6 = '\u004f';
        char c7 = 'R';
        char c8 = '\u0045';
        char c9 = 'A';

        System.out.println("출력 결과: "+c1 +c2 +"("+c3 +c4 +")"+ " = "+c5 + c6 + c7 + c8+ c9);

    }
}
