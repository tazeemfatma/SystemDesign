package Questions;

public class LongestCommonSubsequence {
    static String x = "aab";
   // static String y = "abedfhr";
    static String rev="";
    static String y = new StringBuffer(x).reverse().toString();
    public static  void main(String[] args) {
        System.out.println("x="+x);
       System.out.println("y"+y);
        int n=x.length();
        int m=y.length();
        int l=LCS(n,m);
        System.out.println(l);
        System.out.println(rev);
        int len=LCSDP(n,m);
        System.out.println(len);
        int count= countPS(0,n-1);
        System.out.println("count="+count);
    }

    private static int countPS(int m, int n) {
        int dp[][]=new int[n][n];
        int i,j;
       for(i=0;i<n+1;i++){
            for(j=0;j<n+1;j++){
                if(m==n)
                    dp[m][n]=1;
                else if(m>n)
                    dp[m][n]=0;
                else if(x.charAt(m)==x.charAt(n)){
                    dp[m][n]=1+dp[m+1][n]+dp[m][n-1];
                }
                else{
                    dp[m][n]=dp[m+1][n]+dp[m][n-1]-dp[m+1][n-1];
                }
           }
       }
        return dp[0][n-1];
    }

    private static int LCSDP(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        int i,j;
        for(i=0;i<m+1;i++){
            for(j=0;j<n+1;j++){
                if(i==0||j==0)
                    dp[i][j]=0;
                else{
                    if(x.charAt(i-1)==y.charAt(j-1))
                        dp[i][j]=1+dp[i-1][j-1];
                    else
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    private static int LCS(int n, int m) {

        if(n==0||m==0)
            return 0;
        if(x.charAt(n-1)==y.charAt(m-1)){
       //     System.out.println(x.charAt(n-1));
            rev=rev+x.charAt(n-1);
            return 1+LCS(n-1,m-1);
        }else{
            return Math.max(LCS(n,m-1),LCS(n-1,m));
        }
    }

}
