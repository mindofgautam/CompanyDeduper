public class LevenshteinDistance {

	public static int computeDistance(String s1, String s2) {
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		int[] costs = new int[s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			int lastValue = i;
			for (int j = 0; j <= s2.length(); j++) {
				if (i == 0)
					costs[j] = j;
				else {
					if (j > 0) {
						int newValue = costs[j - 1];
						if (s1.charAt(i - 1) != s2.charAt(j - 1))
							newValue = Math.min(Math.min(newValue, lastValue),
									costs[j]) + 1;
						costs[j - 1] = lastValue;
						lastValue = newValue;
					}
				}
			}
			if (i > 0)
				costs[s2.length()] = lastValue;
		}
		return costs[s2.length()];
	}

	public static int printDistance(String s1, String s2) {
//		System.out.println(s1 + "-->" + s2 + ": " + computeDistance(s1, s2));
		return computeDistance(s1, s2);
	}

	public static void main(String[] args) {
		printDistance("Gautam", "Amgaut");
		printDistance("twtter", "twtteri");
	}
}
