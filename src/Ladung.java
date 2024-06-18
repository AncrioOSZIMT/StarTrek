public class Ladung {
    //Deklarierung
    private String bezeichnung;
    private int menge;
    //Konstruktor
    public Ladung() {}
    public Ladung (String bezeichnung, int menge) {
        setMenge(menge);
        setbezeichnung(bezeichnung);
    }
    //Get+Set Methoden
    public void setbezeichnung (String name) {
        this.bezeichnung = name;
    }
    public String getBezeichnung () {
        return bezeichnung;
    }
    public void setMenge (int Menge) {
        this.menge = Menge;
    }
    public int getMenge () {
        return menge;
    }
    //ToString
    @Override
    public String toString() {
        return "Ladung " +
                "bezeichnung='" + bezeichnung + '\'' +
                ", menge=" + menge + '}';
    }
}
