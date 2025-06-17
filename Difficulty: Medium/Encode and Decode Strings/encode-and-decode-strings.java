class Solution {

    public String encode(String s[]) {
        // write your logic to encode the strings
        String separator = Character.toString((char)257);
        StringBuilder sb=new StringBuilder();
        for(String str : s)
        {
            sb.append(str);
            sb.append(separator);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public String[] decode(String s) {
        // write your logic to decode the string
        String c = Character.toString((char)257);
        return s.split(c);
    }
}