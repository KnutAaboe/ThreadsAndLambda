package Oppgave2Lambda;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args){

        //2a)
        List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
        //System.out.println(listen);
        Collections.sort( listen, (String e1, String e2) -> (Integer.parseInt(e1) - (Integer.parseInt(e2)) ) );
        //System.out.println(listen);

        //2b)
        BiFunction<Integer,Integer,Integer> distance = (n1, n2) -> Math.abs(n1-n2);
        BiFunction<Integer,Integer,Integer> biggest = Math::max;
        BiFunction<Integer,Integer,Integer> sum = Integer::sum;

        System.out.println(beregn(12, 13, sum));
        System.out.println(beregn(-5, 3, biggest));
        System.out.println(beregn(54, 45, distance));
    }
    public static int beregn(int n1, int n2, BiFunction<Integer,Integer,Integer> computer) {
        return computer.apply(n1, n2);
    }


}
