import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import java.util.Set;

public class Bank implements BankProc, Serializable {

	private Map<Person, Set<Account>> bank;
	

	private static final long serialVersionUID = 1L;

	public Bank() {

		bank = new HashMap<Person, Set<Account>>();
	}

	

	public boolean isWellFormed() {

		for (Person p : bank.keySet()) {
			if (p == null || !p.isWellFormed())
				return false;

		}
		return true;
	}

	public void addPerson(Person p) {

		// B_Deserialization();

		assert p.isWellFormed();
		assert (!bank.containsKey(p)) : "Person already in the bank.";

		int size = bank.size();

		Set<Account> newSet = new HashSet<Account>();

		bank.put(p, newSet);
		assert (bank.size() == size + 1) : "Size of the bank wasn't modified.";

		// B_Serialization(bank);

	}

	public void removePersonI(Person p) { // TODO Auto-generated method stub

		// B_Deserialization();

		assert bank.containsKey(p) : "Person not in the bank";
		bank.remove(p);

		// B_Serialization(bank);

	}

	public void addAccount(Person person, Account account) {

		// B_Deserialization();

		assert (bank.containsKey(person)) : "Person not in the bank.";

		assert (isWellFormed()) : "Invariant modified.";

		if (bank.get(person) == null) {

			HashSet<Account> accounts = new HashSet<>();
			account.addObserver(account.getOwner());
			accounts.add(account);

			bank.put(person, accounts);

		} else {

			Set<Account> accounts = bank.get(person);
			account.addObserver(account.getOwner());
			//accounts.addAll(bank.get(person));
			accounts.add(account);

			bank.put(person,  accounts);

		}

		assert (isWellFormed()) : "Invariant modified.";

		// B_Serialization(bank);

	}
	
	
	public void removeAccount(Account a) {

		// B_Deserialization();
		for (Person p : bank.keySet()) {
			HashSet<Account> aux = (HashSet<Account>) bank.get(p);

			if (aux.contains(a)) {
				aux.remove(a);
				bank.remove(a);
				bank.put(p, aux);
			}
			//bank.put(p, aux);
		}
		// B_Serialization(bank);

	}

	public ArrayList<Person> getAllPersons() {
		Set<Person> persons = bank.keySet();
		ArrayList<Person> pers = new ArrayList<>();
		for (Person person : persons) {
			pers.add(person);
		}
		return pers;
	}

	public ArrayList<Account> getAccounts() {
		ArrayList<Account> acc = new ArrayList<>();

		for (Person p : bank.keySet()) {

			HashSet<Account> aux = (HashSet<Account>) bank.get(p);
			for (Account a : aux) {
				if (a != null)
					acc.add(a);
			}
		}
		return acc;

	}

	/*
	 * public int getNrAcc(Person p) { int cnt = 0; HashSet<Account> aux =
	 * (HashSet<Account>) bank.get(p); for (Account a : aux) { cnt++;
	 * 
	 * } return cnt; }
	 */

	/*
	 * public void B_Serialization(Map<Person, Set<Account>> data){
	 * 
	 * try { FileOutputStream fileOut = new FileOutputStream("bank.ser");
	 * ObjectOutputStream out = new ObjectOutputStream(fileOut);
	 * out.writeObject(data); out.close();
	 * 
	 * fileOut.close();
	 * System.out.printf("Serialized data is saved in bank.ser"); } catch
	 * (IOException i) { i.printStackTrace(); } }
	 * 
	 * public static Map<Person,Set<Account>> B_Deserialization() {
	 * HashMap<Person,Set<Account>> data=new HashMap<Person,Set<Account>>();
	 * 
	 * FileInputStream fileIn; try { fileIn = new FileInputStream("bank.ser");
	 * ObjectInputStream in = new ObjectInputStream(fileIn); data =
	 * (HashMap<Person, Set<Account>>) in.readObject(); in.close();
	 * fileIn.close();
	 * 
	 * } catch (FileNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (ClassNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); }
	 * 
	 * return data;
	 * 
	 * }
	 */

}
