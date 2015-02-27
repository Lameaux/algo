package tree.puzzles.permission_tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
 * http://community.topcoder.com/stat?c=problem_statement&pm=3093&rd=5864
 * 
 * */

public class PermissionTree {

	public int[] findHome(String[] folders, String[] users) {

		PermissionNode tree = buildTree(folders);

		int[] result = new int[users.length];

		for (int i = 0; i < users.length; i++) {
			result[i] = findHomeForClient(tree, users[i]);
		}

		return result;
	}

	private List<PermissionNode> getAccessibleChildren(PermissionNode root, String user) {
		List<PermissionNode> accessibleChildren = new ArrayList<PermissionNode>();
		for (PermissionNode child : root.getNodes()) {
			if (child.getFolder().hasAccess(user)) {
				accessibleChildren.add(child);
			}
		}
		return accessibleChildren;
	}

	private int findHomeForClient(PermissionNode root, String user) {

		List<PermissionNode> accessibleChildren = getAccessibleChildren(root, user);

		if (accessibleChildren.isEmpty()) {
			if (root.getFolder().hasAccess(user)) {
				return root.getFolder().getNumber();
			}
		} else {

			if (accessibleChildren.size() > 1) {
				return root.getFolder().getNumber();
			}

			PermissionNode child = accessibleChildren.get(0);
			List<PermissionNode> accessibleFromChild = getAccessibleChildren(child, user);
			// last directory
			if (accessibleFromChild.isEmpty()) {
				if (root.getFolder().hasAccess(user)) {
					return root.getFolder().getNumber();
				}
				return child.getFolder().getNumber();
			}

			return findHomeForClient(child, user);

		}

		// no accessible, go recursively
		for (PermissionNode child : root.getNodes()) {
			int res = findHomeForClient(child, user);
			if (res != -1) {
				return res;
			}
		}

		return -1;

	}

	private PermissionNode buildTree(String[] folders) {

		Queue<Folder> folderQueue = new PriorityQueue<Folder>(folders.length, new FolderComparator());
		for (int i = 0; i < folders.length; i++) {
			Folder folder = new Folder(folders[i], i);
			folderQueue.add(folder);
		}

		Folder folder = folderQueue.poll(); // root
		PermissionNode root = new PermissionNode(folder);

		while ((folder = folderQueue.poll()) != null) {
			addNode(root, folder);
		}

		return root;

	}

	private boolean addNode(PermissionNode root, Folder folder) {

		List<PermissionNode> children = root.getNodes();

		if (root.getFolder().getNumber() == folder.getRoot()) {
			PermissionNode newNode = new PermissionNode(folder);
			children.add(newNode);
			return true;
		} else {

			for (PermissionNode child : children) {
				if (addNode(child, folder)) {
					return true;
				}
			}
		}

		return false;
	}

}
