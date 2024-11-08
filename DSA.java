public class DSA{
    public String reverseAString(String x){
        StringBuilder reversedString = new StringBuilder();
        for(int i = x.length()-1;i>=0;i--){
            reversedString.append(x.charAt(i));
        }
        return reversedString.toString();
    }
    public boolean primeNumber(int n){
        int sum=0;
        for(int i = 1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        if(sum>1){
            return false;
        }
        else{
            return true;
        }
    }
    public int largest(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) { 
            if (arr[i] > res) {
                res = arr[i];
            }
        }
        return res;
    }
    public boolean palindrome(String s){
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }
}
    