import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		CodeMaker cm = new CodeMaker();
		CheckIngave ci = new CheckIngave();
		Scanner scanner = new Scanner(System.in);
		String ingave = "";
		String code = cm.code();
		boolean checkCode = ci.checkCode(ingave, code);
		System.out.println(code);
		System.out.println("Welkom bij Mastermind. Je moet de code kraken. Typ een combinatie van a-f, vier letters lang (bijv. edcc).");
		while(checkCode == false) {
			ingave = scanner.nextLine();
			checkCode = ci.checkCode(ingave, code);
			if (checkCode == false) {
				System.out.println("Verkeerde code. Probeer het nog een keer");
			}
		}
		System.out.println("Gefeliciteerd, je hebt de code gekraakt!");
		

	}

}
class CodeMaker{
	Random random = new Random();
	char randomLetter() {
		int opvang = random.nextInt(6) + 97;
		char letter= (char)opvang;
		return letter;
	}
	String code(){
		char eersteLetter = randomLetter();
		char tweedeLetter = randomLetter();
		char derdeLetter = randomLetter();
		char vierdeLetter = randomLetter();
		char data[] = {eersteLetter, tweedeLetter, derdeLetter, vierdeLetter};
		String code = new String(data);
		return code;
	}
}

class CheckIngave{
	boolean checkCode(String a, String b){
		boolean checkCode = a.contentEquals(b);
		return checkCode;
	}
}