package tree.puzzles.bloggodocstructure;

public class CharReader {

	private String[] rows;
	private int i,j;
	
	public CharReader(String[] rows) {
		this.rows = rows;
	}

	public int readChar() {
		while (i < rows.length) {
			String row = rows[i];
			while (j < row.length()) {
				char c = row.charAt(j);
				j++;
				return c;
			}
			i++;
			j=0;
		}
		return -1;
	}
	
}
