
import java.util.Scanner;

public class Optimal {

	static boolean search(int key, int[] fr) {
		for (int i = 0; i < fr.length; i++)
			if (fr[i] == key)
				return true;
		return false;
	}

	static int predict(int pg[], int[] fr, int pn,
			int index) {
		int res = -1, farthest = index;
		for (int i = 0; i < fr.length; i++) {
			int j;
			for (j = index; j < pn; j++) {
				if (fr[i] == pg[j]) {
					if (j > farthest) {
						farthest = j;
						res = i;
					}
					break;
				}
			}

			if (j == pn)
				return i;
		}

		return (res == -1) ? 0 : res;
	}

	static void optimalPage(int pg[], int pn, int fn) {
		double mixRatio = 0, hitRatio = 0;
		int[] fr = new int[fn];
		double hit = 0;
		int index = 0;
		for (int i = 0; i < pn; i++) {

			if (search(pg[i], fr)) {
				hit++;
				continue;
			}

			if (index < fn)
				fr[index++] = pg[i];

			else {
				int j = predict(pg, fr, pn, i + 1);
				fr[j] = pg[i];
			}
		}
		mixRatio = ((pn - hit) / pn) * 100;
		hitRatio = (hit / pn) * 100;
		System.out.println("Page Fault: " + hit + "\nPage Hit: " + (pn - hit));
		System.out.printf("Hit Ratio:%.2f \nMix Ratio:%.2f ", hitRatio, mixRatio);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noofpages, capacity;
		System.out.print("Enter the number of pages you want to enter: ");
		noofpages = sc.nextInt();
		int pages[] = new int[noofpages];
		for (int i = 0; i < noofpages; i++) {
			pages[i] = sc.nextInt();
		}
		System.out.print("Enter the capacity of frame: ");
		capacity = sc.nextInt();
		optimalPage(pages, noofpages, capacity);
	}

}
