package no.rosenhoff.common.data;

import java.util.Arrays;
import java.util.List;

public enum Sesong {
    SESONG_2009("2010/2011"), // en liten bug
    SESONG_2011("2011/2012"),
    SESONG_2012("2012/2013"),
    SESONG_2013("2013/2014"),
    SESONG_2014("2014/2015"),
    SESONG_2015("2015/2016"),
    SESONG_2016("2016/2017");

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
