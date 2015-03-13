package puzzles.bloggodocstructure;

import java.util.ArrayList;
import java.util.List;

public class HtmlNode {

	public String name;
	public List<HtmlNode> nodes = new ArrayList<HtmlNode>();

	@Override
	public String toString() {
		return name + nodes.toString();
		
	}

}
