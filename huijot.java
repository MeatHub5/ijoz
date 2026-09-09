public class huijot {
    public static void main(String[] args) {
        System.out.println("2 na 10 = "+potenca(10));
        System.out.println("7 fib = "+fib(7));
    }
    public static int potenca(int n){
        //izracuna 2 na n rekurzivno
        if (n==0)
            return 1;
        return 2*potenca(n-1);
    }
    public static int fib(int f){
        //izracuna f fib stevilo
        if(f==1||f==2)
            return 1;
        return fib(f-1)+fib(f-2);
    }
}
