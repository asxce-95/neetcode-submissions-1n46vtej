class Solution {
    public String longestPalindrome(String s) {
        int n= s.length();
        char[] c = s.toCharArray();
        int a[][] = new int[n][n];

        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){

                if(i==j){
                    a[i][j] = 1;
                } else {
                    a[i][j] = 0;
                }

            }

        }

        //pa("Start", a);

        for(int j = 0; j<n; j++){
            for(int i = 0; i<j; i++){

                if(c[j] != c[i]){

                    a[i][j] = 0;
                    
                } else {
                    if(i+1 == j){
                        a[i][j] = 2;
                        continue;
                    }
                    if(a[i+1][j-1] == 0){
                         a[i][j] = 0;
                    } else {
                         a[i][j] = a[i+1][j-1] + 2;
                    }
                }



            }


               // pa("Iteration "+ j, a);

        }


                pa("End ", a);
        int st = 0, e = 0, mx = 0;

        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){

                if(a[i][j] > mx){
                    st = i;
                    e = j;
                    mx = a[i][j];
                }
                

            }

        }


        return s.substring(st, e+1);
        
    }

    public static void pa(String message, int[][] array) {
        System.out.println(message);
        
        for (int[] row : array) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public  void pa2(String message, int[][] array) {
        System.out.println(message);
        System.out.println("-------------------------");

        for (int[] row : array) {
            System.out.print("| ");
            for (int val : row) {
                System.out.print(val + " "); // formatted for alignment
            }
            System.out.println("|");
        }

        System.out.println("-------------------------\n");
    }
}
