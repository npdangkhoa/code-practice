package multithread.jdk_08.example10_Parallel;

import java.util.Arrays;
import java.util.List;

public class Client03 {

	public static Integer transform(Integer e) {
		System.out.println("t: " + e + "--" + Thread.currentThread());
		sleep(1000);

		return e;
	}

	
	public static void printIt(Integer e) {
		System.out.println("p: " + e + "--" + Thread.currentThread());
	}
	
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.parallelStream()
			.map(e -> transform(e))
			.forEachOrdered(e -> printIt(e));
	}

	private static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
