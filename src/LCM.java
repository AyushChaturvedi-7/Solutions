public class LCM {
    public static int hcfof2(int a,int b){
     if (a>b){
         int temp =a;
         a=b;
         a=temp;
     }
     if(a==0) return b;
     return hcfof2(b%a,a);
    }
    public static void lcm(int []arr){
        int N=arr.length;
        int ans =arr[0];
        for(int i=1;i<N;i++){
            ans=ans*arr[i]/hcfof2(ans,arr[i]);
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
        int arr[]={2,3,8,17};
        lcm(arr);
    }
}
