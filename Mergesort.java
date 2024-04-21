public class Mergesort {
    public static void merge(int arr[], int low, int mid, int high){
        int i=low; int j=mid+1; int k=low;
        int temp[]= new int[high+1];
        while(i<=mid && j<=high){ 
            if(arr[i]<=arr[j]){
                temp[k]=arr[i];
                i++;k++;
            }
            else{
                temp[k]=arr[j];
                j++;k++;}
            }
        
        while(i<=mid){
            temp[k]=arr[i];
            i++;
            k++;
        }

        while(j<=high){
            temp[k]=arr[j];
            j++;
            k++;
        }

        for(int m=low;m<=high;m++){
            arr[m]=temp[m];
        }
        }

    public void mergesort(int arr[], int low, int high){
        if(low<high){
            mid=(low+high)/2;
            mergesort(arr, low, mid);
            mergesort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[]args){
        int arr[]={54,26,93,17,77,31,44,55};
        
        Mergesort obj= new Mergesort();
        System.out.println("Given array: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        int n=arr.length;
        obj.mergesort(arr,0,n-1);
        System.out.println("\nSorted array: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(temp[i]+" ");
        }
    }
    }

