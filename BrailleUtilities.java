package hw2;

public class BrailleUtilities {

	public static final String RAISED = "\u2022";
	public static final String UNRAISED = "\u00b7";
	public static final String LETTER_SPACER = "  ";
	public static final String WORD_SPACER = "    ";

	public static String translateTopLine(String topLine) {
		String a = topLine.replaceAll(" ", WORD_SPACER);
		String b = a.toLowerCase();
		String c = b.replaceAll("[abehkloruvz]", RAISED + UNRAISED + LETTER_SPACER);
		String d = c.replaceAll("[cdfgmnpqxy]", RAISED + RAISED + LETTER_SPACER);
		String e = d.replaceAll("[ijstw]", UNRAISED + RAISED + LETTER_SPACER);
		return e.trim();
	}
	
	public static String translateMiddleLine(String middleLine) {
		String a = middleLine.replaceAll(" ", WORD_SPACER);
		String b = a.toLowerCase();
		String c = b.replaceAll("[biflpsv]", RAISED + UNRAISED + LETTER_SPACER);
		String d = c.replaceAll("[ghjqrtw]", RAISED + RAISED + LETTER_SPACER);
		String e = d.replaceAll("[denoyz]", UNRAISED + RAISED + LETTER_SPACER);
		String f = e.replaceAll("[ackmux]", UNRAISED + UNRAISED + LETTER_SPACER);
		return f.trim();
	}
	
	public static String translateBottomLine(String bottomLine) {
		String a = bottomLine.replaceAll(" ", WORD_SPACER);
		String b = a.toLowerCase();
		String c = b.replaceAll("[klmnopqrst]", RAISED + UNRAISED + LETTER_SPACER);
		String d = c.replaceAll("[uvxyz]", RAISED + RAISED + LETTER_SPACER);
		String e = d.replaceAll("[w]", UNRAISED + RAISED + LETTER_SPACER);
		String f = e.replaceAll("[abcdefghij]", UNRAISED + UNRAISED + LETTER_SPACER);
		return f.trim();
	}
	
	public static String translate(String text) {
		String braille = String.format("%s%n%s%n%s%n", translateTopLine(text), translateMiddleLine(text), translateBottomLine(text));
		return braille;
	}
	
}
