import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

public class JUnitTest {
	private Hashtable<Integer, Person> list;
	Bank b = new Bank();

	@Test
	public void test() {

		Person p1 = new Person("ion", "cluj", 1256, "2563485326125");
		Person p2 = new Person("vasile", "dej", 1524, "5236589452156");
		b.addPerson(p1);
		b.addPerson(p2);
		Account a3 = new SavingAccount(p1);
		Account a2 = new SpendingAccount(p1);
		Account s = new SavingAccount(p2);
		Account s2 = new SpendingAccount(p2);

		b.addAccount(p1, s2);
		b.addAccount(p1, s);
		b.addAccount(p2, a2);
		b.addAccount(p2, a3);

		a3.setMoney(30.0);
		a3.setType("saving");
		a2.setMoney(15.2);
		a2.setType("spending");
		s.setMoney(11.0);
		s.setType("saving");
		s2.setMoney(52.3);
		s2.setType("spending");

		a3.addMoney(10.0);

	}

	@Test
	public void addMoney() throws Exception {
		Person p1 = new Person("ion", "cluj", 1256, "2563485326125");
		b.addPerson(p1);
		Account a2 = new SpendingAccount(p1);
		a2.setMoney(30.0);
		a2.setType("saving");
		a2.addMoney(10.0);
		assertEquals(Double.valueOf(40.0), a2.getMoney());
	}

	@Test
	public void extract() throws Exception {
		Person p1 = new Person("ion", "cluj", 1256, "2563485326125");
		b.addPerson(p1);
		Account a2 = new SpendingAccount(p1);
		a2.setMoney(30.0);
		a2.setType("saving");
		a2.extract(10.0);
		assertEquals(Double.valueOf(19.97), a2.getMoney());
	}

}
