import java.util.*;

 class Rotation {

    public static void main(String[] args) {
        System.out.println(chkRotation("abcd",4,"cdab",4));
    }
    public static boolean chkRotation(String origin, int lena, String target, int lenb) {
        // write code here
        if(origin.length()!=target.length())
        return false;
        String str=origin+origin;
        int[] next=new int[target.length()];
        next[0]=0;
        int k=0;
        for(int i=1;i<next.length;i++){
            while(k>0&&target.charAt(i)!=target.charAt(k))
              k=next[k-1];
            if(target.charAt(i)==target.charAt(k))
              k++;
              next[i]=k;
        }
        int matchSize=0;
        for(int i=0;i<str.length();i++){
            while(matchSize>0&&str.charAt(i)!=target.charAt(matchSize)){
            matchSize=next[matchSize-1];
            }
            if(str.charAt(i)==target.charAt(matchSize))
            matchSize++;
            if(matchSize==target.length())
            return true;
        }
        return false;
    }
}
