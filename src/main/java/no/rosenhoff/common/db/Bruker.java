package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Bruker entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "BRUKER", schema = "PUBLIC", catalog = "ROSENHOFF")
public class Bruker implements java.io.Serializable {

    // Fields

    private Integer id;
    private String brukernavn;
    private String passord;

    // Constructors

    /**
     * default constructor
     */
    public Bruker() {
    }

    /**
     * full constructor
     */
    public Bruker(String brukernavn, String passord) {
        this.brukernavn = brukernavn;
        this.passord = passord;
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

    @Column(name = "BRUKERNAVN", nullable = false, length = 15)
    public String getBrukernavn() {
        return this.brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    @Column(name = "PASSORD", nullable = false, length = 15)
    public String getPassord() {
        return this.passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
	}

}