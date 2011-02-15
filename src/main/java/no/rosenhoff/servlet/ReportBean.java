package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Kamp;
import no.rosenhoff.common.db.Rapport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Nov 13, 2010
 * Time: 10:20:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReportBean extends ManagedBeans {

    private List<KampRapportView> resultater;

    public List<KampRapportView> getResultater() {
        hentResultater();
        return resultater;
    }

    public String hentResultater() {
        menuBean.setActivePage(ActivePageEnum.KAMPRAPPORTER);
        Kamp exampleKamp = new Kamp();
        exampleKamp.setSesong(getMenuBean().getSelectedSesong().name());
        exampleKamp.setLagNavn(getMenuBean().getSelectedLag().name());
        List<Kamp> kamper = kampDAO.findByExample(exampleKamp);
        List<KampRapportView> kampRapportListe = new ArrayList<KampRapportView>();
        for (Kamp kamp : kamper) {
            Rapport rapport = getRapportDAO().findRapportByKamp(kamp,menuBean.getSelectedSesong(), menuBean.getSelectedLag());
            KampRapportView kampRapportView = new KampRapportView(kamp,rapport);
            if (rapport != null) {
                kampRapportListe.add(kampRapportView);
            }
        }
        Collections.sort(kampRapportListe, new KampRapportListeComparator());

        this.resultater = kampRapportListe;

        return "kampRaporter";
    }

}
