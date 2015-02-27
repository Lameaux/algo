package tree.puzzles.permission_tree;

import java.util.Comparator;

import objects.Objects;

public class FolderComparator implements Comparator<Folder> {

	@Override
	public int compare(Folder o1, Folder o2) {
		if (Objects.equals(o1, o2))
			return 0;

		int rootDiff = o1.getRoot() - o2.getRoot();

		if (rootDiff != 0) {
			return rootDiff;
		}

		return o1.getNumber() - o1.getNumber();

	}

}