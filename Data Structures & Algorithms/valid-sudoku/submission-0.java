class Solution {
    public boolean isValidSudoku(char[][] board) {
        char[] sec = new char[9];

        //rows
        for(int i=0 ; i < 9; i++){
            for(int j=0 ; j < 9; j++){
                sec[j] = board[i][j];
            }
            if(!validateSection(sec)){
                System.out.println("Row "+ i);
                return false;
            }
        }

        //column
        for(int i=0 ; i < 9; i++){
            for(int j=0 ; j < 9; j++){
                sec[j] = board[j][i];
            }
            if(!validateSection(sec)){
                System.out.println("Column "+ i);
                return false;
            }
        }

        //boxes
        for(int d = 0; d < 9 ; d= d+3){
            for(int r = 0; r < 9 ;r = r+3){
                int index = 0;
                for(int i=0 ; i < 3; i++){
                    for(int j=0 ; j < 3; j++){
                        sec[index++] = board[i + d][j + r];
                    }
                }
                if(!validateSection(sec)){
                    System.out.println("box "+ r + d);
                    return false;
                }
            }
        }

        return true;
        
    }

    public boolean validateSection(char[] sec){
        HashSet<Character> s = new HashSet<>();
        for(char c : sec){
            if(c == '.'){
                continue;
            }
            if(s.contains(c))
                return false;
            else 
                s.add(c);
        }

        return true;
    }
}
