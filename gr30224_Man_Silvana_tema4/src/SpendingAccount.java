import java.util.Observer;

import javax.swing.JOptionPane;

public class SpendingAccount extends Account {

	public SpendingAccount(Person owner) {
		// super();
		this.owner = owner;
		this.ID = owner.getID();
		this.money = 0.0;
		this.type = null;

	}

	public void extract(Double money) {
		// TODO Auto-generated method stub
		if ((money + (money * 0.3 / 100)) < this.money) {

			this.money = this.money - money - money * 0.3 / 100;// comision 0.3%
																// de fiecare
																// data cand se
																// extrage
			System.out.print(super.countObservers());
			setChanged();
			this.notifyObservers("Soldul a fost actualizat.");
		}

	}

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
		if (money > 0) {
			this.money += money;

			setChanged();
			this.notifyObservers("Soldul a fost actualizat.");
		}
	}

	@Override
	public boolean isWellFormed() {
		if (this.ID <= 0 || this.money <= 0 || !this.owner.isWellFormed())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SpendingAccount [owner=" + owner + ", ID=" + ID + ", money=" + money + ", type=" + type
				+ ", getOwner()=" + getOwner() + ", getID()=" + getID() + ", getMoney()=" + getMoney() + ", getType()="
				+ getType() + ", isWellFormed()=" + isWellFormed() + ", hashCode()=" + hashCode() + ", hasChanged()="
				+ hasChanged() + ", countObservers()=" + countObservers() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}

}
