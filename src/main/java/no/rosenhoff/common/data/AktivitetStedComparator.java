package no.rosenhoff.common.data;

import no.rosenhoff.common.db.AktivitetSted;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 21, 2010
 * Time: 5:06:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class AktivitetStedComparator implements Comparator {
    public int compare(Object o, Object o1) {
        AktivitetSted sted1 = (AktivitetSted) o;
        AktivitetSted sted2 = (AktivitetSted) o1;
        return sted1.getStedsnavn().compareToIgnoreCase(sted2.getStedsnavn());

    }
}
