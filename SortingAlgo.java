package algo;

public class SortingAlgo {

    public static int[] SelectionSort(int[] list) {
    	int temp=0;
    	for(int i=0;i<list.length-1;i++) {
    		int min=i;
    		for(int j=i+1;j<list.length;j++) {
    			if(list[min]>list[j]) {
    				min=j;
    			}
    		}
    		temp=list[i];
    		list[i]=list[min];
    		list[min]=temp;
    	}
      return list;
    }
    //----------------------------------------------//
    public static int[] BubbleSort(int[] list) {
    	for(int i=0;i<list.length-1;i++) {
    		int temp=0;
    		for(int j=0;j<list.length-i-1;j++) {
    			if(list[j]>list[j+1]) {
    				temp=list[j+1];
    				list[j+1]=list[j];
    				list[j]=temp;
    			}
    		}
    	}
    	return list;
    }
  //----------------------------------------------//
    public static int[] InsertionSort(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int temp = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > temp) {  
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;  
        }
        return list;
    }
  //----------------------------------------------//
    public static void heapify(int arr[], int n, int i) { //n current size of the heap
    	int largest = i;
    	int l = 2*i+1;
    	int r=2*i+2;
    	if(l<n && arr[l]>arr[largest]) {
    		largest=l;
    	}
    	if(r<n && arr[r]>arr[largest]) {
    		largest=r;
    	}
    	if( largest!=i ) {
    		int temp=arr[i];
    		arr[i]=arr[largest];
    		arr[largest]=temp;
    		heapify(arr,n,largest);
    	}
    	
    }
    public static void heapSort(int[] arr) {
       int n=arr.length;
       for(int i=n/2-1;i>=0;i--) {
    	   heapify(arr,n,i);
       }
       for(int i=n-1;i>=0;i--) {
    	   int temp=arr[0];
    	   arr[0]=arr[i];
    	   arr[i]=temp;
    	   heapify(arr,i,0);
       }
    }
  //----------------------------------------------//
    public static void quickSort(int[] arr,int start, int end ) {
    	if (end<=start) return;
    	int pivot =partition(arr,start,end);
    	quickSort(arr,start,pivot-1);
    	quickSort(arr,pivot+1,end);
    	
    }
    public static int partition(int[] arr,int start, int end) {
    	int pivot=arr[end];
    	int i=start-1;
    	for(int j=start;j<=end-1;j++) {
    		if(arr[j]<pivot) {
    			i++;
    			int temp=arr[i];
    			arr[i]=arr[j];
    			arr[j]=temp;
    		}
    	}
    	i++;
		int temp=arr[i];
		arr[i]=arr[end];
		arr[end]=temp;
    	return i;
    }
  //----------------------------------------------//
    public static void mergeSort(int[] arr) {
    	int length=arr.length;
    	if(length<=1) return;
    	int midlle =length/2;
    	int[] arrLeft=new int[midlle];
    	int[] arrRight=new int[length-midlle];
    	int i=0;
    	int j=0;
    	for(;i<length;i++) {
    		if(i<midlle) {
    			arrLeft[i]=arr[i];
    		}else {
    			arrRight[j]=arr[i];
    			j++;
    		}
    	}
    	mergeSort(arrLeft);
    	mergeSort(arrRight);
    	merge(arrLeft,arrRight,arr);
    }
    public static void merge(int[] arr1,int[] arr2, int[] arr) {
    	int leftSize = arr1.length;
    	int rightSize = arr2.length;

    	int i=0,l=0,r=0;
    	while(l<leftSize && r<rightSize) {
    		if(arr1[l]<arr2[r]) {
    			arr[i]=arr1[l];
    			i++;
    			l++;
    		}else {
    			arr[i]=arr2[r];
    			i++;
    			r++;
    		}
    	}
    	 while(l<leftSize) {
    		 arr[i]=arr1[l];
    		 i++;
    		 l++;
    	 }
    	 while(r<rightSize) {
    		 arr[i]=arr2[r];
    		 i++;
    		 r++;
    	 }
    }
    public static void main(String[] args) {
        int[] unsorted = {2, 6, 1, 5, 7, 8, 3};
       
        mergeSort(unsorted);
        //quickSort(unsorted,0,6);
        //SelectionSort(unsorted);
        //BubbleSort(unsorted);
        //InsertionSort(unsorted);
        //heapSort(unsorted);
        for (int num : unsorted) {
            System.out.print(num);
        }
        
        
    }
}

