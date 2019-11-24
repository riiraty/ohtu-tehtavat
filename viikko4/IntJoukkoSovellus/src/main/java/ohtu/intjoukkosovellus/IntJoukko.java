
package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukujono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        lukujono = new int[KAPASITEETTI];
        this.kasvatuskoko = OLETUSKASVATUS;
        alkioidenLkm = 0;
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti < 0) {
            lukujono = new int[0];
        } else {
            lukujono = new int[kapasiteetti];
        }
        
        this.kasvatuskoko = OLETUSKASVATUS;
        alkioidenLkm = 0;
    }
    
    
    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0 ) {
            lukujono = new int[0];  
        } else {
            lukujono = new int[kapasiteetti];
        }
        
        if (kasvatuskoko < 0 ) {
            this.kasvatuskoko = 0;
        } else {
            this.kasvatuskoko = kasvatuskoko;
        }
        
        alkioidenLkm = 0;
        
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            if (lukujono.length - alkioidenLkm == 0) {
                int[] uusi = new int[alkioidenLkm + kasvatuskoko];
                kopioiTaulukko(lukujono, uusi);
                lukujono = uusi;
            }
            lukujono[alkioidenLkm] = luku;
            alkioidenLkm++;
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        boolean kuuluu = false;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukujono[i]) {
                kuuluu = true;
            }
        }
        
        return kuuluu;
    }

    public boolean poista(int luku) {
        boolean poisto = false;
        for (int i = 0; i < alkioidenLkm; i++) {
            if (poisto == false) {
               if (lukujono[i] == luku) {
                    poisto = true;
                    lukujono[i] = 0;
                } 
            } else {
                lukujono[i-1] = lukujono[i];
            }
                
        }
        if (poisto == true) {
            alkioidenLkm--;
            return true;
        }

        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }


    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukujono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukujono[i];
                tuotos += ", ";
            }
            tuotos += lukujono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukujono[i];
        }
        return taulu;
    }
   

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko yhdiste = a;
        int[] bJoukko = b.toIntArray();
        for (int i = 0; i < bJoukko.length; i++) {
            yhdiste.lisaa(bJoukko[i]);
        }
        return yhdiste;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko leikkaus = new IntJoukko();
        int[] aJoukko = a.toIntArray();
        for (int i = 0; i < aJoukko.length; i++) {
            if (b.kuuluu(aJoukko[i])) {
                leikkaus.lisaa(aJoukko[i]);
            }
        }
        return leikkaus;

    }
    
    public static IntJoukko erotus ( IntJoukko a, IntJoukko b) {
        IntJoukko erotus = new IntJoukko();
        int[] aJoukko = a.toIntArray();
        for (int i = 0; i < aJoukko.length; i++) {
            if (!b.kuuluu(aJoukko[i])) {
               erotus.lisaa(aJoukko[i]); 
            } 
        }
        return erotus;
    }
        
}
