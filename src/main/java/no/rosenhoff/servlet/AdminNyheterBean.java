package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Nyhet;
import org.apache.log4j.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

public class AdminNyheterBean extends ManagedBeans {

    private Logger log = Logger.getLogger(getClass());


    private List<Nyhet> nyheter;

    private String inputTekst;


    private String overskrift;

    public Nyhet selectedNyhet;


    public Nyhet getSelectedNyhet() {
        return selectedNyhet;
    }

    public void setSelectedNyhet(Nyhet selectedNyhet) {
        this.selectedNyhet = selectedNyhet;
    }

    public String getInputTekst() {
        return inputTekst;
    }

    public void setInputTekst(String inputTekst) {
        this.inputTekst = inputTekst;
    }


    public List<Nyhet> getNyheter() {
        return nyheter;
    }

    public void setNyheter(List<Nyhet> nyheter) {
        this.nyheter = nyheter;
    }


    public String redigerNyheter() {
        log.debug("henter nyheter");
        nyheter = hentNyheter();
        getMenuBean().setActivePage(ActivePageEnum.REDIGER_NYHET);
        return "redigerNyhet";
    }

    private List<Nyhet> hentNyheter() {
        Nyhet exampleNyhet = new Nyhet();
        exampleNyhet.setAktiv(true);
        exampleNyhet.setSesong(getMenuBean().getSelectedSesong().name());
        exampleNyhet.setLagNavn(getMenuBean().getSelectedLag().name());
        return getNyhetDAO().findByExample(exampleNyhet);
    }


    public String lagreNyhet() {
        log.debug("lagrer nyhet ");
        log.debug("med tekst: " + getInputTekst());
        Nyhet nyhet = new Nyhet();
        nyhet.setAktiv(true);
        nyhet.setNyhetTxt(getInputTekst());
        if (getInputTekst().length() > 50) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Teksten er for laaaaang. Maks lengde er 2000 tegn, men du pr¿vde deg med "+getInputTekst().length()));
            log.debug("for lang tekst, skipper lagring");
            return "redigerNyhet";
        }
        nyhet.setTidlagtinn(new Date());
        nyhet.setLagNavn(getMenuBean().getSelectedLag().name());
        nyhet.setSesong(getMenuBean().getSelectedSesong().name());
        nyhet.setOverskrift(getOverskrift());
        getNyhetDAO().save(nyhet);
        nyheter = hentNyheter();
        return "redigerNyhet";
    }

    public String slettNyhet() {
        getNyhetDAO().delete(getSelectedNyhet());
        nyheter = hentNyheter();
        return "redigerNyheter";

    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public String getOverskrift() {
        return overskrift;
    }
}
