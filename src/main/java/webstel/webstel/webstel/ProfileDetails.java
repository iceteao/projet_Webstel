package webstel.webstel.webstel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Size;


	
@Entity
@Table(name = "profiledetails")
public class ProfileDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profiledetails_id")
    private Integer id;
	
	@Size(max=50,  message="The descriptions of your house should be under 50 characters")
    @Column(name = "aboutme")
	private String aboutme;
    
    @Column(name = "country")
    private String country;
   
    @Column(name = "mobile")
    private String mobile;
    
    @Column(name = "website")
    private String website;
   

    public String getAboutme() {
		return aboutme;
	}


	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public static int index = 0;

    public ProfileDetails() {
        this.id = index ++;
    }
    

    public ProfileDetails(int id, String aboutme, String country, String mobile,String website) {
        super();
        this.id = index ++;
        this.aboutme = aboutme;
    	this.country = country;
        this.mobile = mobile;
        this.website = website;
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
		ProfileDetails.index = index;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


}
    
