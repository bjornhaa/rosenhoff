package no.rosenhoff.common.data;

import no.rosenhoff.common.db.Spiller;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jan 16, 2012
 * Time: 12:02:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class SpillerComparator implements Comparator<Spiller> {

    public int compare(Spiller spiller1, Spiller spiller2) {
        return spiller1.getNavn().compareTo(spiller2.getNavn()); 
    }
}
