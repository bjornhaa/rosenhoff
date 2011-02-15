package no.rosenhoff.common.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Rapport entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "RAPPORT", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Rapport implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer kamp;
	private String overskrift;
	private String tekst;
	private String sesong;
	private String lagNavn;

	// Constructors

	/** default constructor */
	public Rapport() {
	}

	/** minimal constructor */
	public Rapport(Integer kamp, String lagNavn) {
		this.kamp = kamp;
		this.lagNavn = lagNavn;
	}

	/** full constructor */
	public Rapport(Integer kamp, String overskrift, String tekst, String sesong,
			String lagNavn) {
		this.kamp = kamp;
		this.overskrift = overskrift;
		this.tekst = tekst;
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

    @Column(name = "KAMP", nullable = false, length = 10)
    public Integer getKamp() {
		return this.kamp;
	}

	public void setKamp(Integer kamp) {
		this.kamp = kamp;
	}

	@Column(name = "OVERSKRIFT", length = 50)
	public String getOverskrift() {
		return this.overskrift;
	}

	public void setOverskrift(String overskrift) {
		this.overskrift = overskrift;
	}

	@Column(name = "TEKST")
	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
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