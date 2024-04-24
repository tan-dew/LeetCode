class Solution {
    public int tribonacci(int n) {
        int[] trib = new int[n + 1];
        
        Arrays.fill(trib, -1);
        
        return trib(n, trib);
    }
    
    int trib(int n, int[] trib){
        if (n < 0){
            return 0;
        }
        
        if (n == 0){
            trib[n] = 0;
            return trib[n];
        }
        
        if (n == 1){
            trib[n] = 1;
            return trib[n];
        }
        
        if (n == 2){
            trib[n] = 1;
            return trib[n];
        }
        
        if(trib[n] != -1){
            return trib[n];
        }
        
        trib[n] = trib(n - 1, trib) + trib(n - 2, trib) + trib(n - 3, trib);
        
        return trib[n];
    }
}