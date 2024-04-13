package com.array.dp.cses;

import java.io.InputStreamReader;
import java.util.Scanner;

public class DiceCombinations {

  public static void main(String[] args) {
    DiceCombinations combinations = new DiceCombinations();
    // while (true) {
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    int number = scanner.nextInt();
    //if (number == -1) {
    //  break;
    //}
    combinations.countCombinations(number);
    // }
  }

  public long countCombinations(int n) {
    long[] dp = new long[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    long DIVISOR = ((long) Math.pow(10, 9) + 7);

    if (2 <= n) {
      dp[2] = 2;
    }

    for (int i = 3; i <= n; i++) {
      dp[i] = 0;
      for (int j = i - 1; j >= i-6 && j > -1; j--) {
        dp[i] =  ( (dp[i] % DIVISOR) + (dp[j] % DIVISOR) ) % DIVISOR;
      }

      if (i <= 6) {
        dp[i]++;
      }
    }

    long result = dp[n] % DIVISOR;
    System.out.println(result);
    return result;

  }

  //doesn't work beyond n > 6
  public int countCombinations2(int n) {
    if (n < 1) {
      return 0;
    }

    int result = ((int) Math.pow(2, n - 1)) % ((int) Math.pow(10, 9) + 7);
    System.out.println(result);
    return result;
  }
}
