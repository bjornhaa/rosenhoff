package no.rosenhoff.servlet;

import no.rosenhoff.common.db.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ForsideBean extends ManagedBeans {

    private Logger log = Logger.getLogger(getClass());


    private List<no.rosenhoff.common.db.Nyhet> nyheter;


    public int getAntPositive() {
        List<Poll> polls = getSelectedPolls();
        int antPositive = 0;
        for (Poll poll : polls) {
            if (poll.isKommer()) {
                antPositive++;
            }
        }
        return antPositive;
    }

    public int getAntNegative() {
        List<Poll> polls = getSelectedPolls();
        int antNegative = 0;
        for (Poll poll : polls) {
            if (poll.isKommer() == false) {
                antNegative++;
            }
        }
        return antNegative;
    }

    public List<Poll> getSelectedPolls() {
        Aktivitet nesteAktivitet = getNesteAktivitet();
        List<Poll> polls = new ArrayList<Poll>();
        if (nesteAktivitet != null) {
            polls = getPollDAO().findByProperty(PollDAO.AKTIVITET_ID, nesteAktivitet.getId());
        }
        return polls;
    }


    public List<Nyhet> getNyheter() {
        hentNyheter();
        return nyheter;
    }

    private void hentNyheter() {
        nyheter = new ArrayList<Nyhet>();
        Nyhet exampleNyhet = new Nyhet();
        exampleNyhet.setAktiv(true);
        exampleNyhet.setSesong(getMenuBean().getSelectedSesong().name());
        exampleNyhet.setLagNavn(getMenuBean().getSelectedLag().name());
        nyheter = nyhetDAO.findByExample(exampleNyhet);
    }

    public Aktivitet getNesteAktivitet() {
        return getAktivitetDAO().findNextActivity(getMenuBean().getSelectedSesong(), getMenuBean().getSelectedLag());
    }


}
