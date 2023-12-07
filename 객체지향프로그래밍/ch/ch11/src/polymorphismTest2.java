class Item{
    public int price;
}

class Noodle extends Item{
    public Noodle(){
        price = 2500;
    }

    public String tpString() {return "국수";}

}

class Mixnoodle extends Item{
    public Mixnoodle(){
        price = 3000;
    }

    public String toString() {return "비빔 국수";}
}

class Wodong extends Item{
    public Wodong(){
        price = 2500;
    }
    public String toString() {return "우동";}
}

class Buyer{
    private int money;
    public Buyer(int money){
        this.money = money;
    }

    public void buy(Item it, int count){ // buy 메소드의 매개변수로 Item 클래스형의 객체 선언
        System.out.println(it + "을" + count + "개 맛있게 먹었습니다");
        money = money - it.price * count;
        System.out.println("현재 남은 돈: " + money);
    }
}

public class polymorphismTest2 {

    public static void main(String args[]){
        Buyer me = new Buyer(20000);
        me.buy(new Wodong(), 3);
        me.buy(new Noodle(), 2);
        me.buy(new Mixnoodle(), 2);
    }
}