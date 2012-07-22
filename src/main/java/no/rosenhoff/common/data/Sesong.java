package no.rosenhoff.common.data;

import java.util.Arrays;
import java.util.List;

public enum Sesong {
    SESONG_2009("2010/2011"), // en liten bug
    SESONG_2011("2011/2012"),
    SESONG_2012("2012/2013");

    private final String displayText;

    Sesong(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    public static List<Sesong> getAllAsList() {
        return Arrays.asList(values());
    }

}
