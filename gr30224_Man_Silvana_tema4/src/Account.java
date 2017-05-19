import java.util.Observable;

public abstract class Account extends Observable {

	protected Person owner;
	protected Integer ID;
	protected Double money;
	protected String type;

	public abstract void addMoney(Double money);

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract int getID();

	public abstract void extract(Double money);

	public abstract Person getOwner();

	public abstract Double getMoney();

	public abstract String getType();

	public abstract boolean isWellFormed();

	@Override
	public String toString() {
		return "Account [owner=" + owner + ", ID=" + ID + ", money=" + money + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		// result = prime * result + ((money == null) ? 0 : money.hashCode());
		// result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		// result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Account other = (Account) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (money == null) {
			if (other.money != null)
				return false;
		} else if (!money.equals(other.money))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public void setAccountId(Integer accountKey) {
		// TODO Auto-generated method stub
		this.ID = accountKey;
	}

}
