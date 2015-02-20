import org.junit.Test;
import static org.junit.Assert.*;

public class wcTest{
	@Test
	public void wcBasicResult_001() {
		console.log("Gives 2 10 48 for the given string");
		String text = "hello, this is a good day.\r\nWhat do you think?\r\n",result = "2 10 48";
		wc wC = new wc(text);
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void wordCount_001() {
		console.log("Gives 10 for the given string");
		String text = "hello, this is a good day.\n What do you think?",result = "10";
		wc wC = new wc(text,"-w");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void wordCount_002() {
		console.log("Gives 2 for the given string");
		String text = "hello, this is a good day.\n What do you think?",result = "2";
		wc wC = new wc(text,"-l");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void wordCount_003() {
		console.log("Gives 48 for the given string");
		String text = "hello, this is a good day.\r\nWhat do you think?\r\n",result = "48";
		wc wC = new wc(text,"-c");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void wordCount_004() {
		console.log("Gives 0 for the given string");
		String text = "",result = "0";
		wc wC = new wc(text,"-w");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void wordCount_005() {
		console.log("Gives 1 for the given string");
		String text = "word",result = "1";
		wc wC = new wc(text,"-w");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void wordCount_006() {
		console.log("Gives 2 for the given string");
		String text = "hello                                                     word",result = "2";
		wc wC = new wc(text,"-w");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void wordCount_007() {
		console.log("Gives 2 for the given string");
		String text = "hello      how  are you.            word",result = "5";
		wc wC = new wc(text,"-w");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void lineCount_003() {
		console.log("Gives 48 for the given string");
		String text = "hello, this is a good day.\r\nWhat do you think?\r\n",result = "26 hello, this is a good day";
		wc wC = new wc(text,"-L");
		assertEquals(wC.wcOutput(),result);
	}

	@Test
	public void lineCount_004() {
		console.log("Gives 48 for the given string");
		String text = "hello, this is a good day.\r\nWhat do you think?\r\n",result = "18 What do you think?";
		wc wC = new wc(text,"-S");
		assertEquals(wC.wcOutput(),result);
	}
}