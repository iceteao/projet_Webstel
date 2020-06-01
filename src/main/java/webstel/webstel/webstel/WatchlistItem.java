package webstel.webstel.webstel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


	
@Entity
@Table(name = "list_item")
public class WatchlistItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "list_item_id")

    private Integer id;
	
    @NotBlank( message="The country need to be filled out")
    @Column(name = "list_country")
	private String country;
    
    @NotBlank( message="Please enter the location")
    @Column(name = "address")
    private String address;
    
    @NotNull( message="Please enter the dates")
    @Column(name = "date_from")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date_to")
    private Date dateTo;
    
    
	@Size(max=50,  message="The descriptions of your house should be under 50 characters")
    @Column(name = "house_desc")
	private String hdesc;
	
    @Size(max=50,  message="The services should be under 50 characters")
    @Column(name = "service")
    private String service;

	@Size(max=50,  message="The constraints should be under 50 characters")
    @Column(name = "message")
	private String limit;
	
	
    @Size(max=50,  message="supplementary information should be under 50 characters")
    @Column(name = "comment")
    private String comment;

    public static int index = 0;

    public WatchlistItem() {
        this.id = index ++;
    }
    

    public WatchlistItem(int id, String country, String address, Date dateFrom, Date dateTo, 
    		String hdesc, String service, String limit, String comment) {
        super();
        this.id = index ++;
    	this.country = country;
        this.address = address;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
		this.hdesc = hdesc;
		this.service = service;
		this.limit = limit;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
    
    
	public String getHdesc() {
		return hdesc;
	}

	public void setHdesc(String hdesc) {
		this.hdesc = hdesc;
	}
	
	
    public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}
	
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
	@ManyToOne
	@JoinColumn(name="userid", insertable=false, updatable=false)
	private User user;
	private int userid;

	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public static int getIndex() {
		return index;
	}


	public static void setIndex(int index) {
		WatchlistItem.index = index;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


}
    
