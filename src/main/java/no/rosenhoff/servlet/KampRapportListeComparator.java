package no.rosenhoff.servlet;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Nov 13, 2010
 * Time: 10:44:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class KampRapportListeComparator implements Comparator<KampRapportView> {

    public int compare(KampRapportView kampRapportView1, KampRapportView kampRapportView2) {
        return kampRapportView2.getKamp().getDato().compareTo(kampRapportView1.getKamp().getDato());
    }
}
