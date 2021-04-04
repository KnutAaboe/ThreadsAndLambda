package thread;

public class Writer extends Thread{

    private Person p;
    private Integer pos;
    private String[] nameTab;

    public Writer(Person p, Integer pos, String[] nameTab){
        this.p = p;
        this.pos = pos;
        this.nameTab = nameTab;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (p) {
                p.setName(nameTab[pos%nameTab.length]);
                pos++;
            }

        }
    }
}
