package gearshop.domain;
// Generated Mar 17, 2017 5:12:54 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
 * Customer generated by hbm2java
 */
@Entity
@Table(name="CUSTOMER"
    ,catalog="gearshop"
)
public class Customer  implements java.io.Serializable {


     private Long id;
     private String firstName;
     private String lastName;
     private String company;
     private String address1;
     private String address2;
     private String city;
     private String state;
     private String zip;
     private String customerType;
     private Byte active;
     private String contact;
     private String phone1;
     private String phone2;
     private String email;
     private String fax;
     private String term;
     private String discountType;
     private BigDecimal discountAmount;
     private BigDecimal taxPercent;
     private Date createdDtm;
     private Date lastUpdtDtm;

    public Customer() {
    }

	
    public Customer(Date createdDtm, Date lastUpdtDtm) {
        this.createdDtm = createdDtm;
        this.lastUpdtDtm = lastUpdtDtm;
    }
    public Customer(String firstName, String lastName, String company, String address1, String address2, String city, String state, String zip, String customerType, Byte active, String contact, String phone1, String phone2, String email, String fax, String term, String discountType, BigDecimal discountAmount, BigDecimal taxPercent, Date createdDtm, Date lastUpdtDtm) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.company = company;
       this.address1 = address1;
       this.address2 = address2;
       this.city = city;
       this.state = state;
       this.zip = zip;
       this.customerType = customerType;
       this.active = active;
       this.contact = contact;
       this.phone1 = phone1;
       this.phone2 = phone2;
       this.email = email;
       this.fax = fax;
       this.term = term;
       this.discountType = discountType;
       this.discountAmount = discountAmount;
       this.taxPercent = taxPercent;
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

    
    @Column(name="FIRST_NAME", length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="LAST_NAME", length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="COMPANY", length=125)
    public String getCompany() {
        return this.company;
    }
    
    public void setCompany(String company) {
        this.company = company;
    }

    
    @Column(name="ADDRESS_1", length=125)
    public String getAddress1() {
        return this.address1;
    }
    
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    
    @Column(name="ADDRESS_2", length=125)
    public String getAddress2() {
        return this.address2;
    }
    
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    
    @Column(name="CITY", length=45)
    public String getCity() {
        return this.city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    
    @Column(name="STATE", length=45)
    public String getState() {
        return this.state;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    
    @Column(name="ZIP", length=5)
    public String getZip() {
        return this.zip;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }

    
    @Column(name="CUSTOMER_TYPE", length=45)
    public String getCustomerType() {
        return this.customerType;
    }
    
    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    
    @Column(name="ACTIVE")
    public Byte getActive() {
        return this.active;
    }
    
    public void setActive(Byte active) {
        this.active = active;
    }

    
    @Column(name="CONTACT", length=45)
    public String getContact() {
        return this.contact;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }

    
    @Column(name="PHONE_1", length=45)
    public String getPhone1() {
        return this.phone1;
    }
    
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    
    @Column(name="PHONE_2", length=45)
    public String getPhone2() {
        return this.phone2;
    }
    
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    
    @Column(name="EMAIL", length=125)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="FAX", length=45)
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }

    
    @Column(name="TERM", length=45)
    public String getTerm() {
        return this.term;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }

    
    @Column(name="DISCOUNT_TYPE", length=45)
    public String getDiscountType() {
        return this.discountType;
    }
    
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    
    @Column(name="DISCOUNT_AMOUNT", precision=5)
    public BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }
    
    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    
    @Column(name="TAX_PERCENT", precision=5)
    public BigDecimal getTaxPercent() {
        return this.taxPercent;
    }
    
    public void setTaxPercent(BigDecimal taxPercent) {
        this.taxPercent = taxPercent;
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


