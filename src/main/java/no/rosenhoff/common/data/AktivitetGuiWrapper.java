package no.rosenhoff.common.data;

import no.rosenhoff.common.db.Aktivitet;
import no.rosenhoff.common.db.AktivitetSted;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 20, 2010
 * Time: 12:31:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class AktivitetGuiWrapper {

    private Aktivitet aktivitet;

    private DateFormat tidsFormater = new SimpleDateFormat("HH:mm");

    private String nyStartTid = "18:00";

    private String nySluttTid = "18:15";

    public AktivitetGuiWrapper(Aktivitet aktivitet) {
        if (aktivitet == null) {
            throw new RuntimeException("kan ikke sette aktivitet til null");
        }
        this.aktivitet = aktivitet;
        if (aktivitet.getNaar() != null) {
            nyStartTid = tidsFormater.format(aktivitet.getNaar());
        }
        if (aktivitet.getFerdig() != null) {
            nySluttTid = tidsFormater.format(aktivitet.getFerdig());
        }

    }

    public String getHvor() {
        if (aktivitet.getAktivitetSted() != null) {
            return aktivitet.getAktivitetSted().getStedsnavn();
        } else {
            return null;
        }
    }

    public void setHvor(String hvor) {
        AktivitetSted aktivitetSted = new AktivitetSted();
        aktivitetSted.setId(new Integer(hvor));
        aktivitet.setAktivitetSted(aktivitetSted);
    }

    public Aktivitet getAktivitet() {
        return aktivitet;
    }

    public void setAktivitet(Aktivitet aktivitet) {
        this.aktivitet = aktivitet;
    }

    public String getNyStartTid() {
        return nyStartTid;
    }

    public String getNySluttTid() {
        return nySluttTid;
    }

    public void setNyStartTid(String nyStartTid) {
        this.nyStartTid = nyStartTid;
    }

    public void setNySluttTid(String nySluttTid) {
        this.nySluttTid = nySluttTid;
    }
}
