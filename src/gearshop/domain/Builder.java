package gearshop.domain;
// Generated Mar 17, 2017 5:12:54 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Builder generated by hbm2java
 */
@Entity
@Table(name="BUILDER"
    ,catalog="gearshop"
)
public class Builder  implements java.io.Serializable {


     private Long id;
     private String name;
     private Date startDtm;
     private Date endDtm;
     private Integer daysAvailPerYear;
     private Date createdDtm;
     private Date lastModifiedDtm;

    public Builder() {
    }

	
    public Builder(Date createdDtm, Date lastModifiedDtm) {
        this.createdDtm = createdDtm;
        this.lastModifiedDtm = lastModifiedDtm;
    }
    public Builder(String name, Date startDtm, Date endDtm, Integer daysAvailPerYear, Date createdDtm, Date lastModifiedDtm) {
       this.name = name;
       this.startDtm = startDtm;
       this.endDtm = endDtm;
       this.daysAvailPerYear = daysAvailPerYear;
       this.createdDtm = createdDtm;
       this.lastModifiedDtm = lastModifiedDtm;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="NAME", length=125)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_DTM", length=19)
    public Date getStartDtm() {
        return this.startDtm;
    }
    
    public void setStartDtm(Date startDtm) {
        this.startDtm = startDtm;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_DTM", length=19)
    public Date getEndDtm() {
        return this.endDtm;
    }
    
    public void setEndDtm(Date endDtm) {
        this.endDtm = endDtm;
    }

    
    @Column(name="DAYS_AVAIL_PER_YEAR")
    public Integer getDaysAvailPerYear() {
        return this.daysAvailPerYear;
    }
    
    public void setDaysAvailPerYear(Integer daysAvailPerYear) {
        this.daysAvailPerYear = daysAvailPerYear;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_DTM", nullable=false, length=19)
    public Date getCreatedDtm() {
        return this.createdDtm;
    }
    
    public void setCreatedDtm(Date createdDtm) {
        this.createdDtm = createdDtm;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LAST_MODIFIED_DTM", nullable=false, length=19)
    public Date getLastModifiedDtm() {
        return this.lastModifiedDtm;
    }
    
    public void setLastModifiedDtm(Date lastModifiedDtm) {
        this.lastModifiedDtm = lastModifiedDtm;
    }




}


