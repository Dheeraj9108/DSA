class Solution {
    public boolean checkValidString(String s) {
        int cnt = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '*') cnt++;
            else cnt--;
            
            if(cnt < 0) return false;
        }
        
        cnt = 0;
        for(int i = n-1;i>=0;i--){
            if(s.charAt(i) == '*' || s.charAt(i) == ')') cnt++;
            else cnt--;
            
            if(cnt < 0) return false;
        }
        return true;
    }
}


// **((*)**((*)

// *(****()))))))

// ****((((