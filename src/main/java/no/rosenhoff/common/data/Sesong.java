package no.rosenhoff.common.data;

public enum Sesong {
    SESONG_2008("2008/2009")
    , SESONG_2009("2010/2011") // en liten bug
    , SESONG_2011("2011/2012")
    , SESONG_2012("2012/2013")
    , SESONG_2013("2013/2014");

    private final String displayText;

    Sesong(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
