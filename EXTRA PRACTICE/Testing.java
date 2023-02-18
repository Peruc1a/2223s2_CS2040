//import java.util.*;

class TestClass {
    public int num1;
    public int num2;
    public TestClass (int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }
    public int getNum() {
        return this.num2;
    }
}
public class Testing {
    public static void main(String[] args) {
        TestClass x = new TestClass(123, 456);
        //Valid operations
        System.out.println(x.num1); //prints 123
        System.out.println(x.getNum()); //prints 456
        //Invalid operations
        System.out.println(x.num2); //compile error
    }
}

