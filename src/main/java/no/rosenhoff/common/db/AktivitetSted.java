package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * AktivitetSted entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "AKTIVITET_STED", schema = "PUBLIC", catalog = "ROSENHOFF", uniqueConstraints = @UniqueConstraint(columnNames = "STEDSNAVN"))
public class AktivitetSted implements java.io.Serializable {

    // Fields

    private Integer id;
    private String stedsnavn;
    private Set<Aktivitet> aktivitets = new HashSet<Aktivitet>(0);

    // Constructors

    /**
     * default constructor
     */
    public AktivitetSted() {
    }

    /**
     * minimal constructor
     */
    public AktivitetSted(String stedsnavn) {
        this.stedsnavn = stedsnavn;
    }

    /**
     * full constructor
     */
    public AktivitetSted(String stedsnavn, Set<Aktivitet> aktivitets) {
        this.stedsnavn = stedsnavn;
        this.aktivitets = aktivitets;
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

    @Column(name = "STEDSNAVN", unique = true, nullable = false, length = 30)
    public String getStedsnavn() {
        return this.stedsnavn;
    }

    public void setStedsnavn(String stedsnavn) {
        this.stedsnavn = stedsnavn;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "aktivitetSted")
    public Set<Aktivitet> getAktivitets() {
        return this.aktivitets;
    }

    public void setAktivitets(Set<Aktivitet> aktivitets) {
        this.aktivitets = aktivitets;
	}

}