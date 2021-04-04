package Oppgave3Lambda;

public class Ansatt {

    private String fn;
    private String en;
    private Kjønn kjønn;
    private String stilling;
    private int aarslønn;

    public Ansatt(String fn, String en, Kjønn kjønn, String stilling, int aarslønn){
        this.fn = fn;
        this.en = en;
        this.kjønn = kjønn;
        this.stilling = stilling;
        this.aarslønn = aarslønn;
    }


    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public Kjønn getKjønn() {
        return kjønn;
    }

    public void setKjønn(Kjønn kjønn) {
        this.kjønn = kjønn;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getAarslønn() {
        return aarslønn;
    }

    public void setAarslønn(int aarslønn) {
        this.aarslønn = aarslønn;
    }
}
