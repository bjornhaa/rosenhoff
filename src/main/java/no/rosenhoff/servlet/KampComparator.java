package no.rosenhoff.servlet;

import no.rosenhoff.common.db.Kamp;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Oct 19, 2010
 * Time: 12:32:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class KampComparator implements Comparator<Kamp> {

    public int compare(Kamp o1, Kamp o2) {
        return o1.getDato().compareTo(o2.getDato());
    }
}
