public class MultiArrayTest2 {
    public static void main(String args[]){
        int twoD[][] = new int[4][];
        twoD[0] = new int[1]; // [0]
        twoD[1] = new int[2]; // [0] [0]
        twoD[2] = new int[3]; // [0] [0] [0]
        twoD[3] = new int[4]; // [0] [0] [0] [0]

        // System.out.println(twoD[0]);
        // System.out.println(twoD[0][0]);
        // System.out.println(twoD.length);
        // System.out.println(twoD[1].length);
        int i, j, k = 0;

        for(i = 0; i<twoD.length; i++){
            for(j=0; j<twoD[i].length; j++){
                twoD[i][j] = k;
                k++;
            }
            //k = 0;
        }

        for(i=0; i < twoD.length; i++){
            for(int val: twoD[i])
                System.out.print(val + " ");
            System.out.println();
        }
    }
}
