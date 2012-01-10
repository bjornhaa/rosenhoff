package no.rosenhoff.common.db;

import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

/**
 * Spiller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SPILLER", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Spiller implements java.io.Serializable {

    // Fields

    private Integer id;
    private String navn;
    private String posisjon;
    private String email;
    private String mobil;
    private String sesong;
    private String lagNavn;

    private String imageExtension;

    // Constructors

    /**
     * default constructor
     */
    public Spiller() {
    }

    /**
     * minimal constructor
     */
    public Spiller(String navn, String lagNavn) {
        this.navn = navn;
        this.lagNavn = lagNavn;
    }

    /**
     * full constructor
     */
    public Spiller(String navn, String posisjon,  String email,
                   String mobil, String sesong, String lagNavn) {
        this.navn = navn;
        this.posisjon = posisjon;
        this.email = email;
        this.mobil = mobil;
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

    @Column(name = "NAVN", nullable = false, length = 30)
    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Column(name = "POSISJON", length = 3)
    public String getPosisjon() {
        return this.posisjon;
    }

    public void setPosisjon(String posisjon) {
        this.posisjon = posisjon;
    }


    @Column(name = "EMAIL", length = 30)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "MOBIL", length = 15)
    public String getMobil() {
        return this.mobil;
    }

    public void setMobil(String mobil) {
        this.mobil = mobil;
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


    @Column(name = "IMAGE_EXTENSION", length = 6)
    public String getImageExtension() {
        return imageExtension;
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }
}