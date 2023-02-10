import java.util.*;

public class HelloWorld {
    public static int gcd(int e, int f) {
        int rem;
        while (f > 0) {
            rem = e%f;
            e = f;
            f = rem;
        }
        return e;
    }
    public static void main(String[] args) {
        int a,b,c,d,newNum,newDenom, divisor;
        Scanner xyz = new Scanner(System.in);
        System.out.println("Enter the 2 Fractions to be added: ");

        a = xyz.nextInt();
        b = xyz.nextInt();
        c = xyz.nextInt();
        d = xyz.nextInt();
        
        newNum = a*d+b*c;
        newDenom = b*d;

        divisor = gcd(newNum,newDenom);

        newNum /= divisor;
        newDenom /= divisor;
        System.out.println("Your new fraction is: " + newNum + "/" + newDenom);
        xyz.close();
    }
}