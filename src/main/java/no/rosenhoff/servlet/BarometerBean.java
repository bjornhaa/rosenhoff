package no.rosenhoff.servlet;

import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.SpillerComparator;
import no.rosenhoff.common.data.SpillerPollWrapper;
import no.rosenhoff.common.data.SpillerPollWrapperComparator;
import no.rosenhoff.common.db.Aktivitet;
import no.rosenhoff.common.db.Poll;
import no.rosenhoff.common.db.PollDAO;
import no.rosenhoff.common.db.Spiller;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jan 15, 2012
 * Time: 11:01:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BarometerBean extends ManagedBeans {

    private Aktivitet selectedAktivitet;

    private List<Spiller> aLagSpillere = new ArrayList<Spiller>();

    private List<Spiller> oldboysSpillere = new ArrayList<Spiller>();

    private List<SpillerPollWrapper> selectedPositivePolls;

    private List<SpillerPollWrapper> selectedNegativePolls;

    private Set<Integer> spillereInPolls = new HashSet<Integer>();

    private Integer selectedSpillerId;

    private SpillerPollWrapper selectedPollLinje;

    public Aktivitet getSelectedAktivitet() {
        return selectedAktivitet;
    }

    public void setSelectedAktivitet(Aktivitet selectedAktivitet) {
        this.selectedAktivitet = selectedAktivitet;
    }


    public String lastBarometer() {
        List<Poll> polls = getPollDAO().findByProperty(PollDAO.AKTIVITET_ID, selectedAktivitet.getId());
        selectedPositivePolls = new ArrayList<SpillerPollWrapper>();
        selectedNegativePolls = new ArrayList<SpillerPollWrapper>();
        spillereInPolls =new HashSet<Integer>();
        for (Poll poll : polls) {
            Spiller spiller = getSpillerDAO().findById(poll.getSpillerId());
            if (poll.isKommer()) {
                selectedPositivePolls.add(new SpillerPollWrapper(poll,spiller));
            } else {
                selectedNegativePolls.add(new SpillerPollWrapper(poll,spiller));
            }
            spillereInPolls.add(spiller.getId());
        }
        Collections.sort(selectedPositivePolls,new SpillerPollWrapperComparator());

        List<Spiller> spillere = getSpillere(Lag.HOCKEY);
        aLagSpillere = new ArrayList<Spiller>();
        Collections.sort(spillere,new SpillerComparator());
        for (Spiller spiller : spillere) {
            if (!spillereInPolls.contains(spiller.getId())) {
                aLagSpillere.add(spiller);
            }
        }

        spillere = getSpillere(Lag.OLDBOYS);
        oldboysSpillere = new ArrayList<Spiller>();
        Collections.sort(spillere,new SpillerComparator());
        for (Spiller spiller : spillere) {
            if (!spillereInPolls.contains(spiller.getId())) {
                oldboysSpillere.add(spiller);
            }
        }

        selectedSpillerId = 0;        
        return "barometer";
    }

    private List<Spiller> getSpillere(Lag lag) {
        Spiller aLagSpiller = new Spiller();
        aLagSpiller.setLagNavn(lag.name());
        aLagSpiller.setSesong(getMenuBean().getSelectedSesong().name());
        return getSpillerDAO().findByExample(aLagSpiller);
    }

    public List<Spiller> getaLagSpillere() {
        return aLagSpillere;
    }

    public List<Spiller> getOldboysSpillere() {
        return oldboysSpillere;
    }

    public List<SpillerPollWrapper> getSelectedPositivePolls() {
        return selectedPositivePolls;
    }

    public List<SpillerPollWrapper> getSelectedNegativePolls() {
        return selectedNegativePolls;
    }

    public String addPositive() {
        if (selectedSpillerId == 0) {
            addInfoMessage("Velg en spiller Œ oppdatere");
            return null;
        }
        Poll poll = new Poll();
        poll.setAktivitetId(getSelectedAktivitet().getId());
        poll.setSpillerId(selectedSpillerId);
        poll.setKommer(true);
        getPollDAO().save(poll);

        return lastBarometer();
    }

    public String addNegative() {
        if (selectedSpillerId == 0) {
            addInfoMessage("Velg en spiller Œ oppdatere");
            return null;
        }
        Poll poll = new Poll();
        poll.setAktivitetId(getSelectedAktivitet().getId());
        poll.setSpillerId(selectedSpillerId);
        poll.setKommer(false);
        getPollDAO().save(poll);

        return lastBarometer();
    }

    public String fjern(){
        getPollDAO().delete(selectedPollLinje.getPoll());

        return lastBarometer();
    }

    public Integer getSelectedSpillerId() {
        return selectedSpillerId;
    }

    public void setSelectedSpillerId(Integer selectedSpillerId) {
        this.selectedSpillerId = selectedSpillerId;
    }

    public SpillerPollWrapper getSelectedPollLinje() {
        return selectedPollLinje;
    }

    public void setSelectedPollLinje(SpillerPollWrapper selectedPollLinje) {
        this.selectedPollLinje = selectedPollLinje;
    }
}
