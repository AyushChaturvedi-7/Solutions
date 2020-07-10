public class SpiralMatrix {
    public static void printSpiralMatrix(int arr[][]){
        int r =0     ,  lc=arr[0].length   ,      c=0    ,      lr=arr.length;
        while (true){
            for (int i=c;i<lc;i++){
                System.out.print(arr[r][i]+" ");
            }
            r+=1;
            if(r>=lr || c>=lc ){break;}
            for (int i=r;i<lr;i++) {
                System.out.print(arr[i][lc-1]+" ");
            }
            lc-=1;
            if(r>=lr || c>=lc){break;}
            for(int i=lc-1;i>=c;i--){
                System.out.print(arr[lr-1][i]+" ");
            }
            lr-=1;
            if(r>=lr || c>=lc){break;}
            for(int i=lr-1;i>=r;i--){
                System.out.print(arr[i][c]+" ");
            }
            c+=1;
            if(r>=lr || c>=lc){break;}
        }
    }

    public static void main(String[] args) {
        int arr[][]={ {1,2,3,4,5},
                            {16,17,18,19,6},
                            {15,24,25,20,7},
                            {14,23,22,21,8},
                            {13,12,11,10,9}};
        int arr2[][]={{1,2,3,4,5,6},
                {14,15,16,17,18,7},
                {13,12,11,10,9,8}};
        int arr3[][]={{1,2,3,},
                            {14,15,4},
                            {13,16,5},
                            {12,17,6},
                            {11,18,7},
                            {10,9,8}};
        int arr4[][]={{1,2,3,4}};
        printSpiralMatrix(arr4);
    }
}
