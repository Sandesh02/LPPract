
import java.util.*;

public class fcfs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		float avgtat = 0, avgwt = 0;
		System.out.println("*** First Come First Serve Scheduling ***");
		System.out.print("Enter Number of Process: ");
		n = sc.nextInt();
		String process[] = new String[n];
		int arrivaltime[] = new int[n];
		int burstTime[] = new int[n];
		int TAT[] = new int[n];
		int waitingTime[] = new int[n];
		int completionTime[] = new int[n];
		for (int i = 0; i < n; i++) {
			process[i] = "P" + (i + 1);
			System.out.print("Enter Arrival Time for processor " + (i + 1) + ":");
			arrivaltime[i] = sc.nextInt();
			System.out.print("Enter Burst Time for processor " + (i + 1) + ": ");
			burstTime[i] = sc.nextInt();
		}
				
		completionTime[0] = burstTime[0];
		for (int i = 0; i < n - 1; i++) {
			completionTime[i + 1] = completionTime[i] + burstTime[i + 1];
		}

		System.out.println("*** First Come First Serve Scheduling ***");
		System.out.println("Processor\tArrival time\tBrust time\tCompletion Time\t\tTurn around time\tWaiting time");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < n; i++) {
			TAT[i] = completionTime[i] - arrivaltime[i];
			waitingTime[i] = TAT[i] - burstTime[i];
			avgtat += TAT[i];
			avgwt += waitingTime[i];
			System.out.println(process[i] + "\t\t" + arrivaltime[i] + "ms\t\t" + burstTime[i] + "ms\t\t"
					+ completionTime[i] + "ms\t\t\t" + TAT[i] + "ms\t\t\t" + waitingTime[i] + "ms");
		}
		System.out.println("Average turn around time of processor: " + (avgtat / n)
				+ "ms\nAverage waiting time of processor: " + (avgwt / n) + "ms");
	}

}
