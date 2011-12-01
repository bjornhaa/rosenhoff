package no.rosenhoff.servlet;

import no.rosenhoff.common.db.ToppScorererElement;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Oct 17, 2010
 * Time: 11:43:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ToppScorerListeComparator implements Comparator<ToppScorererElement> {

    public int compare(ToppScorererElement o1, ToppScorererElement o2) {
        if (o1.getTotal() > o2.getTotal()) {
            return -1;
        } else if (o1.getTotal() < o2.getTotal()) {
            return 1;
        } else if (o1.getMaal() > o2.getMaal()) {
            return -1;
        } else if (o1.getMaal() < o2.getMaal()) {
            return 1;
        } else if (o1.getPoengPrKamp().intValue() != 0 || o2.getPoengPrKamp().intValue() != 0) {
            return o1.getPoengPrKamp().compareTo(o2.getPoengPrKamp());
        } else {
            return o1.getKamper() - o1.getKamper();
        }

    }
}
