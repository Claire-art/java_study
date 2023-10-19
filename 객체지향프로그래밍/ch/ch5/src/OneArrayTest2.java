public class OneArrayTest2 {
    public static void main(String args[]){
        String slist[] = {"a","b","c","d","e","f","g"};

        System.out.print("원래의 배열: ");

        for(String i: slist)
        System.out.print(i + " ");

        System.out.println();

        for(int i = 0; i < slist.length/2; i++){
            String temp = slist[i];
            slist[i] = slist[slist.length -i -1];
            slist[slist.length -i -1] = temp;
        }

        System.out.println("<역순으로 재배치된 배열>");
        for(String s: slist)
        System.out.print(s + " ");
    }
}
