import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Color;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtCnp;
	private JTextField txtAddress;
	private JTable cli;
	private JTable acc;
	private JTextField txtId_1;
	private JTextField txtType;
	private JTextField txtMoney;
	// private static Serialization bs = new Serialization();
	int cnt;
	int contor = 3;

	private ArrayList<Person> clienti;
	private ArrayList<Account> conturi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Bank b = new Bank();

					Frame frame = new Frame(b);

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame(Bank b) {

		Person p1 = new Person("ion", "cluj", 2563, "2563485326125");
		Person p2 = new Person("vasile", "dej", 1552, "5236589452156");

		Account a3 = new SavingAccount(p1);
		Account a2 = new SpendingAccount(p1);
		Account s = new SavingAccount(p2);
		Account s2 = new SpendingAccount(p2);
		a3.setMoney(30.0);
		a3.setID(1523);
		a3.setType("saving");
		a2.setMoney(15.2);
		a2.setID(5451);
		a2.setType("spending");
		s.setMoney(11.0);
		s.setID(1444);
		s.setType("saving");
		s2.setMoney(52.3);
		s2.setID(4523);
		s2.setType("spending");
		b.addPerson(p1);
		b.addPerson(p2);

		b.addAccount(p1, s2);
		b.addAccount(p1, s);
		b.addAccount(p2, a2);
		b.addAccount(p2, a3);
		// b.B_Serialization(data);

		// data = new HashMap<Person, Set<Account>>();
		clienti = new ArrayList<Person>();
		conturi = new ArrayList<Account>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(0, 0, 486, 333);
		contentPane.add(tabbedPane_1);

		JPanel cl = new JPanel();
		cl.setBackground(new Color(255, 250, 205));
		tabbedPane_1.addTab("Clients", null, cl, null);
		cl.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 293, 86);
		cl.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(250, 240, 230));
		DefaultTableModel def = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "CNP", "Address" });

		scrollPane.setViewportView(table);
		table.setModel(def);

		JButton btnView = new JButton("View");
		btnView.setBackground(new Color(255, 228, 181));
		btnView.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// bs.B_Serialization(b);

				clienti = b.getAllPersons();

				for (Person p : clienti) {
					Object[] row = { "" + p.getID() + "", p.getName(), p.getCNP(), p.getAddress() };

					def.addRow(row);

				}
			}
		});
		btnView.setBounds(318, 40, 107, 34);
		cl.add(btnView);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setBackground(new Color(255, 222, 173));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bs.B_Serialization(b);

				int ID = Integer.parseInt(txtId.getText());

				String name = txtName.getText();
				String cnp = txtCnp.getText();
				String ad = txtAddress.getText();

				Person pers = new Person();
				pers.setCNP(cnp);
				pers.setAddress(ad);
				pers.setName(name);
				pers.setID(ID);
				b.addPerson(pers);
				// listp = b.getClients();
				clienti = b.getAllPersons();

				for (Person p : clienti) {
					Object[] row = { "" + p.getID() + "", p.getName(), p.getCNP(), p.getAddress() };

					def.addRow(row);

				}
				;
			}
		});
		btnAdd.setBounds(318, 188, 89, 23);
		cl.add(btnAdd);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(255, 222, 173));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bs.B_Serialization(b);
				int id = Integer.parseInt(txtId.getText());
				for (Person p : clienti) {
					if (p.getID() == id)
						b.removePersonI(p);
				}

			}
		}

		);
		btnDelete.setBounds(318, 136, 89, 23);
		cl.add(btnDelete);

		txtId = new JTextField();
		txtId.setBounds(10, 137, 86, 20);
		cl.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(10, 217, 86, 20);
		cl.add(txtName);
		txtName.setColumns(10);

		txtCnp = new JTextField();
		txtCnp.setBounds(131, 137, 86, 20);
		cl.add(txtCnp);
		txtCnp.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(131, 217, 86, 20);
		cl.add(txtAddress);
		txtAddress.setColumns(10);

		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBackground(new Color(255, 222, 173));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// bs.B_Serialization(b);
				String name = txtName.getText();
				String cnp = txtCnp.getText();
				String add = txtAddress.getText();
				int id = Integer.parseInt(txtId.getText());

				// listp = b.getClients();
				clienti = b.getAllPersons();

				for (Person p : clienti) {
					if (p.getID() == id) {
						p.setAddress(add);
						p.setCNP(cnp);
						p.setName(name);
					}
				}

			}
		});
		btnEdit.setBounds(318, 245, 89, 23);
		cl.add(btnEdit);

		JLabel lblId_1 = new JLabel("ID:");
		lblId_1.setBounds(10, 112, 46, 14);
		cl.add(lblId_1);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 192, 46, 14);
		cl.add(lblName);

		JLabel lblCnp = new JLabel("CNP:");
		lblCnp.setBounds(131, 112, 46, 14);
		cl.add(lblCnp);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(131, 192, 73, 14);
		cl.add(lblAddress);

		JPanel ac = new JPanel();
		ac.setBackground(new Color(250, 250, 210));
		tabbedPane_1.addTab("Accounts", null, ac, null);
		ac.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 206, 120);
		ac.add(scrollPane_1);

		cli = new JTable();
		cli.setModel(def);
		scrollPane_1.setViewportView(cli);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(226, 11, 245, 120);
		ac.add(scrollPane_2);

		acc = new JTable();
		DefaultTableModel def2 = new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Name", "Money", "Type" });

		acc.setModel(def2);
		scrollPane_2.setViewportView(acc);

		JButton btnAddaccount = new JButton("ADD account");
		btnAddaccount.setBackground(new Color(245, 222, 179));
		btnAddaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bs.B_Serialization(b);
				Account account = null;

				Double money = Double.parseDouble(txtMoney.getText());

				int id = Integer.parseInt(txtId_1.getText());

				clienti = b.getAllPersons();

				Integer accountKey = 0;
				for (Person p : clienti) {
					if (p.getID() == id) {

						if (txtType.getText().equals("saving")) {
							account = new SavingAccount(p);
							account.setType("saving");
						} else {
							account = new SpendingAccount(p);
							account.setType("spending");
						}
						b.addAccount(p, account);
					}

					//b.addAccount(p, account);
					conturi = b.getAccounts();
					Random rand = new Random();

					do
						accountKey = rand.nextInt(10000);
					while (conturi.contains(accountKey));

				}
				account.setMoney(money);
				account.setID(accountKey);

				;
				// b.addAccount(account);

			}
		});
		btnAddaccount.setBounds(311, 164, 126, 32);
		ac.add(btnAddaccount);

		JButton btnAddmoney = new JButton("ADD money");
		btnAddmoney.setBackground(new Color(245, 222, 179));
		btnAddmoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bs.B_Serialization(b);
				Double money = Double.parseDouble(txtMoney.getText());
				int id = Integer.parseInt(txtId_1.getText());

				for (Account a : conturi) {
					if (a.getID() == id)
						a.addMoney(money);
				}

			}
		});
		btnAddmoney.setBounds(311, 207, 126, 32);
		ac.add(btnAddmoney);

		JButton btnExtract = new JButton("Extract");
		btnExtract.setBackground(new Color(245, 222, 179));
		btnExtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// bs.B_Serialization(b);
				Double money = Double.parseDouble(txtMoney.getText());
				int id = Integer.parseInt(txtId_1.getText());

				for (Account a : conturi) {
					if (a.getID() == id)
						a.extract(money);
				}
			}
		});
		btnExtract.setBounds(311, 256, 126, 32);
		ac.add(btnExtract);

		txtId_1 = new JTextField();
		txtId_1.setBounds(55, 142, 86, 20);
		ac.add(txtId_1);
		txtId_1.setColumns(10);

		txtType = new JTextField();
		txtType.setBounds(55, 201, 86, 20);
		ac.add(txtType);
		txtType.setColumns(10);

		txtMoney = new JTextField();
		txtMoney.setBounds(55, 170, 86, 20);
		ac.add(txtMoney);
		txtMoney.setColumns(10);

		JButton del = new JButton("Delete");
		del.setBackground(new Color(245, 222, 179));
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// bs.B_Serialization(b);
				conturi = b.getAccounts();

				int accountID = Integer.parseInt(txtId_1.getText());

				for (Account a : conturi) {
					if (a.getID() == accountID)
						b.removeAccount(a);
				}
			}
		});
		del.setBounds(10, 256, 99, 32);
		ac.add(del);

		JButton btnView_1 = new JButton("View");
		btnView_1.setBackground(new Color(245, 222, 179));
		btnView_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// bs.B_Serialization(b);

				conturi = b.getAccounts();

				for (Account a : conturi) {
					Object[] row = { "" + a.getID() + "", a.getOwner().getName(), a.getMoney(), a.getType() };

					def2.addRow(row);

				}

			}
		});
		btnView_1.setBounds(173, 195, 99, 32);
		ac.add(btnView_1);

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(20, 145, 46, 14);
		ac.add(lblId);

		JLabel lblMoney = new JLabel("Money:");
		lblMoney.setBounds(10, 173, 46, 14);
		ac.add(lblMoney);

		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(10, 203, 46, 14);
		ac.add(lblType);
	}
}
