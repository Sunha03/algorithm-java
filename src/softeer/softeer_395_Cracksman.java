package softeer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class softeer_395_Cracksman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		int answer = 0;
		int W = sc.nextInt();	// �賶 ����
		int N = sc.nextInt();	// ���� ������ ��
		int[][] jewerly = new int[N][2];	// ���� : [����][���Դ� ����]
		for (int i = 0; i < N; i++) {
			jewerly[i][0] = sc.nextInt();
			jewerly[i][1] = sc.nextInt();
		}
		
		Arrays.sort(jewerly, new Comparator<int[]>() {	// ���Դ� ������ �������� �������� ����
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o2[0] - o1[0];
				} else {
					return o2[1] - o1[1];
				}
			}
		});
		
		int total = 0;
		int i = 0;
		while (total <= W) {
			if (jewerly[i][0] <= W - total) {			// ���� ���� ���� <= �ܿ� �賶 ����
				total += jewerly[i][0];
				answer += jewerly[i][1] * jewerly[i][0];
				i++;
			} else if (jewerly[i][0] > W - total) {		// ���� ���� ���� > �ܿ� �賶 ����
				answer += jewerly[i][1] * (W - total);
				total = W + 1;
				break;
			}
			
			if (i >= jewerly.length) {
				break;
			}
		}
		
		System.out.println(answer);
	}

}

/*
(Input)
100 2
90 1
70 2
(Outputs)
170
 */