package no.rosenhoff.servlet;

import no.rosenhoff.common.db.*;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class ManagedBeans {


    protected MenuBean menuBean;

    protected AktivitetDAO aktivitetDAO;

    protected BrukerDAO brukerDAO;

    protected KampDAO kampDAO;

    protected KampSpillerDAO kampSpillerDAO;

    protected NyhetDAO nyhetDAO;

    protected PoengDAO poengDAO;

    protected SpillerDAO spillerDAO;

    protected AktivitetStedDAO aktivitetStedDAO;

    protected RapportDAO rapportDAO;

    protected PollDAO pollDAO;

    protected PersonDAO personDAO;

    protected JDBCDao jdbcDao;


    public AktivitetStedDAO getAktivitetStedDAO() {
        return aktivitetStedDAO;
    }

    public void setAktivitetStedDAO(AktivitetStedDAO aktivitetStedDAO) {
        this.aktivitetStedDAO = aktivitetStedDAO;
    }

    public MenuBean getMenuBean() {
        return menuBean;
    }

    public void setMenuBean(MenuBean menuBean) {
        this.menuBean = menuBean;
    }

    public AktivitetDAO getAktivitetDAO() {
        return aktivitetDAO;
    }

    public void setAktivitetDAO(AktivitetDAO aktivitetDAO) {
        this.aktivitetDAO = aktivitetDAO;
    }

    public BrukerDAO getBrukerDAO() {
        return brukerDAO;
    }

    public void setBrukerDAO(BrukerDAO brukerDAO) {
        this.brukerDAO = brukerDAO;
    }

    public KampDAO getKampDAO() {
        return kampDAO;
    }

    public void setKampDAO(KampDAO kampDAO) {
        this.kampDAO = kampDAO;
    }

    public KampSpillerDAO getKampSpillerDAO() {
        return kampSpillerDAO;
    }

    public void setKampSpillerDAO(KampSpillerDAO kampSpillerDAO) {
        this.kampSpillerDAO = kampSpillerDAO;
    }

    public NyhetDAO getNyhetDAO() {
        return nyhetDAO;
    }

    public void setNyhetDAO(NyhetDAO nyhetDAO) {
        this.nyhetDAO = nyhetDAO;
    }

    public PoengDAO getPoengDAO() {
        return poengDAO;
    }

    public void setPoengDAO(PoengDAO poengDAO) {
        this.poengDAO = poengDAO;
    }

    public SpillerDAO getSpillerDAO() {
        return spillerDAO;
    }

    public void setSpillerDAO(SpillerDAO spillerDAO) {
        this.spillerDAO = spillerDAO;
    }

    protected void addInfoMessage(String messageTxt) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, messageTxt, null));
    }

    public RapportDAO getRapportDAO() {
        return rapportDAO;
    }

    public void setRapportDAO(RapportDAO rapportDAO) {
        this.rapportDAO = rapportDAO;
    }

    public PollDAO getPollDAO() {
        return pollDAO;
    }

    public void setPollDAO(PollDAO pollDAO) {
        this.pollDAO = pollDAO;
    }

    public PersonDAO getPersonDAO() {
        return personDAO;
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void setJdbcDao(JDBCDao jdbcDao) {
        this.jdbcDao = jdbcDao;
    }

    public JDBCDao getJdbcDao() {
        return jdbcDao;
    }
}
