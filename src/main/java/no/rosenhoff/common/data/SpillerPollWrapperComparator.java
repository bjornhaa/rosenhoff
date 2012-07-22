package no.rosenhoff.common.data;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jan 16, 2012
 * Time: 12:56:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpillerPollWrapperComparator implements Comparator<SpillerPollWrapper> {

    public int compare(SpillerPollWrapper spilerPoll1, SpillerPollWrapper spillerPoll2) {
        return spilerPoll1.getPerson().getNavn().toLowerCase().compareTo(spillerPoll2.getPerson().getNavn().toLowerCase());

    }
}
