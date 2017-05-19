
public class SavingAccount extends Account {

	public SavingAccount(Person owner) {
		// super();
		this.owner = owner;
		this.ID = owner.getID();
		this.money = 0.0;
		this.type = null;

	}

	public boolean ok = true;
	public boolean ok2 = true;

	public Person getOwner() {
		return this.owner;
	}

	public int getID() {
		return this.ID;
	}

	public Double getMoney() {
		return this.money;
	}

	public String getType() {
		return this.type;
	}

	@Override
	public void addMoney(Double money) {
		// TODO Auto-generated method stub
		if (ok == true && money > 0) {
			if (money <= 100) {// dobanda de 0.1%
				this.money += money + money * 0.1 / 100;
			} else if (money > 100 && money <= 500) {// dobanda de 0.2%
				this.money += money + money * 0.2 / 100;
			} else // dobanda de 0.3%
				this.money += money + money * 0.3 / 100;

			setChanged();
			this.notifyObservers("Soldul a fost actualizat.");

		}
		ok = false;

	}

	@Override
	public boolean isWellFormed() {
		// TODO Auto-generated method stub
		if (this.ID <= 0 || this.money <= 0 || !this.owner.isWellFormed())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SavingAccount [owner=" + owner + ", ID=" + ID + ", money=" + money + ", type=" + type + ", getOwner()="
				+ getOwner() + ", getID()=" + getID() + ", getMoney()=" + getMoney() + ", getType()=" + getType()
				+ ", isWellFormed()=" + isWellFormed() + ", hashCode()=" + hashCode() + ", hasChanged()=" + hasChanged()
				+ ", countObservers()=" + countObservers() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public void extract(Double money) {
		// TODO Auto-generated method stub
		if (ok2 == true && money <= this.money) {
			this.money -= money;
			System.out.print(super.countObservers());
			setChanged();
			this.notifyObservers("Soldul a fost actualizat.");
		}

		ok2 = false;
	}
}
