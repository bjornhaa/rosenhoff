package no.rosenhoff.servlet;

import no.rosenhoff.common.data.Lag;
import no.rosenhoff.common.data.SpillerComparator;
import no.rosenhoff.common.data.SpillerPollWrapper;
import no.rosenhoff.common.data.SpillerPollWrapperComparator;
import no.rosenhoff.common.db.*;

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

    private List<Person> personer = new ArrayList<Person>();

    private List<SpillerPollWrapper> selectedPositivePolls;

    private List<SpillerPollWrapper> selectedNegativePolls;

    private Set<Integer> spillereInPolls = new HashSet<Integer>();

    private Integer selectedPersonId;

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
        personer = new ArrayList<Person>();
        spillereInPolls = new HashSet<Integer>();
        for (Poll poll : polls) {
            Person person = personDAO.findById(poll.getPersonId());
            if (poll.isKommer()) {
                selectedPositivePolls.add(new SpillerPollWrapper(poll, person));
            } else {
                selectedNegativePolls.add(new SpillerPollWrapper(poll, person));
            }
            spillereInPolls.add(person.getId());
        }
        Collections.sort(selectedPositivePolls, new SpillerPollWrapperComparator());
        Collections.sort(selectedNegativePolls, new SpillerPollWrapperComparator());

        List<Person> allePersoner = jdbcDao.findPersonAktivDenneSesongen(getMenuBean().getSelectedSesong());
        for (Person person : allePersoner) {
            if (!spillereInPolls.contains(person.getId())) {
                personer.add(person);
            }
        }


        selectedPersonId = 0;
        return "barometer";
    }


    public List<SpillerPollWrapper> getSelectedPositivePolls() {
        return selectedPositivePolls;
    }

    public List<SpillerPollWrapper> getSelectedNegativePolls() {
        return selectedNegativePolls;
    }

    public String addPositive() {
        if (selectedPersonId == 0) {
            addInfoMessage("Velg en spiller Œ oppdatere");
            return null;
        }
        Poll poll = new Poll();
        poll.setAktivitetId(getSelectedAktivitet().getId());
        poll.setPersonId(selectedPersonId);
        poll.setKommer(true);
        getPollDAO().save(poll);

        return lastBarometer();
    }

    public String addNegative() {
        if (selectedPersonId == 0) {
            addInfoMessage("Velg en spiller Œ oppdatere");
            return null;
        }
        Poll poll = new Poll();
        poll.setAktivitetId(getSelectedAktivitet().getId());
        poll.setPersonId(selectedPersonId);
        poll.setKommer(false);
        getPollDAO().save(poll);

        return lastBarometer();
    }

    public String fjern() {
        getPollDAO().delete(selectedPollLinje.getPoll());

        return lastBarometer();
    }

    public Integer getSelectedPersonId() {
        return selectedPersonId;
    }

    public void setSelectedPersonId(Integer selectedPersonId) {
        this.selectedPersonId = selectedPersonId;
    }

    public SpillerPollWrapper getSelectedPollLinje() {
        return selectedPollLinje;
    }

    public void setSelectedPollLinje(SpillerPollWrapper selectedPollLinje) {
        this.selectedPollLinje = selectedPollLinje;
    }

    public List<Person> getPersoner() {
        return personer;
    }
}
