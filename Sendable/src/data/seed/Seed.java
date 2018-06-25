/**
 * 
 */
package data.seed;
import java.util.ArrayList;
import com.pro684.sendable.entities.*;
/**
 * @author exd
 *
 */
public class Seed {
	
	
	private ArrayList<User> SampleUsers;

	public Seed() {
		SampleUsers = new ArrayList<User>();
		User user1 = new User("abc@111.com","password1");
		User user2 = new User("abc@112.com","password2");
		User user3 = new User("abc@113.com","password3");
		User user4 = new User("abc@114.com","password4");
		User user5 = new User("abc@115.com","password5");
		SampleUsers.add(user1);
		SampleUsers.add(user2);
		SampleUsers.add(user3);
		SampleUsers.add(user4);
		SampleUsers.add(user5);
		for (User user : SampleUsers) {
			System.out.println(user.getEmail());
			System.out.println(user.getPassword());
		}
	
	}
	
	public ArrayList<User> AllUsers() {
		return SampleUsers;
	}
	
	public boolean AddUser(User newUser) {
		if(newUser != null) {
			SampleUsers.add(newUser);
			System.out.println("New User: " + newUser.getEmail());
			return true;
		}
		else {
			System.out.println("Empty User");
			return false;
		}
	} 
}
