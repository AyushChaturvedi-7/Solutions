import java.util.Arrays;

public class SubsetSum {
    public static void printSubset(int arr[]){
        System.out.print("{");
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                System.out.print(arr[i]+" ");
            }
        }
        System.out.print("} ");
    }
    public static int checkSum(int arr[]){
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    public static boolean nextSubset(int arr[],int n ,int k,int sub[] ,int i){
        int sum=0;
        for(;i<n;i++){
            sub[i]=arr[i];
            sum=checkSum(sub);
            if(sum==k){
                printSubset(sub);
                sub[i]=0;
            }else if (sum>k){
                sub[i]=0;
                return false;
            }else {
                if(!nextSubset(arr, n, k, sub, i+1)){sub[i]=0;}
            }
        }
        return false;
    }
    public static void findSubsets(int []arr,int n,int k){
        int i=0;
        int sub[]=new int[n];
        int sum=0;
        for( i=0;i<n;i++){
            sub[i]=arr[i];
            sum=checkSum(sub);
            if(sum==k){
                printSubset(sub);
                break;
            }else if(sum>k){
                break;
            }else{
                if(nextSubset(arr,n,k,sub,i+1)){}
            }
            sub[i]=0;
        }
    }
    public static void main(String[] args) {
        int arr[]={15, 22, 14, 26, 32, 9, 16, 8};
        int n=arr.length;
        int k=53;
        Arrays.sort(arr);
        findSubsets(arr,n,k);

    }
}

