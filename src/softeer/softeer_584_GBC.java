package softeer;

import java.util.Scanner;

public class softeer_584_GBC {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// input
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] limit = new int[N][3];	// ���� �ӵ� : [��������][��������][�ӵ�]
		int[][] speed = new int[M][3];	// ���� �ӵ� : [��������][��������][�ӵ�]
		int answer = 0;
		
		for (int i = 0; i < N; i++) {	// ���Ѽӵ� �Է�
			limit[i][1] = sc.nextInt();
			limit[i][2] = sc.nextInt();
			
			if (i > 0) {
				limit[i][0] = limit[i-1][1] + 1;
				limit[i][1] += limit[i-1][1];
			}
		}
		for (int i = 0; i < M; i++) {	// �� ����ӵ� �Է�
			speed[i][1] = sc.nextInt();
			speed[i][2] = sc.nextInt();
			
			if (i > 0) {
				speed[i][0] = speed[i-1][1] + 1;
				speed[i][1] += speed[i-1][1];
			}
		}

		for (int i = 0; i < M; i++) {	// �� ���౸�� üũ
//			System.out.println("���� : ["+speed[i][0]+" ~ "+speed[i][1]+"] -> "+speed[i][2]);
			for (int j = 0; j < N; j++) {
				if (speed[i][0] <= limit[j][0] && limit[j][0] <= speed[i][1]
						|| speed[i][0] <= limit[j][1] && limit[j][1] <= speed[i][1]) {	// 1) �� ���౸��1 <= ���Ѽӵ� ����1 <= �� ���౸��1
					if (speed[i][2] >= limit[j][2]) {
						answer = Math.max(answer, speed[i][2] - limit[j][2]);
					}
//					System.out.println("���� : ["+limit[j][0]+" ~ "+limit[j][1]+"] -> "+limit[j][2]);
//					System.out.println("=> " + (speed[i][2] - limit[j][2]));
				} else if (limit[j][0] <= speed[i][0] && speed[i][1] <= limit[j][1]) {	// 2) ���Ѽӵ� ����1 <= �� ���౸��1 <= ���Ѽӵ� ����1
					if (speed[i][2] >= limit[j][2]) {
						answer = Math.max(answer, speed[i][2] - limit[j][2]);
					}
//					System.out.println("���� : ["+limit[j][0]+" ~ "+limit[j][1]+"] -> "+limit[j][2]);
//					System.out.println("=> " + (speed[i][2] - limit[j][2]));
				}
			}
		}
		
		System.out.println(answer);
	}

}

/*
(Input)
3 3
50 50
40 40
10 30
60 76
18 28
22 50
(Outputs)
36

(Input)
3 3
50 90
10 90
40 50
50 40
10 100
40 40
(Outputs)
10

(Input)
2 3
50 90
50 100
20 30
29 30
51 99
(Outputs)
9
*/