public class Sudoku{
    public static void printGrid(int grid[][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isSafe(int grid[][],int pos,int value){
        int x=pos/9;
        int y=pos%9;
        for (int i=0;i<9;i++){
            if(grid[x][i]==value)return false;
            if(grid[i][y]==value)return false;
        }
        int t1= (x/3)*3;
        int t2= (y/3)*3;
        for (int i=t1;i<t1+3;i++){
            for(int j=t2;j<t2+3;j++){
                if (grid[i][j]==value)return false;
            }
        }
        return true;
    }
    public static int nextZero(int grid[][],int pos){
        pos++;
        for (int x = pos /9;x<9;x++){
            for (int y=pos %9;y<9;y++){
                if(grid[x][y]==0) return pos;
                pos++;
            }
        }
        return -1;
    }
    public static boolean sudokuUtil(int grid[][],int pos){
        int p =nextZero(grid,pos);
        if(p==-1){return true;}
        int x=p/9;
        int y =p%9;
        for(int i=1;i<=9;i++){
            if(isSafe(grid,p,i)){
                grid[x][y]=i;
                if(sudokuUtil(grid, p)){return true;}
                else{grid[x][y]=0;}
            }
        }
        return false;
    }
    public static void solveSudoku(int grid[][]){
        if(sudokuUtil(grid,-1)){printGrid(grid);}
        else{
            System.out.println("no possible solution");
        }
    }
    public static void main(String[] args) {
        int[][] board = new int[][] {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
        int grid[][] = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 },
                                { 5, 2, 9, 1, 3, 4, 7, 6, 8 },
                                { 4, 8, 7, 6, 2, 9, 5, 3, 1 },
                                { 2, 6, 3, 0, 1, 5, 9, 8, 7 },
                                { 9, 7, 4, 8, 6, 0, 1, 2, 5 },
                                { 8, 5, 1, 7, 9, 2, 6, 4, 3 },
                                { 1, 3, 8, 0, 4, 7, 2, 0, 6 },
                                { 6, 9, 2, 3, 5, 1, 8, 7, 4 },
                                { 7, 4, 5, 0, 8, 6, 3, 1, 0 } };
        int zeros[][]={{0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0}};
        solveSudoku(zeros);
    }
}