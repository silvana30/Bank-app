import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public void B_Serialization(Bank b) {
		try {
			FileOutputStream fileOut = new FileOutputStream("bank.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(b);
			out.close();
		
			fileOut.close();
			System.out.printf("Serialized data is saved in bank.ser");
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void B_Deserialization(Bank b) {

		try {
			FileInputStream fileIn = new FileInputStream("bank.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			b = (Bank) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Bank class not found");
			c.printStackTrace();
			return;
		}
	}
}
