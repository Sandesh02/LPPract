
import java.util.*;

public class RRScheduling {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int quantum, sum = 0;
		System.out.println("*** RR Scheduling (Preemptive) ***");
		System.out.print("Enter Number of Process: ");
		int n = sc.nextInt();
		int burstTime[] = new int[n];
		int waitingTime[] = new int[n];
		int TAT[] = new int[n];
		int completionTime[] = new int[n];
		int remburstTime[] = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.print("Enter Burst Time for processor " + (i + 1) + " : ");
			burstTime[i] = sc.nextInt();
		}
		System.out.print("Enter Time quantum:");
		quantum = sc.nextInt();
		for (int i = 0; i < n; i++) {
			remburstTime[i] = burstTime[i];
			waitingTime[i] = 0;
		}
		do {
			for (int i = 0; i < n; i++) {
				if (burstTime[i] > quantum) {
					burstTime[i] -= quantum;
					for (int j = 0; j < n; j++) {
						if ((j != i) && (burstTime[j] != 0)) {
							waitingTime[j] += quantum;
						}
					}
				} else {
					for (int j = 0; j < n; j++) {
						if ((j != i) && (burstTime[j] != 0))
							waitingTime[j] += burstTime[i];
					}
					burstTime[i] = 0;
				}
			}
			sum = 0;
			for (int i = 0; i < n; i++)
				sum = sum + burstTime[i];
		}

		while (sum != 0);
		System.out.println("*** RR Scheduling (Preemptive) ***");
		System.out.println("Processor\tBrust time\tCompletion Time\t\tTurn around time\tWaiting time");
		System.out
				.println("------------------------------------------------------------------------------------------");
		for (int i = 0; i < n; i++) {
			completionTime[i] = waitingTime[i] + remburstTime[i];
			TAT[i] = completionTime[i];
			System.out.println("P" + (i + 1) + "\t\t" + remburstTime[i] + "ms\t\t" + completionTime[i] + "ms\t\t\t"
					+ TAT[i] + "ms\t\t\t" + waitingTime[i] + "ms");
		}
		float avg_wt = 0;
		float avg_tat = 0;
		for (int i = 0; i < n; i++) {
			avg_wt += waitingTime[i];
			avg_tat += TAT[i];
		}
		System.out.println("Average waiting time: " + (avg_wt / n) + "\nAverage turn around time: " + (avg_tat / n));
	}

}
