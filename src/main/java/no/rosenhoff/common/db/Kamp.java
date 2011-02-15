package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Kamp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "KAMP", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Kamp implements java.io.Serializable {

    // Fields

    private Integer id;
    private String motstander;
    private Date dato;
    private String hjemme;
    private Integer maalScoret;
    private Integer maalSluppetInn;
    private String beskrivelse;
    private String sesong;
    private String lagNavn;

    // Constructors

    /**
     * default constructor
     */
    public Kamp() {
    }

    /**
     * minimal constructor
     */
    public Kamp(String motstander, Date dato, String hjemme,
                Integer maalScoret, Integer maalSluppetInn, String lagNavn) {
        this.motstander = motstander;
        this.dato = dato;
        this.hjemme = hjemme;
        this.maalScoret = maalScoret;
        this.maalSluppetInn = maalSluppetInn;
        this.lagNavn = lagNavn;
    }

    /**
     * full constructor
     */
    public Kamp(String motstander, Date dato, String hjemme,
                Integer maalScoret, Integer maalSluppetInn, String beskrivelse,
                String sesong, String lagNavn) {
        this.motstander = motstander;
        this.dato = dato;
        this.hjemme = hjemme;
        this.maalScoret = maalScoret;
        this.maalSluppetInn = maalSluppetInn;
        this.beskrivelse = beskrivelse;
        this.sesong = sesong;
        this.lagNavn = lagNavn;
    }

    // Property accessors

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "MOTSTANDER", nullable = false, length = 30)
    public String getMotstander() {
        return this.motstander;
    }

    public void setMotstander(String motstander) {
        this.motstander = motstander;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "DATO", nullable = false, length = 8)
    public Date getDato() {
        return this.dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    @Column(name = "HJEMME", nullable = false, length = 10)
    public String getHjemme() {
        return this.hjemme;
    }

    public void setHjemme(String hjemme) {
        this.hjemme = hjemme;
    }

    @Column(name = "MAAL_SCORET", nullable = false)
    public Integer getMaalScoret() {
        return this.maalScoret;
    }

    public void setMaalScoret(Integer maalScoret) {
        this.maalScoret = maalScoret;
    }

    @Column(name = "MAAL_SLUPPET_INN", nullable = false)
    public Integer getMaalSluppetInn() {
        return this.maalSluppetInn;
    }

    public void setMaalSluppetInn(Integer maalSluppetInn) {
        this.maalSluppetInn = maalSluppetInn;
    }

    @Column(name = "BESKRIVELSE", length = 200)
    public String getBeskrivelse() {
        return this.beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    @Column(name = "SESONG", length = 15)
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

}