package puzzles.permission_tree;

import java.util.ArrayList;
import java.util.List;

public class PermissionNode {
	Folder folder;
	List<PermissionNode> nodes = new ArrayList<PermissionNode>();

	public List<PermissionNode> getNodes() {
		return nodes;
	}

	public void setNodes(List<PermissionNode> nodes) {
		this.nodes = nodes;
	}

	public PermissionNode(Folder folder) {
		super();
		this.folder = folder;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	@Override
	public String toString() {
		return folder.toString();
	}

	
	
}
