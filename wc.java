public class wc{
	private String expression = null,options = null,result = "";
	private boolean w = false,l = false,c = false,wr = false,Li = false,S = false;
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
		return expression.trim().split("\\s+").length;
	}

	private int lineCount() {
		return expression.split("\r\n|\r|\n").length;
	}

	private sentence giveLargeLine() {
		sentence s = new sentence();
		int start = 0,end,limit = charCount();
		char[] tmp = expression.toCharArray();
		for (int i = 0;i<limit;i++) {
			if(tmp[i] == '.'){
				end = i;
	        	if(s.count < (end - start)) {
	        		s.count = i+1;
	        		s.sentence = expression.substring(start,end);
	        		start = i+1;
	        	}
			}
        }
		return s;
	}

	// private sentence giveSmallLine() {
	// 	sentence s = new sentence();
	// 	int start = 0,end,limit = charCount();
	// 	char[] tmp = expression.toCharArray();
	// 	for (int i = 0;i<limit;i++) {
	// 		if(tmp[i] == '.' || i == limit-1){
	// 			end = i;
	// 			// if(tmp[i] == '\r' || tmp[i] == '\n' && tmp[i-1] == '.' || tmp[i-1] == '\r')
	// 				// start++;

	// 			if(start == 0) {
	// 				s.count = i+1;
	//         		s.sentence = expression.substring(start,end);
	//         		start = i+1;
	// 			}
	//         	if(s.count > (end - start)) {
	//         		s.count = i+1;
	//         		s.sentence = expression.substring(start,end);
	//         		start = i+1;
	//         	}
	// 		}
 //        }
	// 	return s;
	// }


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
	if(o == 'L')
		Li = true;
	if(o == 'S')
		S = true;
	}

	private void optionCreator() {
		for(int i = 0;i < len;i++) {
			if(tmp[i] == '-' && i+1 < len)
				findOption(tmp[i+1]);				
		} 
		giveAproval();
	}

	private void resultAsPerOption() {
		sentence s;
		if(w == true) result += wordCount() + " ";
		if(l == true) result += lineCount() + " ";
		if(c == true) result += charCount() + " ";
		if(Li == true) {
			s = giveLargeLine();
			result += s.count + " " + s.sentence + " ";
		}
		if(S == true) {
			s = giveSmallLine();
			result += s.count + " " + s.sentence + " ";
		} 
			
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