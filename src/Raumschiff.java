import java.util.ArrayList;
import java.util.Random;
public class Raumschiff {
    // Deklarierung
    private int photonentorpedoAnzahl;
    private int energieversorgungInProzent;
    private int schildeInProzent;
    private int huelleInProzent;
    private int lebenserhaltungssystemeInProzent;
    private int androidenAnzahl;
    private String schiffsname;
    private static ArrayList<String> broadcastKommunikator;
    private ArrayList<Ladung> ladungsverzeichnis;
// Initialisierung + Get/Set Methoden
    public Raumschiff() {
        ladungsverzeichnis = new ArrayList<>();
        broadcastKommunikator = new ArrayList<>();
    }
    public Raumschiff(int photonentorpedoAnzahl, int energieversorgungInProzent, int schildeInProzent, int huelleInProzent, int lebenserhaltungssystemeInProzent, int androidenAnzahl, String schiffsname) {
        setphotonentorpedoanzahl(photonentorpedoAnzahl);
        setenergieversorgungInProzent(energieversorgungInProzent);
        setschildeInProzent(schildeInProzent);
        sethuelleInProzent(huelleInProzent);
        setlebenserhaltungssystemeInProzent(lebenserhaltungssystemeInProzent);
        setandroidenAnzahl(androidenAnzahl);
        setschiffsname(schiffsname);
    }
    public void setphotonentorpedoanzahl(int photonentorpedoAnzahl) {
        this.photonentorpedoAnzahl = photonentorpedoAnzahl; }
    public int getPhotonentorpedoAnzahl() { return photonentorpedoAnzahl;}
    public void setenergieversorgungInProzent (int energieversorgungInProzent) {
        this.energieversorgungInProzent = energieversorgungInProzent; }
    public int getenergieversorgungInProzent () { return energieversorgungInProzent;}
    public void setschildeInProzent (int schildeInProzent) {
        this.schildeInProzent = schildeInProzent; }
    public int getschildeInProzent () { return schildeInProzent;}
    public void sethuelleInProzent (int huelleInProzent) {
        this.huelleInProzent = huelleInProzent; }
    public int getHuelleInProzent () { return huelleInProzent;}
    public void setlebenserhaltungssystemeInProzent (int lebenserhaltungssystemeInProzent) {
        this.lebenserhaltungssystemeInProzent = lebenserhaltungssystemeInProzent; }
    public int getLebenserhaltungssystemeInProzent () { return lebenserhaltungssystemeInProzent;}
    public void setandroidenAnzahl (int androidenAnzahl) {
        this.androidenAnzahl = androidenAnzahl; }
    public int getAndroidenAnzahl () { return this.androidenAnzahl;}
    public void setschiffsname (String schiffsname) {
        this.schiffsname = schiffsname; }
    public String getschiffsname () { return this.schiffsname;}
    // Andere Methoden
    public void addLadung(Ladung ladung) {
        ladungsverzeichnis.add(ladung);
    }
    public void photonentorpedoSchiessen (Raumschiff r) {
    if (photonentorpedoAnzahl <= 0) {
        nachrichtAnAlle("-=*Click*=-");
    }
    else {
        photonentorpedoAnzahl--;
        nachrichtAnAlle("Photonentorpedo abgeschossen");
        r.treffer(r);
    }
    }
    public void phaserkanoneschiessen (Raumschiff r) {
        if (energieversorgungInProzent < 50) {
            nachrichtAnAlle("-=*Click*=-");
            return;

        }
        else {
            energieversorgungInProzent = energieversorgungInProzent-50;
            nachrichtAnAlle("Phaserkanone abgeschossen");
            r.treffer(r);
        }
    }
    private void treffer (Raumschiff r) {
    nachrichtAnAlle(r.getschiffsname() + " wurde getroffen!");
    if (this.getschildeInProzent() > 0 ) {
    setschildeInProzent(this.schildeInProzent - 50);
    return; }
    if (getschildeInProzent() <= 0) {
        setenergieversorgungInProzent(r.energieversorgungInProzent - 50);
        return;
    }
    if (getenergieversorgungInProzent() <= 0) {
        nachrichtAnAlle("Lebenserhaltungssysteme vernichtet!");
    }
    }
    public void nachrichtAnAlle (String message) {
        broadcastKommunikator.add(message);
        System.out.println(message);
    }
  public ArrayList<String> eintraegeLogbuchzurueckgeben () {
      return broadcastKommunikator;
    }
public void Photonentorpedosladen (int photonentorpedoAnzahlNeu) {
    if (photonentorpedoAnzahlNeu <= 0) {
        System.out.print("Keine Photonentorpedos gefunden!");
        nachrichtAnAlle("-=*Click*=-");
    } else {
        for (int i = 0; i < ladungsverzeichnis.size(); i++) {
            if (ladungsverzeichnis.get(i).getBezeichnung().equals("Photonentorpedo")) {
                if (ladungsverzeichnis.get(i).getMenge() < photonentorpedoAnzahlNeu) {
                    photonentorpedoAnzahlNeu = ladungsverzeichnis.get(i).getMenge();
                }
                ladungsverzeichnis.get(i).setMenge(ladungsverzeichnis.get(i).getMenge() - photonentorpedoAnzahlNeu);
                setphotonentorpedoanzahl(photonentorpedoAnzahl + photonentorpedoAnzahlNeu);
                System.out.printf("%d Photonentorpedo(s) eingesetzt \n", photonentorpedoAnzahlNeu);
            }
        }
    }
}
public void reparaturdurchfuehren (boolean schutzschilde, boolean energieversorgung, boolean schiffshuelle, int anzahlDroiden) {
        int chance = (int) Math.floor(Math.random() * 100);
        int prozentrepariert;
        int anzahltrue = 0;
        if (androidenAnzahl < anzahlDroiden) {
            anzahlDroiden = androidenAnzahl;
        }
        if(schutzschilde == true) {
            anzahltrue++;
        }
    if(energieversorgung == true) {
        anzahltrue++;
    }
    if(schiffshuelle == true) {
        anzahltrue++;
    }
        prozentrepariert = ((chance * anzahlDroiden) / anzahltrue);
    if(schutzschilde == true) {
        setschildeInProzent(schildeInProzent + prozentrepariert);
    }
    if(energieversorgung == true) {
        setenergieversorgungInProzent(energieversorgungInProzent + prozentrepariert);
    }
    if(schiffshuelle == true) {
        sethuelleInProzent(huelleInProzent + prozentrepariert);
    }
}
public void zustandRaumschiff() {
System.out.println("Schiffsname: " + schiffsname);
System.out.println("Photonentorpedoanzahl: " + photonentorpedoAnzahl);
System.out.println("Energieversorgung: " + energieversorgungInProzent + " %");
System.out.println("Schiffshuelle: " + huelleInProzent + " %");
System.out.println("Lebenserhaltungssysteme: " + lebenserhaltungssystemeInProzent + " %");
System.out.println("Schilde: " + schildeInProzent + " %");
System.out.println("Androiden: " + androidenAnzahl);
}

public static ArrayList<String> eintraegeLogbuchZurueckgeben() {
        return broadcastKommunikator;
}
public void ladungsverzeichnisausgeben () {
    for (int i = 0; i < ladungsverzeichnis.size(); i++) {
        System.out.printf("Eintrag [%d] : %s | Menge: %d\n", i, ladungsverzeichnis.get(i).getBezeichnung(), ladungsverzeichnis.get(i).getMenge());
    }

}
public void ladungsverzeichnisaufraeumen () {
    for (int i = 0; i < ladungsverzeichnis.size(); i++) {
        if (ladungsverzeichnis.get(i).getMenge() == 0) {
            ladungsverzeichnis.remove(i);
        }
    }
}
}














