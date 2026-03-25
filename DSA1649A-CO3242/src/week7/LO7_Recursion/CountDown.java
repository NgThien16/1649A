package week7.LO7_Recursion;

public class CountDown {
    public static void main(String[] args) {
        countUp(5);

    }
    public static void countDown(int n){
        if(n == 0){
            System.out.println("Blast Off!");
            return;
        }
        System.out.println(n);
        countDown(n-1);

    }
    public static void countUp(int n){
        if(n == 0){
            System.out.println("Blast Off!");
            return;
        }
        countUp(n-1);
        System.out.println(n);
    }
}
