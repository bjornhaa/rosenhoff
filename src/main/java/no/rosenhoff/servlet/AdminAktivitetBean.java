/**
 *
 */
package no.rosenhoff.servlet;

import no.rosenhoff.common.data.AktivitetGuiWrapper;
import no.rosenhoff.common.data.AktivitetStedComparator;
import no.rosenhoff.common.db.Aktivitet;
import no.rosenhoff.common.db.AktivitetSted;
import no.rosenhoff.common.db.Poll;
import no.rosenhoff.common.db.PollDAO;
import org.apache.log4j.Logger;

import javax.faces.model.SelectItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author bjhaak
 */
public class AdminAktivitetBean extends ManagedBeans {


    private Logger log = Logger.getLogger(AdminAktivitetBean.class);

    private List<AktivitetGuiWrapper> aktiviteter = new ArrayList<AktivitetGuiWrapper>();

    private AktivitetGuiWrapper selectedAktivitet = new AktivitetGuiWrapper(new Aktivitet());

    private List<SelectItem> tidsliste;
    private String nySted;

    public AdminAktivitetBean() {
        Calendar time = GregorianCalendar.getInstance();
        time.setTime(new Date());
        time.set(Calendar.HOUR_OF_DAY, 17);
        time.set(Calendar.MINUTE, 0);
        tidsliste = new ArrayList<SelectItem>();
        for (int i = 0; i < 96; i++) {
            DateFormat formatTime = new SimpleDateFormat("HH:mm");
            tidsliste.add(new SelectItem(formatTime.format(time.getTime())));
            time.add(Calendar.MINUTE, 15);
        }
        setTidsliste(tidsliste);
    }

    public AktivitetGuiWrapper getSelectedAktivitet() {
        return selectedAktivitet;
    }

    public void setSelectedAktivitet(AktivitetGuiWrapper selectedAktivitet) {
        this.selectedAktivitet = selectedAktivitet;
    }

    public List<SelectItem> getTidsliste() {
        return tidsliste;
    }

    public void setTidsliste(List<SelectItem> time) {
        this.tidsliste = time;
    }


    public List<AktivitetGuiWrapper> getAktiviteter() {
        return aktiviteter;
    }


    public String redigerAktiviteter() {
        nullStill();
        hentAktiviteter();
        menuBean.setActivePage(ActivePageEnum.REDIGER_AKTIVITET);
        return "redigerAktivitet";

    }

    private void hentAktiviteter() {
        List<Aktivitet> akt = aktivitetDAO.findBySesongLag(menuBean.getSelectedSesong(), menuBean.getSelectedLag());
        aktiviteter = new ArrayList<AktivitetGuiWrapper>();
        for (Aktivitet aktivitet : akt) {
            AktivitetGuiWrapper aktivitetGuiWrapper = new AktivitetGuiWrapper(aktivitet);
            aktiviteter.add(aktivitetGuiWrapper);

        }
    }

    public String slettAktivitet() {

        Aktivitet aktivitet = selectedAktivitet.getAktivitet();
        if (aktivitet.getPoll()) {
            List<Poll> polls = getPollDAO().findByProperty(PollDAO.AKTIVITET_ID, aktivitet);
            for (Poll poll : polls) {
                getPollDAO().delete(poll);
            }
        }

        aktivitetDAO.delete(aktivitet);

        nullStill();
        hentAktiviteter();
        return "redigerAktivitet";
    }

    public String lagreAktivitet() {
        Aktivitet aktivitet = selectedAktivitet.getAktivitet();
        Date dato = aktivitet.getNaar();
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(dato);
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(selectedAktivitet.getNyStartTid().substring(0, 2)));
        cal.set(Calendar.MINUTE, Integer.parseInt(selectedAktivitet.getNyStartTid().substring(3, 5)));
        aktivitet.setNaar(cal.getTime());

        cal.setTime(dato);
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(selectedAktivitet.getNySluttTid().substring(0, 2)));
        cal.set(Calendar.MINUTE, Integer.parseInt(selectedAktivitet.getNySluttTid().substring(3, 5)));
        aktivitet.setFerdig(cal.getTime());

        aktivitet.setLagNavn(menuBean.getSelectedLag().name());
        aktivitet.setSesong(menuBean.getSelectedSesong().name());

        aktivitetDAO.attachDirty(aktivitet);
        List<Poll> oldPolls = getPollDAO().findByProperty(PollDAO.AKTIVITET_ID, aktivitet.getId());
        if (!aktivitet.getPoll()) {
            log.debug("Sletter poll");
            for (Poll poll : oldPolls) {
                getPollDAO().delete(poll);
            }

        }

        nullStill();
        hentAktiviteter();
        return "redigerAktivitet";

    }

    public String cancel() {
        nullStill();
        return "redigerAktivitet";
    }

    private void nullStill() {
        Aktivitet aktivitet = new Aktivitet();
        aktivitet.setPoll(true);
        selectedAktivitet = new AktivitetGuiWrapper(aktivitet);
    }

    public List<SelectItem> getAktivitetSteder() {
        List<AktivitetSted> steder = aktivitetStedDAO.findAll();
        Collections.sort(steder, new AktivitetStedComparator());
        List<SelectItem> aktSteder = new ArrayList<SelectItem>();
        for (AktivitetSted aktivitetSted : steder) {
            aktSteder.add(new SelectItem(aktivitetSted.getId().toString(), aktivitetSted.getStedsnavn()));
        }
        return aktSteder;
    }

    public void setNySted(String nySted) {
        this.nySted = nySted;
        lagreSted();
    }

    public String getNySted() {
        return nySted;
    }

    public String lagreSted() {
        AktivitetSted newSted = new AktivitetSted();
        newSted.setStedsnavn(getNySted());
        aktivitetStedDAO.save(newSted);
        nySted = "";
        return "redigerSpiller";
    }


}
