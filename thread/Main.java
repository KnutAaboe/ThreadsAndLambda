package thread;

public class Main{
    public static void main (String[] args) {

        String[] nT = {"Ole", "Per", "Fredrik", "Steffen", "Victor"};
        Integer pos = 0;
        Person p = new Person(nT[0]);

        Writer w1 = new Writer(p, pos, nT);
        Writer w2 = new Writer(p, pos, nT);
        Writer w3 = new Writer(p, pos, nT);
        Writer w4 = new Writer(p, pos, nT);
        Writer w5 = new Writer(p, pos, nT);

        Reader r1 = new Reader(p);
        Reader r2 = new Reader(p);
        Reader r3 = new Reader(p);
        Reader r4 = new Reader(p);
        Reader r5 = new Reader(p);

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();
        w1.start();
        w2.start();
        w3.start();
        w4.start();
        w5.start();

    }

}

