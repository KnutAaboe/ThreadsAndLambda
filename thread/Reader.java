package thread;

public class Reader extends Thread{

    private Person p;

    public Reader(Person p){
        this.p = p;
    }

    @Override
    public void run() {
        while(true)
            System.out.println(p.getName());
    }
}
