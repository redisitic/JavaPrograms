public class LCSDP {
    public static String longestCommonSubstring(String s1, String s2){
        return LCS(s1, s2, 0, s1.length() - 1, s2.length());
    }
    public static String LCS(String s1, String s2, int start, int end, int m){
        if (end - start + 1 <= 4) {
            return computeLCS(s1.substring(start, end + 1), s2);
        }
        int mid = (start + end) / 2;
        String leftLCS = LCS(s1, s2, start, mid, m);
        String rightLCS = LCS(s1, s2, mid + 1, end, m);
        return leftLCS + rightLCS;
    }
    public static String computeLCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        int maxLength = 0;
        int endIndex = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i - 1;
                    }
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        if (maxLength > 0) {
            return s1.substring(endIndex - maxLength + 1, endIndex + 1);
        } else{
            return "";
        }
    }
    public static void main(String[] args){
        String s1 = "qhvtntzofziwrsxgfruozylrzzbrpcuf";
        String s2 = "joihojfhntqmupaqchotufcwvijhkqbm";
        String lcs = longestCommonSubstring(s1, s2);
        System.out.println("Longest Common Substring: " + lcs);
    }
}