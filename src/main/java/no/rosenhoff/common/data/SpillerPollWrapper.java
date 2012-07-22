package no.rosenhoff.common.data;

import no.rosenhoff.common.db.Person;
import no.rosenhoff.common.db.Poll;
import no.rosenhoff.common.db.Spiller;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jan 15, 2012
 * Time: 11:33:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpillerPollWrapper {

    private Poll poll;

    private Person person;

    public SpillerPollWrapper(Poll poll, Person person) {
        this.poll = poll;
        this.person = person;
    }

    public Poll getPoll() {
        return poll;
    }

    public Person getPerson() {
        return person;
    }
}
