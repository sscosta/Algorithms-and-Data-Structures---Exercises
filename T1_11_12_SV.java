package testessemestresanteriores;

public class T1_11_12_SV {
    public static void main(String[] args) {
        int a[] = {2,4,6,8};
        int b[] = {9,10,11,12};
        int res = findKthSmallest(a,b,5);
        System.out.println(res);
    }

    public static int findKthSmallest(int [] arrayA,int [] arrayB,int k){
        if(k>arrayA.length+arrayB.length)return -1;
        int i = 0;
        int j =0;
        while(i<arrayA.length && j<arrayB.length){
            if(i+1+j+1<k){
                if(i+1<arrayA.length && j+1<arrayB.length) {
                    if (arrayA[i + 1] < arrayB[j + 1])
                        i++;
                    else j++;
                }
                else return i>=k?arrayB[j+1]:arrayA[i+1];
            }else if(i+1+j+1==k)
                return arrayA[i]<arrayB[j]?arrayB[j]:arrayA[i];
            else return arrayA[i]>arrayB[j]?arrayB[j]:arrayA[i];
        }
        return -1;
    }

}
