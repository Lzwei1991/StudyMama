package sg.com.studymama.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class DAOUserProfile extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String contact;
	@Column
	private String address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "DAOUserProfile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", contact="
				+ contact + ", address=" + address + "]";
	}
}
