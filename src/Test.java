public class Test {
    public static void main(String[] args) {
     //Initialisierung
 Ladung l1 = new Ladung("Ferengi Schneckensaft", 200);
 Ladung l2 = new Ladung("Borg-Schrott", 5);
 Ladung l3 = new Ladung("Rote Materie", 2);
 Ladung l4 = new Ladung("Forschungssonde", 35);
 Ladung l5 = new Ladung("Bat'leth Klingonen Schwert", 200);
 Ladung l6 = new Ladung("Plasma-Waffe",50);
 Ladung l7 = new Ladung("Photonentorpedo", 3);
 Raumschiff klingonen = new Raumschiff();
 klingonen.setphotonentorpedoanzahl(1);
 klingonen.setenergieversorgungInProzent(100);
 klingonen.setschildeInProzent(100);
 klingonen.sethuelleInProzent(100);
 klingonen.setlebenserhaltungssystemeInProzent(100);
 klingonen.setandroidenAnzahl(2);
 klingonen.setschiffsname("IKS Hegh'ta");
 klingonen.addLadung(l1);
 klingonen.addLadung(l5);
 Raumschiff romulaner = new Raumschiff();
 romulaner.setphotonentorpedoanzahl(2);
 romulaner.setenergieversorgungInProzent(100);
 romulaner.setschildeInProzent(100);
 romulaner.sethuelleInProzent(100);
 romulaner.setlebenserhaltungssystemeInProzent(100);
 romulaner.setandroidenAnzahl(2);
 romulaner.setschiffsname("IRW Khazara");
 romulaner.addLadung(l2);
 romulaner.addLadung(l3);
 romulaner.addLadung(l6);
 Raumschiff vulkanier = new Raumschiff();
 vulkanier.setphotonentorpedoanzahl(0);
 vulkanier.setenergieversorgungInProzent(80);
 vulkanier.setschildeInProzent(80);
 vulkanier.sethuelleInProzent(50);
 vulkanier.setlebenserhaltungssystemeInProzent(100);
 vulkanier.setandroidenAnzahl(5);
 vulkanier.setschiffsname("Ni'Var");
 vulkanier.addLadung(l4);
 vulkanier.addLadung(l7);
 //Beginn
 klingonen.photonentorpedoSchiessen(romulaner);
 romulaner.phaserkanoneschiessen(klingonen);
 vulkanier.nachrichtAnAlle("Gewalt ist nicht logisch");
 klingonen.zustandRaumschiff();
 klingonen.ladungsverzeichnisausgeben();
 vulkanier.reparaturdurchfuehren(true,true,true, vulkanier.getAndroidenAnzahl());
 vulkanier.Photonentorpedosladen(l7.getMenge());
vulkanier.ladungsverzeichnisaufraeumen();
klingonen.photonentorpedoSchiessen(romulaner);
klingonen.photonentorpedoSchiessen(romulaner);
klingonen.zustandRaumschiff();
romulaner.zustandRaumschiff();
vulkanier.zustandRaumschiff();
System.out.println("Klingonenladungsverzeichnis: ");
klingonen.ladungsverzeichnisausgeben();
System.out.println("Romulanerladungsverzeichnis: ");
romulaner.ladungsverzeichnisausgeben();
System.out.println("Vulkanierladungsverzeichnis: ");
vulkanier.ladungsverzeichnisausgeben();
System.out.print(Raumschiff.eintraegeLogbuchZurueckgeben());
}
}

