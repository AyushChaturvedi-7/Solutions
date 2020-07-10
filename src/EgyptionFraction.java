public class EgyptionFraction {
    public static void findEgyptionFraction(int nr ,int dr){
        if(nr ==0 || dr ==0) return;
        if(nr%dr==0){
            System.out.println(nr/dr);
            return;
        }
        if (dr%nr==0){
            System.out.println("1/"+dr/nr);
            return;
        }
        if(nr >dr){
            System.out.print(nr/dr+"+");
            nr=nr%dr;
        }
        int temp=dr/nr+1;
        System.out.print("1/"+temp+"+");
        findEgyptionFraction(nr*temp-dr,dr*temp);
    }
    public static void main(String[] args) {
        int nr =12; int dr=13;
        findEgyptionFraction(nr,dr);

    }
}
