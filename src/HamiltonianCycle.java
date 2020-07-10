public class HamiltonianCycle {
    public static void printPath(int path[]){
        int n=path.length;
        for(int i=0;i<n;i++){
            System.out.print(path[i]+" ");
        }
    }
    public static boolean isSafe(int graph[][],int path[],int pos,int n){
        if(graph[path[pos-1]][path[pos]]==0){ return false;}
        for(int i=0;i<pos;i++){
            if(path[i]==path[pos]){ return false;}
        }
        return true;
    }
    public static boolean nextNode(int graph[][],int path[],int pos,int n){
        if(pos == n)return true;
        for (int i=0;i<n;i++){
            path[pos]=i;
            if(isSafe(graph,path,pos,n)){
                if(nextNode(graph, path, pos+1, n)){return true;}
                else{path[pos]=-1;}
            }
        }
        return false;
    }
    public static void findHamiltonianCircuit(int [][]graph){
        int n=graph.length;
        int[] path= new int[n];
        for(int i=0;i<n;i++){
            path[i]=-1;
        }
            path[0]=0;
            if(nextNode(graph,path,1,n)){ printPath(path); return; }
        System.out.println("no path found");
    }
    public static void main(String[] args) {
        int graph1[][] = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
        };
        findHamiltonianCircuit(graph1);
    }
}
