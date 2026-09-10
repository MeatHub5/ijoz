public class huijot {
    public static void main(String[] args) {
        System.out.println("2 na 10 = "+potenca(10));
        System.out.println("7 fib = "+fib(7));
        System.out.println("6 clen naloge 1 je "+naloga1(6));
        System.out.println("5 clen naloge 2 je "+naloga2(5));
        System.out.println("5 clen naloge 3 je "+naloga3(5));
        System.out.println("8 clen naloge 4 je "+naloga4(8));
    }
    public static int naloga1(int b){
        /*a1 = 2 a2 = 2
        an = a n-2*a n-1 – 1/**/
        if (b==1) {
            return 2;
        }
        if (b==2) {
            return 2;
        }
        return naloga1(b-2)*naloga1(b-1)-1;
    }

    public static int naloga2(int a){
        //a1 = 2 
        //a n = 3 * a n-1 + 2 
        if (a==1) {
            return 2;
        }
        return 3*naloga2(a-1)+2;
    }

    public static int naloga3(int c){
        //a1 = 1 a2 = 2 
        //an = a n-1*2 + a n-2
        if (c==1) {
            return 1;
        }
        if (c==2) {
            return 2;
        }
        return naloga3(c-1)*2+naloga3(c-2);
    }

    public static int naloga4(int d){
        //a1 = 1 a2 = 4
        //an= a n-1+2
        if (d==1) {
            return 1;
        }
        if (d==2) {
            return 4;
        }
        return naloga4(d-1)+2;
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
