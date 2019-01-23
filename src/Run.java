

import java.util.List;

public class Run {

	public static void main(String[] args) {

		String userInput = Program.getUserinput();
		Program.setBuyers(userInput);
		userInput = Program.getUserinput();
		Program.setProducts(userInput);
		List<String> listOfComands = Program.getListOfComands();
		Program.executeComands(listOfComands);	
		Program.printBuyers();

	}

}
