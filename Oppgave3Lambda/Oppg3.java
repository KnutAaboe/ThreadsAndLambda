package Oppgave3Lambda;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Oppg3 {
    public static void main(String[] args) {

        List<Ansatt> ansatte = Arrays.asList(
                new Ansatt("Ole", "Bengt", Kjønn.MALE, "Sjef", 1000000),
                new Ansatt("Per", "Gustavson", Kjønn.MALE, "Ikke Sjef", 900000),
                new Ansatt("Line", "Borge", Kjønn.FEMALE, "Ikke Sjef", 430000),
                new Ansatt("Frank", "Stefsobs", Kjønn.MALE, "Ikke Sjef", 950000),
                new Ansatt("Marte", "Hansen", Kjønn.FEMALE, "Ikke Sjef", 590000)
        );
        Function<Ansatt, Integer> fastTillegg = (Ansatt a) ->  a.getAarslønn()+10;
        Function<Ansatt, Integer> prosentTillegg = (Ansatt a) -> (a.getAarslønn()/100)*(100+10);
        Function<Ansatt, Integer> lavLonnTillegg = (a) -> {
            if(a.getAarslønn()<500000) return fastTillegg.apply(a);
            else return a.getAarslønn();
        };
        Function<Ansatt, Integer> tvilsomTilleg = (Ansatt a) -> {
            if(a.getKjønn()==Kjønn.MALE) return prosentTillegg.apply(a);
            else return a.getAarslønn();
        };

        System.out.println("Tillegg 10kr");
        lonnsoppgjor(ansatte, fastTillegg);
        ansatte.stream().map(a -> "     " + a.getFn() + ": " + a.getAarslønn()).forEach(System.out::println);
        System.out.println("Tillegg 10%");
        lonnsoppgjor(ansatte, prosentTillegg);
        ansatte.stream().map(a -> "     " + a.getFn() + ": " + a.getAarslønn()).forEach(System.out::println);
        System.out.println("Tillegg for <500000, 10kr");
        lonnsoppgjor(ansatte, lavLonnTillegg);
        ansatte.stream().map(a -> "     " + a.getFn() + ": " + a.getAarslønn()).forEach(System.out::println);
        System.out.println("Tillegg for menn, 10%");
        lonnsoppgjor(ansatte, tvilsomTilleg);
        ansatte.stream().map(a -> "     " + a.getFn() + ": " + a.getAarslønn()).forEach(System.out::println);
    }

    private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> br){
        ansatte.forEach(a -> a.setAarslønn(br.apply(a)));
    }

    interface Beregner{
        void oppgjør(Ansatt ansatt, int x);
    }
}
