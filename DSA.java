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

    public void printArray(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            System.out.println(arr[i]+" ");
        }
        System.out.println();
    }

    public void bubbleSort(int[] arr){
        int n = arr.length;
        boolean isSwapped;
        for(int i=0;i<n-1;i++){
            isSwapped = false;
            for(int j=0;j<n-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped == false) break;
        }
    }

    public void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=0;i<n;i++){
            int temp = arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>temp){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = temp;
        }
    }

    void threeNumberSort(int[] arr){
        int i=0;
        int j=0;
        int k=arr.length-1;
        while(i<=k){
            if(arr[i]==0){
                swap(arr,i,j);
                i++;
                j++;
            }
            else if(arr[i]==1){
                i++;
            }
            else if(arr[i]==2){
                swap(arr,i,k);
                k--;
            }
        }
    }
   
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort(int[] arr,int low,int high){
        if(low<high){
            int p = partition(arr,low,high);
            quickSort(arr, low, high);
            quickSort(arr, low, high);
        }
    }

    public int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int j = low;
        int i = low;
        while(i<=high){
            if(arr[i] <= pivot){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }

    public int[] sortedSquares(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        int i = 0,j = n-1;
        for(int k=n-1;k>=0;k--){
            if(Math.abs(arr[i])>Math.abs(arr[j])){
                result[k] = arr[i] * arr[i];
                i++;
            }
            else{
                result[k] = arr[j] * arr[j];
                j--;
            }
        }
        return result;
    }

    public void arrangeMaxMin(int[] arr){
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int max = arr[maxIdx] + 1;
        for(int i=0;i<arr.length;i++){
            if(2% == 0){
                arr[i] = arr[i] + (arr[maxIdx]%max) * max;
                maxIdx--;
            }
            else{
                arr[i] = arr[i] + (arr[minIdx]%max) * max;
                minIdx++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = arr[i]/max;
        }
    }
    public static void main(String[] args){
        int[] arr = {3,6,2,7,1,8};
        DSA dsa= new DSA();4
        dsa.bubbleSort(arr);
        dsa.printArray(arr);
    }

}
    