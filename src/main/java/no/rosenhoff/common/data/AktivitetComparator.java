package no.rosenhoff.common.data;

import no.rosenhoff.common.db.Aktivitet;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Mar 22, 2010
 * Time: 11:55:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class AktivitetComparator implements Comparator<Aktivitet> {

    public int compare(Aktivitet object, Aktivitet object1) {
        return object.getNaar().compareTo(object1.getNaar());
    }
}
