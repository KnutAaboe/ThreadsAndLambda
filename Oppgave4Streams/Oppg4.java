package Oppgave4Streams;

import Oppgave3Lambda.Ansatt;
import Oppgave3Lambda.Kjønn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Oppg4 {

    public static void main(String[] args) {
        List<Ansatt> ansatte = Arrays.asList(
                new Ansatt("Ole", "Bengt", Kjønn.MALE, "Sjef", 1000000),
                new Ansatt("Per", "Gustavson", Kjønn.MALE, "papiransvarlig", 10000),
                new Ansatt("Line", "Borge", Kjønn.FEMALE, "sekretær", 10000),
                new Ansatt("Frank", "Stefsobs", Kjønn.MALE, "programmerer", 950000),
                new Ansatt("Marte", "Hansen", Kjønn.FEMALE, "stolansvarlig", 590000)
        );
        //4a)
        System.out.println("Oppg 4a)");
        List<String> LastNames = ansatte.stream()
                .map(Ansatt::getEn)
                .collect(Collectors.toList());
        LastNames.forEach(System.out::println);

        //4b)
        System.out.println("Oppg 4b)");
        int femaleCount = (int) ansatte.stream()
                .filter(a -> a.getKjønn()==Kjønn.FEMALE).count();
        System.out.println(femaleCount);

        //4c)
        System.out.println("Oppg 4c)");
        int meanMoneyWomen = ansatte.stream()
                .filter(a -> a.getKjønn()==Kjønn.FEMALE)
                .map(Ansatt::getAarslønn)
                .reduce(0, Integer::sum)/femaleCount;
        System.out.println(meanMoneyWomen);

        //4d)
        System.out.println("Oppg 4d)");
        ansatte.stream()
                .filter(a -> a.getStilling().contains("sjef"))
                .forEach(a -> a.setAarslønn( (int) (a.getAarslønn()*1.07) ));
        System.out.println("Lønn justert for sjefer");

        //4e)
        System.out.println("Oppg 4e)");
        boolean noenTjenerMye = ansatte.stream().anyMatch(a -> a.getAarslønn()>=800000);
        System.out.println(noenTjenerMye);


        //4f)
        System.out.println("Oppg 4f)");
        ansatte.stream().map(a -> a.getFn() + " " + a.getEn()).forEach(System.out::println);

        //4g)
        System.out.println("Oppg 4g)");
        int minstelonn = ansatte.stream()
                .min(Comparator.comparingInt(Ansatt::getAarslønn))
                .map(Ansatt::getAarslønn).get();
        List<String> Tjenerminst = ansatte.stream().filter(a -> a.getAarslønn() == minstelonn)
                    .map(a -> a.getFn() + " " + a.getEn() + ": " + a.getAarslønn())
                    .collect(Collectors.toList());
        Tjenerminst.forEach(System.out::println);


        //4h)
        System.out.println("Oppg 4h)");
        int delelig = IntStream.range(1,1000)
                .filter(n -> n%3==0 || n%5==0).reduce(0, Integer::sum);
        System.out.println(delelig);

    }

}
