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
 * Unit generated by hbm2java
 */
@Entity
@Table(name="UNIT"
    ,catalog="gearshop"
)
public class Unit  implements java.io.Serializable {


     private Long id;
     private Long productId;
     private Long builderId;
     private Long invoiceId;
     private String serialNbr;
     private Date builtDate;
     private Byte remanufactured;
     private Byte rebuilt;
     private String description;
     private String notes;
     private String location;
     private Date createdDtm;
     private Date lastUpdtDtm;

    public Unit() {
    }

	
    public Unit(Date builtDate, Date createdDtm, Date lastUpdtDtm) {
        this.builtDate = builtDate;
        this.createdDtm = createdDtm;
        this.lastUpdtDtm = lastUpdtDtm;
    }
    public Unit(Long productId, Long builderId, Long invoiceId, String serialNbr, Date builtDate, Byte remanufactured, Byte rebuilt, String description, String notes, String location, Date createdDtm, Date lastUpdtDtm) {
       this.productId = productId;
       this.builderId = builderId;
       this.invoiceId = invoiceId;
       this.serialNbr = serialNbr;
       this.builtDate = builtDate;
       this.remanufactured = remanufactured;
       this.rebuilt = rebuilt;
       this.description = description;
       this.notes = notes;
       this.location = location;
       this.createdDtm = createdDtm;
       this.lastUpdtDtm = lastUpdtDtm;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ID", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    
    @Column(name="PRODUCT_ID")
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    
    @Column(name="BUILDER_ID")
    public Long getBuilderId() {
        return this.builderId;
    }
    
    public void setBuilderId(Long builderId) {
        this.builderId = builderId;
    }

    
    @Column(name="INVOICE_ID")
    public Long getInvoiceId() {
        return this.invoiceId;
    }
    
    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    
    @Column(name="SERIAL_NBR", length=45)
    public String getSerialNbr() {
        return this.serialNbr;
    }
    
    public void setSerialNbr(String serialNbr) {
        this.serialNbr = serialNbr;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="BUILT_DATE", nullable=false, length=19)
    public Date getBuiltDate() {
        return this.builtDate;
    }
    
    public void setBuiltDate(Date builtDate) {
        this.builtDate = builtDate;
    }

    
    @Column(name="REMANUFACTURED")
    public Byte getRemanufactured() {
        return this.remanufactured;
    }
    
    public void setRemanufactured(Byte remanufactured) {
        this.remanufactured = remanufactured;
    }

    
    @Column(name="REBUILT")
    public Byte getRebuilt() {
        return this.rebuilt;
    }
    
    public void setRebuilt(Byte rebuilt) {
        this.rebuilt = rebuilt;
    }

    
    @Column(name="DESCRIPTION", length=125)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="NOTES", length=125)
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    
    @Column(name="LOCATION", length=125)
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
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
    @Column(name="LAST_UPDT_DTM", nullable=false, length=19)
    public Date getLastUpdtDtm() {
        return this.lastUpdtDtm;
    }
    
    public void setLastUpdtDtm(Date lastUpdtDtm) {
        this.lastUpdtDtm = lastUpdtDtm;
    }




}


