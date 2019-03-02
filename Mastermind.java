import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		CodeMaker cm = new CodeMaker();
		CheckIngave ci = new CheckIngave();
		Scanner scanner = new Scanner(System.in);
		String ingave = "";
		char[] code = cm.data();
		String codeString = cm.code();
		boolean checkCode = ci.checkCode(ingave, cm.code());
		System.out.println(codeString);
		System.out.println("Welkom bij Mastermind. Je moet de code kraken. Typ een combinatie van a-f, vier letters lang (bijv. edcc).");
		while(checkCode == false) {
			ingave = scanner.nextLine();
			char[] ingaveCharArray = ci.ingaveNaarChar(ingave);
			checkCode = ci.checkCode(ingave, cm.code());
			if (checkCode == false) {
				System.out.println("Verkeerde code. Probeer het nog een keer");
			}
			boolean checkEersteLetter = ci.checkLetter(ingaveCharArray[0], code[0]);
			if(checkEersteLetter == true) {
				System.out.println("De eerste letter matcht.");
			}
			boolean checkTweedeLetter = ci.checkLetter(ingaveCharArray[1], code[1]);
			if(checkTweedeLetter == true) {
				System.out.println("De tweede letter matcht.");
			}
			boolean checkDerdeLetter = ci.checkLetter(ingaveCharArray[2], code[2]);
			if(checkDerdeLetter == true) {
				System.out.println("De derde letter matcht.");
			}
			boolean checkVierdeLetter = ci.checkLetter(ingaveCharArray[3], code[3]);
			if(checkVierdeLetter == true) {
				System.out.println("De vierde letter matcht.");
			}
		}
		System.out.println("Gefeliciteerd, je hebt de code gekraakt!");
		

	}

}
class CodeMaker{
	Random random = new Random();
	char eersteLetter;
	char tweedeLetter;
	char derdeLetter;
	char vierdeLetter;
	char[] data = new char[4];
	char randomLetter() {
		int opvang = random.nextInt(6) + 97;
		char letter= (char)opvang;
		return letter;
	}
	char[] data(){
		eersteLetter = randomLetter();
		tweedeLetter = randomLetter();
		derdeLetter = randomLetter();
		vierdeLetter = randomLetter();
		data[0] = eersteLetter;
		data[1] = tweedeLetter;
		data[2] = derdeLetter;
		data[3] = vierdeLetter;
		return data;
	}
	String code() {
		String code = new String(data);
		return code;
	}
}

class CheckIngave{
	boolean checkCode(String a, String b){
		boolean checkCode = a.contentEquals(b);
		return checkCode;
	}
	char[] ingaveNaarChar(String ingave) {
		char[] ingaveChar = ingave.toCharArray();
		return ingaveChar;
	}
	boolean checkLetter(char a, char b){
		boolean checkLetter = false;
		if (a == b) {
			checkLetter = true;
		}
		return checkLetter;
	}
}