public class KnightsTour {
    //working fine for values upto N=6 execution time is too long for higher values
    static int N=6;
    public static void printSolution(int [][]sol){
        //System.out.println("5");
        for(int i=0;i<N;i++){
            for(int j=0; j<N;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int x,int y,int sol[][]){
        //System.out.println("4");
        if(x>=0 && x<N && y>=0 && y<N && sol[x][y]==-1)return true;
        return false;
    }
    public static boolean possibleSolution(int x,int  y,int move_no,int x_move[],int y_move[],int sol[][]){
        //System.out.println("3");
        //printSolution(sol);
        //System.out.println();
        //System.out.println();
        if(move_no==N*N){
            return true;
        }
        for(int i=0;i<8;i++){
            int x_value=x+x_move[i];
            int y_value=y+y_move[i];
            if (isSafe(x_value,y_value,sol)){
                sol[x_value][y_value]=move_no;
                if(possibleSolution(x_value,y_value,move_no+1,x_move,y_move,sol)){
                    return true;}
                else{
                    sol[x_value][y_value]=-1;
                }
            }
        }
        return false;
    }
    public static void solveKT(){
        //System.out.println("2");
        int sol[][]=new int[N][N];
        int x_move[]={2,2,1,-1,-2,-2,1,-1};
        int y_move[]={1,-1,2,2,1,-1,-2,-2};
        int move_no=0;
        for(int i=0;i<N;i++){
            for(int j=0; j<N;j++){
                sol[i][j]=-1;
            }
        }
        sol[0][0]=0;
        move_no+=1;
        if(possibleSolution(0,0, move_no,x_move,y_move,sol)){
            printSolution(sol);
            return;
        }
        else{
            System.out.println("not possible");
            return;
        }
    }
    public static void main(String[]args){
        //System.out.println("1");
        solveKT();
    }
}
