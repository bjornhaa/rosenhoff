package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Kamp;
import no.rosenhoff.common.db.Rapport;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Oct 24, 2010
 * Time: 4:00:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdminReportBean extends ManagedBeans {

    private Kamp selectedKamp;

    private Rapport selectedRapport;
    private String selectedText;
    private String selectedTitle;

    public Rapport getSelectedRapport() {
        return selectedRapport;
    }

    public void setSelectedRapport(Rapport selectedRapport) {
        this.selectedRapport = selectedRapport;
        this.selectedTitle = selectedRapport.getOverskrift();
        this.selectedText = selectedRapport.getTekst();
    }

    public Kamp getSelectedKamp() {
        return selectedKamp;
    }

    public void setSelectedKamp(Kamp selectedKamp) {
        selectedTitle = "";
        selectedText = "";
        selectedRapport = null;
        this.selectedKamp = selectedKamp;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }

    public String getSelectedText() {
        return selectedText;
    }

    public void setSelectedTitle(String selectedTitle) {
        this.selectedTitle = selectedTitle;
    }

    public String getSelectedTitle() {
        return selectedTitle;
    }

    public String lagre() {
        if (getSelectedRapport() == null) {
            Rapport rapport = new Rapport();
            rapport.setKamp(getSelectedKamp().getId());
            rapport.setLagNavn(menuBean.getSelectedLag().name());
            rapport.setOverskrift(getSelectedTitle());
            rapport.setSesong(menuBean.getSelectedSesong().name());
            rapport.setTekst(getSelectedText());
            getRapportDAO().save(rapport);

        } else {
            getSelectedRapport().setOverskrift(getSelectedTitle());
            getSelectedRapport().setTekst(getSelectedText());
            getRapportDAO().update(getSelectedRapport());
        }

        return "redigerResultat";
    }
}
