class Box2 {
    int width = 10;
    int height = 20;
    int depth = 30;
}

public class Box2Test1 {
    public static void main(String args[]){
        int myint1 = 100;
        int myint2 = myint1;
        System.out.println(myint1 + " " + myint2);

        myint1 = 200;
        System.out.println(myint1 + " " + myint2);

        Box2 myBox1 = new Box2();
        Box2 myBox2 = new Box2();
        myBox1.width = 20;
        myBox2.depth = 123;

        Box2 myBox3 = myBox2; //참조 자료형 변수에 다른 참조 자료형 변수를 대입 => 같은 장소를 가리킨다.

        myBox2.width = 1000;
        myBox2.height = 2000;

        System.out.println(myBox3.depth);
        System.out.println(myBox3.height);
        System.out.println(myBox3.width);
    }
}
