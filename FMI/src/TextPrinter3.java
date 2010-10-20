import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextPrinter3 {
	Scanner sc = new Scanner(System.in);
	ArrayMultipleQueue<String> amq = new ArrayMultipleQueue<String>(26);
	Pattern pattern = Pattern.compile("\\b.*\\b");

	public String nextWord() {
		return sc.next(pattern);
	}

	public void solve() {
		String word;
		while (sc.hasNext()) {
			word = nextWord();
			addWord(word);
		}
		print();
	}

	private void addWord(String word) {
		try {
			amq.add(word, (Character.toLowerCase(word.charAt(0)) - 'a' + 1));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (InvalidNumberOfComponent e) {
			e.printStackTrace();
		}

	}

	private void print() {
		System.out.println("Print the AMQ:");
		for (int i = 0; i < 26; i++) {
			try {
				if (amq.getQueue(i + 1).size() > 0) {
				System.out.print((char) ('A' + i));
				System.out.print(" : " );
				try {
					Iterator<String> it = amq.getQueue(i + 1).iterator();
					while (it.hasNext()) {
						System.out.print(it.next() + " ");
					}
				} catch (InvalidNumberOfComponent e) {
					e.printStackTrace();
				}
				System.out.print("\n");
				}
			} catch (InvalidNumberOfComponent e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		TextPrinter3 tp3 = new TextPrinter3();
		tp3.solve();
	}
}
