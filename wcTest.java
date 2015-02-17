import org.junit.Test;
import static org.junit.Assert.*;

public class wcTest{
	@Test
	public void charCount_001() {
		console.log("counts the number of a characters given string");
		String text = "hello, this is a good day. What do you think?";
		wc wC = new wc(text);
		assertEquals(wC.charCount(),45);
	}

	@Test
	public void wordCount_001() {
		console.log("counts the number of a words in the given string");
		String text = "hello, this is a good day. What do you think?";
		wc wC = new wc(text);
		assertEquals(wC.wordCount(),10);
	}

	@Test
	public void lineCount_001() {
		console.log("counts the number of a lines in the given string");
		String text = "hello, this is a good day.\n What do you think?";
		wc wC = new wc(text);
		assertEquals(wC.lineCount(),2);
	}
}