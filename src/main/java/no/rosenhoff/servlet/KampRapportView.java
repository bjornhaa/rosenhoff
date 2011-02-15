package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Kamp;
import no.rosenhoff.common.db.Rapport;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Oct 24, 2010
 * Time: 3:41:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class KampRapportView {

    private Kamp kamp;

    private Rapport rapport;

    public KampRapportView(Kamp kamp, Rapport rapport) {
        this.kamp = kamp;
        this.rapport = rapport;
    }

    public Kamp getKamp() {
        return kamp;
    }

    public void setKamp(Kamp kamp) {
        this.kamp = kamp;
    }

    public Rapport getRapport() {
        return rapport;
    }

    public void setRapport(Rapport rapport) {
        this.rapport = rapport;
    }
}
