package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Kamp;
import no.rosenhoff.common.db.Rapport;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminResultatBean extends ManagedBeans {

    private Logger log = Logger.getLogger(getClass());

    private List<KampRapportView> resultater;

    private Kamp selectedKamp;

    private Integer selectedId;

    private final String KONST_HJEMMELAG = "Rosenhoff";

    private String hjemmelag = KONST_HJEMMELAG;

    private String motstander;

    private Integer maal;

    private Integer maalBortelag;

    private String hb;


    private Date selectedDato = new Date();

    private AdminSpillerKampBean adminSpillerKampBean;

    public String getHb() {
        return hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public void setAdminSpillerKampBean(AdminSpillerKampBean adminSpillerKampBean) {
        this.adminSpillerKampBean = adminSpillerKampBean;
    }

    public Kamp getSelectedKamp() {
        return selectedKamp;
    }

    public void setSelectedKamp(Kamp selectedKamp) {
        this.selectedKamp = selectedKamp;
    }


    public String getKONST_HJEMMELAG() {
        return KONST_HJEMMELAG;
    }

    public Integer getMaalBortelag() {
        return maalBortelag;
    }

    public void setMaalBortelag(Integer maalBortelag) {
        this.maalBortelag = maalBortelag;
    }

    public Integer getMaal() {
        return maal;
    }

    public void setMaal(Integer maal) {
        this.maal = maal;
    }

    public Date getSelectedDato() {
        return selectedDato;
    }

    public void setSelectedDato(Date selectedDato) {
        this.selectedDato = selectedDato;
    }

    public String getMotstander() {
        return motstander;
    }

    public void setMotstander(String motstander) {
        this.motstander = motstander;
    }

    public String getHjemmelag() {
        return hjemmelag;
    }

    public void setHjemmelag(String hjemmelag) {
        this.hjemmelag = hjemmelag;
    }

    public Integer getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }

    public List<KampRapportView> getResultater() {
        return resultater;
    }



    public String hentResultater() {
        Kamp exampleKamp = new Kamp();
        exampleKamp.setSesong(getMenuBean().getSelectedSesong().name());
        exampleKamp.setLagNavn(getMenuBean().getSelectedLag().name());
        List<Kamp> kamper = kampDAO.findByExample(exampleKamp);
        List<KampRapportView> kampRapportListe = new ArrayList<KampRapportView>();
        for (Kamp kamp : kamper) {
            Rapport rapport = getRapportDAO().findRapportByKamp(kamp,menuBean.getSelectedSesong(), menuBean.getSelectedLag());
            KampRapportView kampRapportView = new KampRapportView(kamp,rapport);
            kampRapportListe.add(kampRapportView);
        }
        this.resultater = kampRapportListe;

        return "resultater";
    }

    public String redigerResultater() {
        hentResultater();
        getMenuBean().setActivePage(ActivePageEnum.REDIGER_RESULTAT);
        return "redigerResultat";
    }

    public String slettResultat() {
        log.debug("sletter kamp " + getSelectedKamp().getId());
        kampSpillerDAO.deleteByKamp(getSelectedKamp().getId());
        poengDAO.deleteByKamp(getSelectedKamp().getId());
        kampDAO.delete(getSelectedKamp());
        addInfoMessage("Resultat slettet");
        return redigerResultater();
    }

    public String nyResultat() {
        Kamp kamp = new Kamp();
        kamp.setDato(getSelectedDato());
        boolean hjemme = false;
        if (getHb().equals("Hjemme")) {
            hjemme = true;
        }
        if (hjemme) {
            log.debug("lagrer hjemmelag: " + getHjemmelag());
            log.debug("mot motstander: " + getMotstander());
            kamp.setHjemme("Hjemme");
            kamp.setMaalScoret(getMaal());
            kamp.setMaalSluppetInn(getMaalBortelag());
            kamp.setMotstander(getMotstander());
        } else {
            log.debug("lagrer motstander: " + getMotstander());
            log.debug("mot hjemmelag: " + getHjemmelag());
            kamp.setHjemme("Borte");
            kamp.setMaalScoret(getMaal());
            kamp.setMaalSluppetInn(getMaalBortelag());
            kamp.setMotstander(getMotstander());
        }
        kamp.setSesong(getMenuBean().getSelectedSesong().name());
        kamp.setLagNavn(getMenuBean().getSelectedLag().name());
        kampDAO.save(kamp);
        setHjemmelag(KONST_HJEMMELAG);
        setMotstander(null);
        setMaalBortelag(null);
        setMaal(null);
        setSelectedDato(null);
        redigerResultater();
        adminSpillerKampBean.setSelectedKamp(kamp);
        return "spillerKamp";
    }

}
