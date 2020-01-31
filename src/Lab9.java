import java.util.*;

public class Lab9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		ArrayList<String> cart = new ArrayList<>();
		ArrayList<Double> bill = new ArrayList<>();
		int[] count = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		Map<String, Double> shopList = new HashMap<>();
		shopList.put("APPLE", 0.99);
		shopList.put("STEAK", 12.99);
		shopList.put("MILK", 10.99);
		shopList.put("LOBSTER", 20.99);
		shopList.put("SPAM", 2.99);
		shopList.put("COD", 7.99);
		shopList.put("CARROT", 1.50);
		shopList.put("CHEESE", 6.99);
		shopList.put("COOKIE", 1.99);
		shopList.put("SUSPICIOUS MEAT", 6.99);

		System.out.println("Welcome to the Java Grocery! Your menu options are:");
		System.out.println("================");
		showList(shopList);
		System.out.println("What Would you like to buy?");
		do {

			System.out.println("Enter the name or number of the item you wish to purchase:");
			String ans = scanner.nextLine().trim().toUpperCase();
			ans = buy(ans);

			if (shopList.containsKey(ans)) {
				if (!cart.contains(ans)) {
					addItem(cart, ans);
					addPrice(bill, shopList.get(ans));
					count[cart.indexOf(ans)] = 1;
				} else {
					count[cart.indexOf(ans)] += 1;

				}
				System.out.println("Good choice");
				System.out.println("Would you like to buy something else?");
				loop = looper();
			} else {
				System.out.println("That is not available");
				System.out.println("Would you like to buy something else?");
			}

		} while (loop);

		System.out.println();
		System.out.println("You have bought:");
		wayBill(cart, bill, count);

		System.out.println();

		System.out.println("Your cheapest item was:");
		System.out.print(cart.get(getLowest(bill)));
		System.out.println("....$" + bill.get(getLowest(bill)));
		System.out.println();
		System.out.println("Your most expensive item was:");
		System.out.print(cart.get(getHighest(bill)));
		System.out.println("....$" + bill.get(getHighest(bill)));

		System.out.println();
		System.out.println("Thank you! Come again.");
		scanner.close();
	}

	public static String buy(String a) {
		switch (a) {
		case "1":
			return "APPLE";
		case "2":
			return "STEAK";
		case "3":
			return "COOKIE";
		case "4":
			return "LOBSTER";
		case "5":
			return "CHEESE";
		case "6":
			return "CARROT";
		case "7":
			return "COD";
		case "8":
			return "MILK";
		case "9":
			return "SPAM";
		case "10":
			return "SUSPICIOUS MEAT";
		case "APPLE":
			return "APPLE";
		case "STEAK":
			return "STEAK";
		case "COOKIE":
			return "COOKIE";
		case "LOBSTER":
			return "LOBSTER";
		case "CHEESE":
			return "CHEESE";
		case "CARROT":
			return "CARROT";
		case "COD":
			return "COD";
		case "MILK":
			return "MILK";
		case "SPAM":
			return "SPAM";
		case "SUSPICIOUS MEAT":
			return "SUSPICIOUS MEAT";
		default:
			return "a";
		}
	}

	public static int getLowest(ArrayList<Double> d) {
		double low = Double.POSITIVE_INFINITY;
		for (int i = 0; i < d.size(); i++) {
			if (low > d.get(i)) {
				low = d.get(i);
			}
		}
		return d.indexOf(low);
	}

	public static int getHighest(ArrayList<Double> d) {
		double high = 0;
		for (int i = 0; i < d.size(); i++) {
			if (high < d.get(i)) {
				high = d.get(i);
			}
		}

		return d.indexOf(high);
	}

	public static void wayBill(ArrayList<String> s, ArrayList<Double> d, int[] t) {
		double tot = 0;
		for (int i = 0; i < s.size(); i++) {
			int j = t[s.indexOf(s.get(i))];
			System.out.print(t[s.indexOf(s.get(i))]);
			System.out.print(" " + s.get(i));
			System.out.print(" ($" + d.get(i) + ")");
			double n = (d.get(i) * j);
			System.out.println("....$" + deciRound(n, 2));
			tot += n;
		}
		int count = 0;
		for (int x = 0; x < t.length; x++) {
			count += t[x];
		}

		double avg = tot / count;
		System.out.println();
		System.out.print("Your total bill is.....");
		System.out.println("$" + deciRound(tot, 2));
		System.out.println();
		System.out.print("Your average cost was....");
		System.out.println("$" + deciRound(avg, 2));

	}

	public static boolean looper() {
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		String looper = scanner.nextLine().trim().toLowerCase();
		if (looper.startsWith("n")) {
			loop = false;
		} else if (looper.startsWith("y")) {
			loop = true;
		} else {
			System.out.println("Sorry, I did not understand that. Please try again.");
			looper();
		}
		return loop;
	}

	public static void showList(Map<String, Double> mp) {
		Set<String> setOM = mp.keySet();
		int i = 1;
		for (String OM : setOM) {
			System.out.println(i + ". " + OM + "    " + mp.get(OM));

			i++;
		}

	}

	public static void addItem(ArrayList<String> list, String a) {
		list.add(a);
	}

	public static void addPrice(ArrayList<Double> list, Double a) {
		list.add(a);
	}

	public static double deciRound(double x, double y) {

		y = Math.pow(10, y);

		x = ((int) (Math.round(x * y)) / y);
		return x;
	}

}
