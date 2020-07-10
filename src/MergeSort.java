public class MergeSort {
    public static void printArray(int arr[]){
        int n=arr.length;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void merge(int arr[],int l,int m,int r){
        int n1 =m-l+1;
        int n2=r-m;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            R[i]=arr[m+i+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<R[j]){
                arr[k]=L[i];
                i+=1;
            }else{
                arr[k]=R[j];
                j+=1;
            }
            k+=1;
        }
        while(i<n1){
            arr[k]=L[i];
            k+=1;
            i+=1;
        }
        while(j<n2){
            arr[k]=R[j];
            k+=1;
            j+=1;
        }
    }
    public static void mergeSort(int []arr,int l,int r){
        if(l<r){
            int m=(l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,35,28,40,56,22};
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
    }
}
