public class Quicksort {
    public static int partition(int A[], int low, int high){
        int i=low; int j=high;
        int pivot=A[low];
        while(i<j){
             while(A[i]<pivot){i++;};
             while(A[j]>=pivot) {j--;}

             if(i<j){
                swap(A,i,j);
             }
        }
        swap(A , low,j);
        return j;
    }
    public static void swap(int A[],int i, int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }

    public void quicksortalgo(int A[], int low, int high){
       if(low<high){
        int mid=partition(A,low,high);
        quicksortalgo(A, low, mid-1);
        quicksortalgo(A, mid+1, high);
       }
    }

    public static void main(String[]args){
        int A[]={50,30,10,90,80,20,40,70};
        
        Quicksort obj= new Quicksort();
        System.out.println("Given array: ");
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+" ");
        }
        int n=A.length;
        obj.quicksortalgo(A,0,n-1);
        System.out.println("\nSorted array: ");
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+" ");
        }
    }
}
