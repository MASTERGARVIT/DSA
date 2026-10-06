class Solution {
    public String minimizeStringValue(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            if(c !='?'){
                freq[c-'a']++;
            }
        }
        int q=0;
        for(char c : s.toCharArray()){
            if(c=='?'){
                q++;
            }
        }
        char[] rep = new char[q];
        for(int i=0;i<q;i++){
            int minidx =0;
            for(int j=1;j<26;j++){
                if(freq[j]<freq[minidx]){
                    minidx =j;
                }
            }
            rep[i] = (char) ('a' + minidx);
            freq[minidx]++;
        }

        java.util.Arrays.sort(rep);
        StringBuilder ans = new StringBuilder();
        int index =0;
        for(char c : s.toCharArray()){
            if(c == '?'){
                ans.append(rep[index++]);
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}