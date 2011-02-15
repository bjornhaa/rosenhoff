package no.rosenhoff.common.data;

import java.util.Arrays;
import java.util.List;

public enum Posisjon {

    FORWARD("F"),
    BACK("B"),
    KEEPER("K");

    private String kode;

    Posisjon(String kode) {
        this.kode = kode;
    }


    public String getKode() {
        return kode;
    }

    public static List<Posisjon> getAllAsList() {
        return Arrays.asList(Posisjon.values());
    }

    public static Posisjon fromKode(String kode) {
        if (FORWARD.kode.equals(kode)) {
            return FORWARD;
        } else if (BACK.kode.equals(kode)) {
            return BACK;
        } else if (KEEPER.kode.equals(kode)) {
            return KEEPER;
        } else {
            throw new RuntimeException("Kode " + kode + " not found in enum Posisjon");
        }
    }
}
