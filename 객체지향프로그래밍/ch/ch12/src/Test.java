public class Test {
    public static void main(String[] args){
        StringBuffer sb1 = new StringBuffer("abcdefgh");
        StringBuffer sb2 = new StringBuffer(1000);
        System.out.println(sb1.capacity());
        System.out.println(sb2.capacity());
    }
}
