
import java.util.*;

public class SJF {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*** Shortest Job First Scheduling (Preemptive) ***");
		System.out.print("Enter no of process:");
		int n = sc.nextInt();
		String process[] = new String[n]; // it takes pid of process
		int arrivaltime[] = new int[n]; // at means arrival time
		int burstTime[] = new int[n]; // bt means burst time
		int completionTime[] = new int[n]; // ct means complete time
		int TAT[] = new int[n];// ta means turn around time
		int waitingTime[] = new int[n]; // wt means waiting time
		int flag[] = new int[n]; // f means it is flag it checks process is completed or not
		int remburstTime[] = new int[n]; // it is also stores brust time
		int st = 0, tot = 0;
		float avgwt = 0, avgta = 0;

		for (int i = 0; i < n; i++) {
			process[i] = "P" + (i + 1);
			System.out.print("Enter Arrival Time for processor " + (i + 1) + ":");
			arrivaltime[i] = sc.nextInt();
			System.out.print("Enter Burst Time for processor " + (i + 1) + ": ");
			burstTime[i] = sc.nextInt();
			remburstTime[i] = burstTime[i];
			flag[i] = 0;
		}
		while (true) {
			int min = 99, c = n;
			if (tot == n) {
				break;
			}
			for (int i = 0; i < n; i++) {
				if ((arrivaltime[i] <= st) && (flag[i] == 0) && (burstTime[i] < min)) {
					min = burstTime[i];
					c = i;
				}
			}

			if (c == n) {
				st++;
			} else {
				burstTime[c]--;
				st++;
				if (burstTime[c] == 0) {
					completionTime[c] = st;
					flag[c] = 1;
					tot++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			TAT[i] = completionTime[i] - arrivaltime[i];
			waitingTime[i] = TAT[i] - remburstTime[i];
			avgwt += waitingTime[i];
			avgta += TAT[i];
		}
		System.out.println("*** Shortest Job First Scheduling (Preemptive) ***");
		System.out.println("Processor\tArrival time\tBrust time\tCompletion Time\t\tTurn around time\tWaiting time");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < n; i++) {
			System.out.println(process[i] + "\t\t" + arrivaltime[i] + "ms\t\t" + remburstTime[i] + "ms\t\t"
					+ completionTime[i] + "ms\t\t\t" + TAT[i] + "ms\t\t\t" + waitingTime[i] + "ms");
		}

		System.out.println("\nAverage turn around time is " + (float) (avgta / n));
		System.out.println("Average waiting time is " + (float) (avgwt / n));
		sc.close();
	}

}
