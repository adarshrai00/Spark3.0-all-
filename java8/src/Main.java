import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<String> pre=x->x.charAt(0)=='a';
        Predicate<String> pree=x->x.charAt(x.length()-1)=='a';
        Predicate<String>c= pre.and(pree);
        System.out.println(c.test("adarsh"));


    }
}