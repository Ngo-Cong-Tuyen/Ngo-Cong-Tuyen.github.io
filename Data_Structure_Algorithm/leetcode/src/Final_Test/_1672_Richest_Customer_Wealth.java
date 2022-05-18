package Final_Test;

public class _1672_Richest_Customer_Wealth {
    public static void main(String[] args) {
        int[][] account = {{1,2,3},{1,2,3}};
        System.out.println(maximumWealth(account));
    }

    public static int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int wealth = 0;
        for (int i = 0; i <m ; i++) {
            int sum= 0;
            for (int j = 0; j < n; j++) {
                sum = sum + accounts[i][j];
            }
            if (wealth< sum) wealth= sum;
        }
        return wealth;
    }
}
