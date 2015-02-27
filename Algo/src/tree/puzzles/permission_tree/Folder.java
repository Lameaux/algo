package tree.puzzles.permission_tree;

import java.util.Arrays;
import java.util.List;

public class Folder {

	private int number;
	private int root;
	private List<String> users;

	public Folder(String folderString, int number) {
		String[] folderArray = folderString.split(" ", 2);
		String folderRoot = folderArray[0];
		root = Integer.parseInt(folderRoot);
		String usersString = folderArray[1];
		users = Arrays.asList(usersString.split(","));
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public boolean hasAccess(String user) {
		return users.contains(user);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + root;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
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
		Folder other = (Folder) obj;
		if (number != other.number)
			return false;
		if (root != other.root)
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return number + " " + users.toString();
	}

}
