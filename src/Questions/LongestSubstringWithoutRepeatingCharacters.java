package Questions;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        String str="a";
        longestSubString(str);
        longestSubString2(str.toUpperCase());
    }

    private static void longestSubString2(String str) {
        int charFreq[]=new int[26];
        int maxLen=1;
        int count=1;
        String res=String.valueOf(str.charAt(0));String s= String.valueOf(str.charAt(0));
        charFreq[str.charAt(0)-'A']++;
        for(int i = 1; i< str.length(); i++) {
        char z=str.charAt(i);
        if(charFreq[z-'A']>0){
            if(count>maxLen){
                maxLen=count;
                res=s;
                charFreq=new int[26];
                s= String.valueOf(z);
                count=0;
            }

        }else {
            charFreq[z - 'A']++;
            count++;
            s=s+z;
        }
        }
        System.out.println("new="+maxLen+" -->"+res);
    }

    private static void longestSubString(String str) {
        int maxLen=1;
        String longestString= String.valueOf(str.charAt(0));
        String result=String.valueOf(str.charAt(0));
        for(int i = 1; i< str.length(); i++){
            if(longestString.contains(String.valueOf(str.charAt(i)))){
                if(longestString.length()>maxLen){
                    maxLen=longestString.length();
                    result=longestString;
                    longestString= String.valueOf(str.charAt(i));
                }

            }else{
                longestString=longestString+ str.charAt(i);
            }
        }
        System.out.println(maxLen);
        System.out.println(result);
    }
}
