package no.rosenhoff.common.db;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * KampSpiller entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "KAMP_SPILLER", schema = "PUBLIC", catalog = "ROSENHOFF", uniqueConstraints = @UniqueConstraint(columnNames = {
        "KAMP_ID", "SPILLER_ID"}))
public class KampSpiller implements java.io.Serializable {

    // Fields

    private Integer kampId;
    private Integer spillerId;
    private Integer kampSpillerId;

    // Constructors

    /**
     * default constructor
     */
    public KampSpiller() {
    }

    /**
     * full constructor
     */
    public KampSpiller(Integer kamp, Integer spiller) {
        this.kampId = kamp;
        this.spillerId = spiller;
    }

    // Property accessors

    @GenericGenerator(name = "generator", strategy = "increment")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "KAMP_SPILLER_ID", unique = true, nullable = false)
    public Integer getKampSpillerId() {
        return this.kampSpillerId;
    }

    public void setKampSpillerId(Integer kampSpillerId) {
        this.kampSpillerId = kampSpillerId;
    }

    @Column(name = "KAMP_ID", nullable = false, length = 23)
    public Integer getKampId() {
        return this.kampId;
    }

    public void setKampId(Integer kampId) {
        this.kampId = kampId;
    }

    @Column(name = "SPILLER_ID", nullable = false, length = 23)
    public Integer getSpillerId() {
        return this.spillerId;
    }

    public void setSpillerId(Integer spiller) {
        this.spillerId = spiller;
	}

}