import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;




class Main
{


    public static void main(String[] args) {
        List<String > list = new ArrayList<>(10000);
        list.add("a");
         list.add("ab");
        list.sort((a,b)-> b.length()-a.length());
        System.out.println(list);
    }
    }