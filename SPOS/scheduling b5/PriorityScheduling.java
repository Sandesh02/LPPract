
import java.util.*;

class PriorityScheduling {

	public static void main(String[] args) {

		System.out.println("*** Priority Scheduling (Non Preemptive) ***");

		System.out.print("Enter Number of Process: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String process[] = new String[n];
		int arrivaltime[] = new int[n];
		int burstTime[] = new int[n];
		int completionTime[] = new int[n];
		int priority[] = new int[n];
		int totalWT = 0;
		int totalTAT = 0;
		double avgWT;
		double avgTAT;
		for (int i = 0; i < n; i++) {
			process[i] = "P" + (i + 1);
			System.out.print("Enter Arrival Time for processor " + (i + 1) + ":");
			arrivaltime[i] = sc.nextInt();
			System.out.print("Enter Burst Time for processor " + (i + 1) + " : ");
			burstTime[i] = sc.nextInt();
			System.out.print("Enter Priority for " + (i + 1) + " process: ");
			priority[i] = sc.nextInt();
		}

		// Sorting process & burst time by priority
		int temp;
		String temp2;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (priority[j] > priority[j + 1]) {
					temp = priority[j];
					priority[j] = priority[j + 1];
					priority[j + 1] = temp;

					temp = burstTime[j];
					burstTime[j] = burstTime[j + 1];
					burstTime[j + 1] = temp;

					temp = arrivaltime[j];
					arrivaltime[j] = arrivaltime[j + 1];
					arrivaltime[j + 1] = temp;

					temp2 = process[j];
					process[j] = process[j + 1];
					process[j + 1] = temp2;

				}
			}
		}
		int TAT[] = new int[n + 1];
		int waitingTime[] = new int[n + 1];
		completionTime[0] = burstTime[0];
		// Calculating Waiting Time & Turn Around Time
		for (int i = 0; i < n - 1; i++) {
			completionTime[i + 1] = completionTime[i] + burstTime[i + 1];
		}
		System.out.println("*** Priority Scheduling (Non Preemptive) ***");
		System.out.println("Processor\tArrival time\tBrust time\tCompletion Time\t\tTurn around time\tWaiting time");
		System.out.println(
				"----------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < n; i++) {
			TAT[i] = completionTime[i] - arrivaltime[i];
			waitingTime[i] = TAT[i] - burstTime[i];
			System.out.println(process[i] + "\t\t" + arrivaltime[i] + "ms\t\t" + burstTime[i] + "ms\t\t"
					+ completionTime[i] + "ms\t\t\t" + TAT[i] + "ms\t\t\t" + waitingTime[i] + "ms");
			totalTAT += (waitingTime[i] + burstTime[i]);
			totalWT += waitingTime[i];

		}
		avgWT = totalWT / (double) n;
		avgTAT = totalTAT / (double) n;
		System.out.println("\nAverage Wating Time: " + avgWT);
		System.out.println("Average Turn Around Time: " + avgTAT);

	}
}
