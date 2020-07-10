import java.util.Scanner;

public class NQueenProblem {
    public static void printSol(int[][]sol,int N){
        for (int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int [][]sol,int x,int y,int N){
        for (int i=x-1;i>=0;i--) {
            if(sol[i][y]==1)return false;
            if((y+i-x)>=0 && sol[i][y+i-x]==1)return false;
            if((y-i+x)<N && sol[i][y-i+x]==1)return false;
        }
        return true;
    }
    public static boolean nextStep(int [][]sol,int x,int N){
        if (x==N)return true;
        for(int y=0;y<N;y++){
            if (isSafe(sol,x,y,N)){
             sol[x][y]=1;
             if(nextStep(sol,x+1,N)){return true;}
             else sol[x][y]=0;
            }
        }
        return false;
    }
    public static void solveNQueen(int N){
        int [][] sol=new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sol[i][j]=0;
            }
        }
        for(int x=0;x<N;x++){
            if(nextStep(sol,x,N)){
                printSol(sol,N);
                return;
            }
        }
        System.out.println("Not possible ");
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N=sc.nextInt();
        solveNQueen(N);
    }
}
