import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

public class Person implements Serializable, Observer {

	private String name;
	private String address;
	private int ID;
	private String CNP;

	public Person(String name, String address, int ID, String cNP) {
		super();
		this.name = name;
		this.address = address;
		this.ID = ID;
		CNP = cNP;
	}

	public Person() {
		super();

	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", CNP=" + CNP + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public boolean isWellFormed() {
		// TODO Auto-generated method stub
		if (this.ID <= 0 || this.address == null || this.CNP == null || this.name == null || this.CNP.length() != 13)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result + ((CNP == null) ? 0 : CNP.hashCode());
		result = prime * result + ID;
		// result = prime * result + ((address == null) ? 0 :
		// address.hashCode());
		// result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (CNP == null) {
			if (other.CNP != null)
				return false;
		} else if (!CNP.equals(other.CNP))
			return false;
		if (ID != other.ID)
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public void update(Observable arg0, Object arg1) {
		System.out.print((String) arg1);
	}

}
