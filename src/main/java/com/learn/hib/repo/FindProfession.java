package com.learn.hib.repo;

import java.util.Scanner;

public class FindProfession {

	public static char findProf(int l, int pos, char c) {

		if (l == 1)
			return 'E';
		if (l == 2 && pos == 1)
			return 'E';
		else if (l == 2 && pos == 2)
			return 'D';

		else {

			if (pos % 2 == 1) {

				if (findProf(l - 1, pos / 2 + 1, c) == 'D')
					return 'D';
				else
					return 'E';

			}

			else if (pos % 2 == 0) {
					if(findProf(l-1, pos/2, c)=='D')
						return 'E';
					else
						return 'D';
			}
		}
		
		return 'X';
	
	}

	public static void main(String[] args) {

		//Scanner sc = new Scanner(System.in);
		//int l = sc.nextInt();
		//int pos = sc.nextInt();

		System.out.println(findProf(5,10, 'E'));

	}

}
