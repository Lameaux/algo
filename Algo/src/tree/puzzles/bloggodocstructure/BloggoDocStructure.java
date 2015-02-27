package tree.puzzles.bloggodocstructure;

import java.util.Iterator;
import java.util.Stack;

import objects.Objects;

/*
 * http://community.topcoder.com/stat?c=problem_statement&pm=3025&rd=5860
 */
public class BloggoDocStructure {

	public String compare(String[] docA, String[] docB) {

		HtmlNode a = buildTree(docA);
		HtmlNode b = buildTree(docB);

		System.out.println(getSize(a) + " " + a.toString());
		System.out.println(getSize(b) + " " + b.toString());

		int outtree = partialMatch(a, b);
		int intree = partialMatch(b, a);

		System.out.println(intree);		
		System.out.println(outtree);
		
		if (intree > -1 && outtree > -1) {
			return "equivalent";
		} else if (intree == -1 && outtree == -1) {
			return "incompatible";
		} else if (intree > -1) {
			return "intree " + (getSize(b) - intree);
		} else if (outtree > -1) {
			return "outtree " + (getSize(a) - outtree);
		}
		
		return null;
	}

	private int getSize(HtmlNode n) {
		return rSize(n);
	}
	
	private int rSize(HtmlNode n) {
		if (n == null) {
			return 0;
		}
		
		int size = 1;
		
		for (HtmlNode c : n.nodes) {
			size += rSize(c);
		}
		
		return size;
		
	}
	
	private int partialMatch(HtmlNode tree, HtmlNode searchTree) {
		if (Objects.equals(tree.name, searchTree.name)) {
			int children = matchChildren(tree, searchTree);
			if (children > -1) {
				children++;
			}
			return children;
		}
		return -1;
	}

	private int matchChildren(HtmlNode tree, HtmlNode searchTree) {
		if (!Objects.equals(tree.name, searchTree.name)) {
			return -1;
		}

		if (tree.nodes.size() < searchTree.nodes.size()) {
			return -1;
		}

		int matches = 0;
		Iterator<HtmlNode> treeIterator = tree.nodes.iterator();
		for (HtmlNode searchNode : searchTree.nodes) {
			int matched = -1;
			while (treeIterator.hasNext()) {
				HtmlNode treeNode = treeIterator.next();
				if (!Objects.equals(treeNode.name, searchNode.name)) {
					continue;
				}
				matched = matchChildren(treeNode, searchNode);
				if (matched > -1) {
					matches += matched + 1;
					break;
				}
			}
			if (matched == -1) {
				return -1;
			}
		}

		return matches;

	}

	private HtmlNode buildTree(String[] rows) {
		CharReader reader = new CharReader(rows);
		Stack<HtmlNode> stack = new Stack<HtmlNode>();

		HtmlNode htmlNode = null;

		String tagName = "";
		int c;
		boolean inTag = false;
		while ((c = reader.readChar()) != -1) {
			char ch = (char) c;

			if (ch == '<') {
				tagName = "";
				inTag = true;
				continue;
			}
			if (ch == '>') {
				if (tagName.startsWith("/")) {
					if (stack.isEmpty()) {
						break;
					}
					htmlNode = stack.pop();
				} else {
					HtmlNode newHtmlNode = new HtmlNode();
					if (htmlNode != null) {
						stack.push(htmlNode);
						htmlNode.nodes.add(newHtmlNode);
					}
					htmlNode = newHtmlNode;
					htmlNode.name = tagName;
				}
				inTag = false;
				continue;
			}

			if (inTag) {
				tagName += ch;
			}

		}

		return htmlNode;

	}

}
