class AAA1{
    public int a;
    public String toString(){ //object 클래스의 toString() 메소드 오버라이딩
        return "AAA1 클래스 객체, 속성 a의 값은: " + a;
    }
}

public class ObjectMethodTest2 {
    public static void main(String args[]){
        AAA1 aa = new AAA1();
        System.out.println(aa);
        System.out.println(aa.toString());
    }
}
