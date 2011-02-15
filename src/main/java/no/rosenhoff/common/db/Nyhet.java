package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Nyhet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "NYHET", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Nyhet implements java.io.Serializable {

    // Fields

    private Integer nyhetId;
    private String nyhetTxt;
    private boolean aktiv;
    private Date tidlagtinn;
    private String sesong;
    private String lagNavn;
    private String overskrift;

    // Constructors

    /**
     * default constructor
     */
    public Nyhet() {
    }

    /**
     * minimal constructor
     */
    public Nyhet(String nyhetTxt, boolean aktiv, String sesong, String lagNavn,
                 String overskrift) {
        this.nyhetTxt = nyhetTxt;
        this.aktiv = aktiv;
        this.sesong = sesong;
        this.lagNavn = lagNavn;
        this.overskrift = overskrift;
    }

    /**
     * full constructor
     */
    public Nyhet(String nyhetTxt, boolean aktiv, Date tidlagtinn,
                 String sesong, String lagNavn, String overskrift) {
        this.nyhetTxt = nyhetTxt;
        this.aktiv = aktiv;
        this.tidlagtinn = tidlagtinn;
        this.sesong = sesong;
        this.lagNavn = lagNavn;
        this.overskrift = overskrift;
    }

    // Property accessors

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "NYHET_ID", unique = true, nullable = false)
    public Integer getNyhetId() {
        return this.nyhetId;
    }

    public void setNyhetId(Integer nyhetId) {
        this.nyhetId = nyhetId;
    }

    @Column(name = "NYHET_TXT", nullable = false, length = 2000)
    public String getNyhetTxt() {
        return this.nyhetTxt;
    }

    public void setNyhetTxt(String nyhetTxt) {
        this.nyhetTxt = nyhetTxt;
    }

    @Column(name = "AKTIV", nullable = false)
    public boolean getAktiv() {
        return this.aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    @Column(name = "TIDLAGTINN", length = 23)
    public Date getTidlagtinn() {
        return this.tidlagtinn;
    }

    public void setTidlagtinn(Date tidlagtinn) {
        this.tidlagtinn = tidlagtinn;
    }

    @Column(name = "SESONG", nullable = false, length = 15)
    public String getSesong() {
        return this.sesong;
    }

    public void setSesong(String sesong) {
        this.sesong = sesong;
    }

    @Column(name = "LAG_NAVN", nullable = false, length = 10)
    public String getLagNavn() {
        return this.lagNavn;
    }

    public void setLagNavn(String lagNavn) {
        this.lagNavn = lagNavn;
    }

    @Column(name = "OVERSKRIFT", nullable = false, length = 100)
    public String getOverskrift() {
        return this.overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
	}

}