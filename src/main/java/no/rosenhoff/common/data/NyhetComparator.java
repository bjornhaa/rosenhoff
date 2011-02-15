package no.rosenhoff.common.data;

import no.rosenhoff.common.db.Nyhet;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 7, 2010
 * Time: 2:13:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class NyhetComparator implements Comparator<Nyhet> {

    public int compare(Nyhet nyhet1, Nyhet nyhet2) {
        return nyhet2.getTidlagtinn().compareTo(nyhet1.getTidlagtinn());
    }
}
