class Solution {

    List<List<Integer>> soln = new ArrayList<>();
    List<List<String>> soln2 = new ArrayList<>();
        // Set<Integer> rs = new HashSet<>();
        // Set<Integer> cls = new HashSet<>();
        // Set<Integer> dg = new HashSet<>();
        // Set<Integer> rdg = new HashSet<>();


    public List<List<String>> solveNQueens(int n) {

        List<Integer> ans = new ArrayList<>();

        //System.out.println("Starting solveNQueens with n = " + n);

        f(0, 0, n, new ArrayList(), new HashSet(), new HashSet(), new HashSet(), new HashSet());

        System.out.println("Final soln: " + soln);


        for(List<Integer> st : soln){
            List<String> strList = new ArrayList<>();
            for(int pos: st){

                StringBuilder sb = new StringBuilder();
                for(int k = 0; k<n ; k++){
                    if(k == pos){
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                strList.add(sb.toString());
            }
            soln2.add(strList);
        }

        return soln2;
        
    }

    public void f(int r, int c, int n, List<Integer> ans, Set<Integer> rs, Set<Integer> cls, Set<Integer> dg, Set<Integer> rdg){

        //System.out.println("Called f with r=" + r + ", c=" + c + ", ans=" + ans + ", rs=" + rs + ", cls=" + cls + ", dg=" + dg + ", rdg=" + rdg);

        if(r == n){
            System.out.println("Base case reached: r == n, adding ans: " + ans);
            soln.add(new ArrayList(ans));
            return;
        }

        for(int i=0 ; i<n ; i++){

            //System.out.println("Checking Validity with r=" + r + ", c=" + i + ", ans=" + ans + ", rs=" + rs + ", cls=" + cls + ", dg=" + dg + ", rdg=" + rdg);

            boolean isInvalid = rs.contains(r) 
                    || cls.contains(i)
                    || dg.contains(r - i)
                    || rdg.contains(r + i);

            //System.out.println("Checking (r=" + r + ", i=" + i + "): " + (isInvalid ? "INVALID" : "VALID"));

            if(!isInvalid){
                // ans.add(i);
                // rs.add(r);
                // cls.add(i);
                // dg.add(r - i);
                // rdg.add(r + i);

                Set<Integer> rs1 = new HashSet<>(rs);
                Set<Integer> cls1 = new HashSet<>(cls);
                Set<Integer> dg1 = new HashSet<>(dg);
                Set<Integer> rdg1 = new HashSet<>(rdg);

                List<Integer> ans1 = new ArrayList(ans);
                ans1.add(i); 
                    rs1.add(r);
                    cls1.add(i);
                    dg1.add(r-i);
                    rdg1.add(r + i);

                //System.out.println("Placing queen: ans=" + ans + ", rs=" + rs + ", cls=" + cls + ", dg=" + dg + ", rdg=" + rdg);

                f(
                    r+1, 
                    0, 
                    n, 
                    ans1,
                    rs1,
                    cls1,
                    dg1,
                    rdg1
                );

                //System.out.println("Returning from recursion to r=" + r + ", i=" + i);
            } 
            
        }
    }
}
