package no.rosenhoff.servlet;

import no.rosenhoff.common.db.*;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class ForsideBean extends ManagedBeans {

    private Logger log = Logger.getLogger(getClass());


    private List<no.rosenhoff.common.db.Nyhet> nyheter;

    private Integer positiveAdjust = 0;
    private Integer negativeAdjust = 0;

    public Integer getNegativeAdjust() {
        return negativeAdjust;
    }

    public void setNegativeAdjust(Integer negativeAdjust) {
        this.negativeAdjust = negativeAdjust;
    }

    private Poll selectedPoll;

    public Poll getSelectedPoll() {
        Aktivitet nesteAktivitet = getNesteAktivitet();
        List<Poll> polls = getPollDAO().findByProperty(PollDAO.AKTIVITET_ID, nesteAktivitet.getId());
        if (polls.size() != 1) {
            throw new RuntimeException("Feil antall polls. Var "+polls.size());
        }
        return polls.get(0);
    }

    public Integer getPositiveAdjust() {
        return positiveAdjust;
    }

    public void setPositiveAdjust(Integer positiveAdjust) {
        this.positiveAdjust = positiveAdjust;
    }

    public String changeVote() {
        Aktivitet nesteAktivitet = getNesteAktivitet();
        List<Poll> polls = getPollDAO().findByProperty(PollDAO.AKTIVITET_ID, nesteAktivitet.getId());
        Poll poll = polls.get(0);
        poll.setAntPositive(poll.getAntPositive()+ positiveAdjust);
        if (poll.getAntPositive() < 0) {
            poll.setAntPositive(0);
        }
        poll.setAntNegative(poll.getAntNegative()+negativeAdjust);
        if (poll.getAntNegative() < 0) {
            poll.setAntNegative(0);
        }


        getPollDAO().attachDirty(poll);

        return null;
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
        return getAktivitetDAO().findNextActivity(getMenuBean().getSelectedSesong(),getMenuBean().getSelectedLag());
    }


}
