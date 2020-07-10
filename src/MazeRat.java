import java.util.Scanner;

public class MazeRat {
    public static void printMaze(int N,int [][]maze){
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                System.out.print(maze[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean canEscape(int x,int y,int N,int [][]maze){
        if(maze[N-1][N-1]==0)
            return true;
        if (x<N-1 && maze[x+1][y]==1){
            maze[x+1][y]=0;
            if(canEscape(x+1,y,N,maze)){
                return true;
            }
            else maze[x+1][y]=1;
        }
        if (y<N-1 && maze[x][y+1]==1){
            maze[x][y+1]=0;
            if(canEscape(x,y+1,N,maze)){
                return true;
            }
            else maze[x][y+1]=1;
        }
        return false;
    }
    public static void helpRat(int N,int [][]maze){
        int x=0;
        int y=0;
        maze[x][y]=0;
        if(canEscape(x,y,N,maze)){
            printMaze(N,maze);
        }
        else{
            System.out.println("Rat is trapped");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int maze[][]=new int[N][N];
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                maze[i][j]=sc.nextInt();
            }
        }
        helpRat(N,maze);
    }
}
