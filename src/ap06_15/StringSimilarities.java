package ap06_15;

import java.util.*;

public class StringSimilarities {
    Set<Character> charSet(String string){
        Set<Character> set = new HashSet<>();
        string.chars().forEach(intChar -> set.add((char)intChar));
        return set;
    }

    Set<Character> meet(String a,String b){
        Set<Character> aSet = charSet(a);
        Set<Character> bSet = charSet(b);

        aSet.removeIf(c -> !bSet.contains(c));
        return aSet;
    }

    Set<Character> union(String a,String b){
       Set<Character> aSet = charSet(a);
       Set<Character> bSet = charSet(b);
       aSet.addAll(bSet);
       return aSet;
    }

    double simpsonIndex(String a,String b){
        int min = Math.min(a.length(),b.length());
        int meetLength = meet(a,b).size();

        return ( (double) meetLength) / min;
    }

    double jaccardIndex(String a,String b){
        int meetLength = meet(a,b).size();
        int unionLength = union(a,b).size();
        return ( (double)meetLength) / unionLength;
    }

    double diceIndex(String a,String b){
        int meetLength = meet(a,b).size();
        int sumLength = charSet(a).size() + charSet(b).size();
        return ( (double)meetLength*2) / sumLength;
    }

    double cosIndex(String a,String b){
        Set<Character> vectorSourceSet = union(a,b);
        Character vectorSource[] = new Character[vectorSourceSet.size()];
        vectorSourceSet.toArray(vectorSource);

        int[] aVector = vector(vectorSource,a);
        int[] bVector = vector(vectorSource,b);
        double ab = multiVector(aVector,bVector);
        double al = vectorLength(aVector);
        double bl = vectorLength(bVector);
        return ab/(al*bl);
    }


    int[] vector(Character[] src,String a){
        int[] elems = new int[src.length];
        for(int index=0;index<elems.length;index++){
            final int i = index;
            int n= (int) a.chars().filter(cInt -> cInt == src[i]).count();
            elems[index] = n;
        }
        return elems;
    }

    double vectorLength(int[] elems){
        int n=0;
        for(int elem : elems) n+= Math.pow(elem,2);
        return Math.sqrt(n);
    }

    double multiVector(int[] a,int[] b){
        int n=0;
        for(int index = 0;index < a.length;index++) n += a[index]*b[index];
        return n;
    }

    int editDistance(String a,String b){
        int map[][] = new int[a.length()+1][b.length()+1];
        for(int i=0;i<a.length()+1;i++) map[i][0] = i;
        for(int i=0;i<b.length()+1;i++) map[0][i] = i;

        for(int i=1;i<a.length()+1;i++){
            char aChar = a.charAt(i-1);
            for(int j=1;j<b.length()+1;j++){
                char bChar = b.charAt(j-1);
                int min = Math.min(Math.min(map[i-1][j],map[i][j-1]),map[i-1][j-1]);
                if(aChar == bChar) map[i][j] = min;
                else map[i][j] = min + 1;
            }
        }
        return map[a.length()][b.length()];
    }
    void run(String a,String b){
        System.out.printf("simpson(%s,%s) = %f\n",a,b,simpsonIndex(a,b));
        System.out.printf("jaccard(%s,%s) = %f\n",a,b,jaccardIndex(a,b));
        System.out.printf("dice(%s,%s) = %f\n",a,b,diceIndex(a,b));
        System.out.printf("cosine(%s,%s) = %f\n",a,b,cosIndex(a,b));
        System.out.printf("edit distance(%s,%s) = %d\n",a,b,editDistance(a,b));
    }

    public static void main(String[] args){
        new StringSimilarities().run(args[0],args[1]);
    }
}
