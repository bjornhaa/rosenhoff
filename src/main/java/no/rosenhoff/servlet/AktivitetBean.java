package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Aktivitet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 14, 2010
 * Time: 2:16:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class AktivitetBean extends ManagedBeans {

    private List<Aktivitet> aktiviteter = new ArrayList<Aktivitet>() {
    };

    public List<Aktivitet> getAktiviteter() {
        return aktiviteter;
    }

    public String hent() {
        lastAktiviteter();
        return "aktivitet";
    }

    private void lastAktiviteter() {
        getMenuBean().setActivePage(ActivePageEnum.AKTIVITET);
        aktiviteter = new ArrayList<Aktivitet>();        
        List<Aktivitet> unFilteredaktiviteter = aktivitetDAO.findBySesongLag(menuBean.getSelectedSesong(),menuBean.getSelectedLag());
        Date now = new Date();
        for (Aktivitet aktivitet : unFilteredaktiviteter) {
            if (!aktivitet.getNaar().before(now)) {
                aktiviteter.add(aktivitet);
            }
        }
    }
}