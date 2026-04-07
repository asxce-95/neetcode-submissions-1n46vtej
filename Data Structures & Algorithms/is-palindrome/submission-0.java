class Solution {
    public boolean isPalindrome(String ss) {
      String s = ss.toLowerCase();
        for(int i= 0 , j= s.length()-1 ; i<=j ;){
            char ini = s.charAt(i);



            if((ini < 'a' || ini > 'z') && ( ini < '0' || ini > '9')){
                i++;
                continue;
            }
            
            char last = s.charAt(j);
            if((last < 'a' || last > 'z') && (last < '0' || last > '9')){
                j--;
                continue;
            }

            if(ini == last){
                i++;
                j--;
            } else {
                return false;
            }

        }

        return true;
        
      
    }
}
