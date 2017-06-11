public class DnaCompare {

	public static void main(String[] args) {
		String parent1 = "CATABACT";
		String parent2 = "CABBBBBA";
		String child = "CABCATCABCATBBBBBTC";
		String parent1Long = findLongSeq(parent1, child);
		String parent2Long = findLongSeq(parent2, child);

		if (parent1Long.length() > parent2Long.length()) {
			System.out.println("Primary Donor: Parent 1");
			System.out.println("Intact Sequence: " + parent1Long);
		}
		if (parent2Long.length() > parent1Long.length()) {
			System.out.println("Primary Donor: Parent 2");
			System.out.println("Intact Sequence: " + parent2Long);
		}
		if (parent1Long.length() == parent2Long.length()) {
			System.out.println("Sequences are equal in length");
		}
	}

	private static String findLongSeq(String parent, String child) {

		int max = parent.length();
		int min = 2;
		for (int subLength = max; subLength >= min; subLength--) {
			for (int chIndex = 0; chIndex <= child.length() - subLength; chIndex++) {
				String subsequence = child.substring(chIndex, chIndex + subLength);
				if (parent.contains(subsequence)) {
					return subsequence;
				}
			}
		}
		return parent.substring(0, 1);
	}
}
