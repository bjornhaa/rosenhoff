package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Poeng entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "POENG", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Poeng implements java.io.Serializable {

    // Fields

    private Integer id;
    private Integer spiller;
    private boolean erpass;
    private String sesong;
    private String lagNavn;
    private Integer kampId;
    private Integer antPoeng;

    // Constructors

    /**
     * default constructor
     */
    public Poeng() {
    }

    /**
     * minimal constructor
     */
    public Poeng(Integer spiller, String lagNavn, Integer kampId,
                 Integer antPoeng) {
        this.spiller = spiller;
        this.lagNavn = lagNavn;
        this.kampId = kampId;
        this.antPoeng = antPoeng;
    }

    /**
     * full constructor
     */
    public Poeng(Integer spiller, boolean erpass, String sesong,
                 String lagNavn, Integer kampId, Integer antPoeng) {
        this.spiller = spiller;
        this.erpass = erpass;
        this.sesong = sesong;
        this.lagNavn = lagNavn;
        this.kampId = kampId;
        this.antPoeng = antPoeng;
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

    @Column(name = "SPILLER", nullable = false)
    public Integer getSpiller() {
        return this.spiller;
    }

    public void setSpiller(Integer spiller) {
        this.spiller = spiller;
    }

    @Column(name = "ERPASS")
    public boolean getErpass() {
        return this.erpass;
    }

    public void setErpass(boolean erpass) {
        this.erpass = erpass;
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

    @Column(name = "kamp_id", nullable = false)
    public Integer getKampId() {
        return this.kampId;
    }

    public void setKampId(Integer kampId) {
        this.kampId = kampId;
    }

    @Column(name = "ant_poeng", nullable = false)
    public Integer getAntPoeng() {
        return this.antPoeng;
    }

    public void setAntPoeng(Integer antPoeng) {
        this.antPoeng = antPoeng;
	}

}