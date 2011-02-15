package no.rosenhoff.servlet;

/**
 * Created by IntelliJ IDEA.
 * User: bjornhaa
 * Date: Jul 14, 2010
 * Time: 2:16:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class LinkBeanBean extends ManagedBeans {

    public String hent() {
        getMenuBean().setActivePage(ActivePageEnum.LINKER);
        return "linker";
    }
}