public class wc{
	private String expression = null;
	private String options = null,result = "";
	private boolean w = false,l = false,c = false,wr = false;
	private int len;
	private char[] tmp = null;

	public wc(String exp) {
		this.expression = exp;
	}

	public wc(String exp,String options) {
		this.expression = exp;
		this.options = options;
	}

	private int charCount() {
		return expression.length();
	}

	private int wordCount() {
		return expression.trim().split("\\W+").length;
	}

	private int lineCount() {
		return expression.split("\r\n|\r|\n").length;
	}

	private void giveAproval() {
		if(expression.matches("[^wlc]+")) {
			wr = true;
			w = c = l = false;
		}
	}

	private void findOption(char o) {
	if(o == 'w')
		w = true;
	if(o == 'l')
		l = true;
	if(o == 'c')
		c = true;
	}

	private void optionCreator() {
		for(int i = 0;i < len;i++) {
			if(tmp[i] == '-' && i+1 < len)
				findOption(tmp[i+1]);				
		} 
		giveAproval();
	}

	private void resultAsPerOption() {
		if(w == true) result += wordCount() + " ";
		if(l == true) result += lineCount() + " ";
		if(c == true) result += charCount() + " ";
	}

	private void giveResultAccordingToOption() {
		giveAproval();
		optionCreator();
		resultAsPerOption();
	}

	public String wcOutput() {
		if(options == null)
			result = wcBasicResult();
		else{
			tmp = options.toCharArray();
			len = options.length();
			giveResultAccordingToOption();
		}
		return result.trim();
	}

	private String wcBasicResult() {
		return lineCount() + " " + wordCount() + " " + charCount();
	}	
}