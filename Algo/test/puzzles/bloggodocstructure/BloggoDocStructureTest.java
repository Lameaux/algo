package puzzles.bloggodocstructure;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import puzzles.bloggodocstructure.BloggoDocStructure;

public class BloggoDocStructureTest {

	BloggoDocStructure blog;

	@Before
	public void init() {
		blog = new BloggoDocStructure();
	}

	@Test
	public void test0() {

		String[] docA = new String[] { "<html> <h1>Snapping Turtles</h1> <ul> <li> <h2>", "Common Snapping Turtle (<i>Chelydra serpentina</i>",
				") </h2> <p> With its dark coloring, sinuous neck,", "and swift lunging motion, Chelydra serpentina is a",
				"n adept hunter. </p><p> The snapping turtle rarely", "basks. </p><p> Snapping turtle populations are jeo",
				"pardized by automobile traffic.   </", "p>    </li> <li> <h2> Alligator Snapping Turtle (",
				"<i>Macroclemys temminckii</i>) </h2> <p> Like the", " common snapping turtle, the alligator snapping ",
				"turtle has a massive head.</p><p>This is the lar", "gest freshwater turtle. A tubular pink append", "age grows from its mouth.</p>   <",
				"/li> </ul> </html>" };

		String[] docB = new String[] { " <html> turtles <h1> snapping </h1> <ul> <li> <h2", "> common <i> chelydra serpentina </i> </h2> <p>",
				"hunter </p> (adept?) <p> rarely basks </p> (hmm)", "<p> jeopardized by traffic </p></li>", "<li> often confused with... <h2> alligator snapp",
				"ing turtle <i>macroclemys temminckii</i> </h2>", "<p> massive head </p> big! <p>", "largest freshwater turtle. pink wormlike thing <",
				"/p></li></ul></html>  " };

		String result = "equivalent";

		assertEquals(result, blog.compare(docA, docB));
	}

	@Test
	public void test1() {

		String[] docA = new String[] { " <html> turtles <h1> snapping </h1> <ul> <li> <h2", "> common <i> chelydra serpentina </i> </h2> <p>",
				"hunter </p> (adept?) <p> rarely basks </p> (hmm)", "<p> jeopardized by traffic </p></li>", "<li> often confused with... <h2> alligator snapp",
				"ing turtle <i>macroclemys temminckii</i> </h2>", "<p> massive head </p> big! <p>", "largest freshwater turtle. pink wormlike thing <",
				"/p></li></ul></html>  " };

		String[] docB = new String[] { "<html><h1></h1><ul><li><h2><i></i></h2><p></p><p>", "</p><p></p></li><li><h2><i></i></h2><p></p><p></p",
				"></li></ul></html>" };

		String result = "equivalent";

		assertEquals(result, blog.compare(docA, docB));
	}

	@Test
	public void test2() {

		String[] docA = new String[] { "<html><h1></h1><ul><li><h2><i></i></h2><p></p><p>", "</p><p></p></li><li><h2><i></i></h2><p></p><p></p",
				"></li></ul></html>" };

		String[] docB = new String[] { " <html> snapping turtles <ul> <li> common ", "snapping turtle, chelydra serpentina <p>",
				"hunter </p> <p> rarely basks </p> ", "<p> jeopardized by traffic </p></li>", "<li> often confused with... <h2> alligator snapp",
				"ing turtle <i>macroclemys temminckii</i> </h2>", "<p> massive head; largest freshwater turtle;", "pink wormlike appendage lures fish </p>",
				"</li></ul></html>  " };

		String result = "outtree 4";

		assertEquals(result, blog.compare(docA, docB));
	}

	@Test
	public void test3() {

		String[] docA = new String[] { "<html><h1></h1><ul><li><h2><i></i></h2><p></p><p>", "</p><p></p></li><li><h2><i></i></h2><p></p><p></p",
				"></li></ul></html>" };

		String[] docB = new String[] { " <html> turtles <h1> snapping </h1> <ul> <li> <h2", "> common <i> chelydra serpentina </i> </h2> <p>",
				"hunter </p> <p> rarely basks <h3>", "<i>almost</i> <b>never</b> </h3> </p>", "<p> jeopardized by traffic </p></li>",
				"<li> often confused with... <h2> alligator snapp", "ing turtle <i>macroclemys temminckii</i> </h2>", "<p> massive head </p> big! <p>",
				"largest freshwater turtle. </p> <p> <b>pink</b>", " <b>wormlike</b> lure in mouth </p> <p> imposing",
				"sight on land or water </p> </li></ul></html>  " };

		String result = "intree 7";

		assertEquals(result, blog.compare(docA, docB));
	}

	@Test
	public void test4() {

		String[] docA = new String[] { "<html><h1></h1><ul><li><h2><i></i></h2><p></p><p>", "</p><p></p></li><li><h2><i></i></h2><p></p><p></p",
				"></li></ul></html>" };

		String[] docB = new String[] { "<html><ul><li><h2><i></i></h2><p></p><p>", "</p><p></p></li><li><h2><i></i></h2><p></p><p></p",
				"></li></ul><h1></h1></html>" };

		String result = "incompatible";

		assertEquals(result, blog.compare(docA, docB));
	}

	@Test
	public void test5() {

		String[] docA = new String[] { "<html></html>" };

		String[] docB = new String[] { "<html><html><html></html><html></html><ul>", "</ul><ol></ol></html></html>" };

		String result = "intree 5";

		assertEquals(result, blog.compare(docA, docB));
	}

	@Test
	public void test6() {

		String[] docA = new String[] { "<html><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><b></b></html>" };

		String[] docB = new String[] { "<html><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p><p></p>",
				"<p></p><p></p><p></p><p></p><p></p><p></p><p></p>", "<p></p><p></p><p></p><p></p><p></p><p></p></html>" };

		String result = "incompatible";

		assertEquals(result, blog.compare(docA, docB));
	}

}
