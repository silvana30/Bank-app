import java.util.Hashtable;
import java.util.Map;

public interface BankProc {

	/**
	 * @param p
	 * @pre !bank.containsKey(person)&&person!=null
	 * @post (bank.size()==bank.size()@pre+1
	 */
	public abstract void addPerson(Person p);

	/**
	 * @param p
	 * 
	 * @pre bank.containsKey(person)
	 * @post (bank.size()==@pre bank.size()-1)
	 */

	public abstract void removePersonI(Person p);

	/**
	 * @param a
	 * 
	 * @pre bank.containsKey(person)&&bank.get(person).contains( account)
	 * @post (bank.get(person).size()==@pre bank.get(person).size()-1)
	 */

	public abstract void removeAccount(Account a);

	/**
	 * 
	 * @param person
	 * @param account
	 * @pre bank.containsKey(person)
	 * @post (bank.get(person).size()==@pre bank.get(person).size()+1)
	 */
	public abstract void addAccount(Person person, Account account);

}
