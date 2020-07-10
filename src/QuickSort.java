public class QuickSort {
    public static int partition(int arr[],int l,int r){
        int pivot=arr[r];
        int i=l-1;
        for (int j=l;j<r;j++){
            if (arr[j]<pivot) {
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        i++;
        int temp=arr[i];
        arr[i]=arr[r];
        arr[r]=temp;
        return i;
    }
    public static void  quickSort(int arr[],int l,int r){
        if(l<r){
            int pi=partition(arr,l,r);
            quickSort(arr,l,pi-1);
            quickSort(arr,pi+1,r);
        }
    }
    public static void main(String[] args) {
        int arr[] ={5,10,3,16,17,22,18};
        int l=arr.length;
        quickSort(arr,0,l-1);
        for(int i=0;i<l;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
