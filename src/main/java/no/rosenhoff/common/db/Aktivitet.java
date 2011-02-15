package no.rosenhoff.common.db;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Aktivitet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AKTIVITET", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Aktivitet implements java.io.Serializable {

    // Fields

    private Integer id;
    private AktivitetSted aktivitetSted;
    private Date naar;
    private String hva;
    private Date ferdig;
    private String sesong;
    private String lagNavn;

    // Constructors

    /**
     * default constructor
     */
    public Aktivitet() {
    }

    /**
     * full constructor
     */
    public Aktivitet(AktivitetSted aktivitetSted, Date naar, String hva,
                     Date ferdig, String sesong, String lagNavn) {
        this.aktivitetSted = aktivitetSted;
        this.naar = naar;
        this.hva = hva;
        this.ferdig = ferdig;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HVOR", nullable = false)
    public AktivitetSted getAktivitetSted() {
        return this.aktivitetSted;
    }

    public void setAktivitetSted(AktivitetSted aktivitetSted) {
        this.aktivitetSted = aktivitetSted;
    }

    @Column(name = "NAAR", nullable = false, length = 23)
    public Date getNaar() {
        return this.naar;
    }

    public void setNaar(Date naar) {
        this.naar = naar;
    }

    @Column(name = "HVA", nullable = false, length = 50)
    public String getHva() {
        return this.hva;
    }

    public void setHva(String hva) {
        this.hva = hva;
    }

    @Column(name = "FERDIG", nullable = false, length = 6)
    public Date getFerdig() {
        return this.ferdig;
    }

    public void setFerdig(Date ferdig) {
        this.ferdig = ferdig;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}