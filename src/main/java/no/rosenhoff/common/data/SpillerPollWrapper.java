package no.rosenhoff.common.data;

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

    private Spiller spiller;

    public SpillerPollWrapper(Poll poll, Spiller spiller) {
        this.poll = poll;
        this.spiller = spiller;
    }

    public Poll getPoll() {
        return poll;
    }

    public Spiller getSpiller() {
        return spiller;
    }
}
