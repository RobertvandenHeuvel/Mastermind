import java.util.Random;
import java.util.Scanner;

public class Mastermind {

	public static void main(String[] args) {
		CodeMaker cm = new CodeMaker();
		CheckIngave ci = new CheckIngave();
		Scanner scanner = new Scanner(System.in);
		String ingave = "";
		boolean checkLetter;
		boolean bevatLetter;
		char[] code = cm.data();
		String codeString = cm.code();
		boolean checkCode = ci.checkCode(ingave, cm.code());
		System.out.println(codeString);
		System.out.println("Welkom bij Mastermind. Je moet de code kraken. Voer een combinatie van a-f, vier letters lang (bijv. edcc) in.");
		System.out.println("Voer in (q) om te stoppen.");
		while(checkCode == false) {
			int aantalCorrecteLettersJuistePlek = 0;
			int aantalCorrecteLettersTotaal = 0;
			int aantalLettersVerkeerdePlek = 0;
			ingave = scanner.nextLine();
			switch(ingave) {
			case "q":
				System.out.println("Het spel is over.");
				System.exit(0);
				break;
			default:
				char[] ingaveCharArray = ci.ingaveNaarChar(ingave);
				char[] codeKopie = code;
				checkCode = ci.checkCode(ingave, cm.code());
				for (int i=0; i<ingaveCharArray.length; i++) {
					for (int j=0; j<codeKopie.length; j++) {
						checkLetter = ci.checkLetter(ingaveCharArray[i], codeKopie[j]);
						System.out.println("check " + ingaveCharArray[i] + " " + codeKopie[j]);
						System.out.println("initial: " + checkLetter);
						if (checkLetter == true && i == j) {
							aantalCorrecteLettersJuistePlek++;
							ingaveCharArray[i] = 'L';
							codeKopie[j] = 'I';
						}
						if (checkLetter == true && i != j) {
							aantalLettersVerkeerdePlek++;
							checkLetter = false;
							ingaveCharArray[i] = 'L';
							codeKopie[j] = 'I';
						}
						System.out.println("correction: " + checkLetter);
						
					}
				//	aantalLettersVerkeerdePlek = aantalCorrecteLettersTotaal - aantalCorrecteLettersJuistePlek;
			}
				System.out.println(aantalCorrecteLettersJuistePlek +" letter(s) staan op de juiste plek.");
				System.out.println(aantalLettersVerkeerdePlek + " letter(s) staan op de verkeerde plek.");
				break;
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