public class Main{

    public static int add(int a, int b){
        return a+b;
    }

    public static int add(int a,int b,int x){
        return a+b+x;
    }

    public static int add(int a,int b,int c,int d){
        return a+b+c+d;
    }
    public static void main(String[] args){
        System.out.println(add(1,2));
        System.out.println(add(1,2,3));
        System.out.println(add(1,2,3,4));
    }

}