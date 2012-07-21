package no.rosenhoff.common.db;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 21, 2012
 * Time: 10:12:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class PersonAsSpiller {

    private final Person person;

    private final boolean spiller;

    private final boolean kamper;

    private final Integer spillerId;

    public PersonAsSpiller(Person person, boolean spiller, boolean kamper, Integer spillerId) {
        this.person = person;
        this.spiller = spiller;
        this.kamper = kamper;
        this.spillerId = spillerId;
    }

    public Person getPerson() {
        return person;
    }

    public boolean isSpiller() {
        return spiller;
    }

    public boolean isKamper() {
        return kamper;
    }

    public Integer getSpillerId() {
        return spillerId;
    }
}
