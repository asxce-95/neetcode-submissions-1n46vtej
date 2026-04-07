class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        String del = "_";

        for(String s : strs){
            
            sb.append(s);
            sb.append(del);
            //sb.append(s.length());
            sb.append(del);
        }

        System.out.println(sb);

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int start = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '_' && str.charAt(i+1)=='_'){
                String item = str.substring(start, i);
                l.add(item);
                System.out.println(l);
                i = i + 2;
                start = i;
            }
        }

        return l;
    }
}
