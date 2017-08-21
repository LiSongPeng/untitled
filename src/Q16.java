import java.util.Arrays;
import java.util.Stack;
public class Q16 {
    /**
     * 插入排序
     */
    public static void insertSort(int[] array) {
        System.out.println("insertSort");
        int temp = 0, j = 0;
        for (int i = 1; i < array.length; i++) {
            j = i - 1;
            temp = array[i];
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
    }

    /**
     * 二分插入排序
     */
    public static void binaryInsertSort(int[] array) {
        System.out.println("binaryInsertSort");
        int left = 0, right = 0, mid = 0, key = 0;
        for (int i = 1; i < array.length; i++) {
            left = 0;
            right = i - 1;
            key = array[i];
            while (left <= right) {
                mid = (left + right) / 2;
                if (key > array[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = key;
        }
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
    }

    /**
     * shell排序，希尔排序
     */
    public static void shellSort(int[] array) {
        System.out.println("shellSort");
        int gap = 0;
        int temp, i, j;
        while (gap <= array.length) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {
            for (i = gap; i < array.length; i++) {
                j = i - gap;
                temp = array[i];
                while (j > 0 && temp < array[j]) {
                    array[j + gap] = array[j];
                    j = j - gap;
                }
                array[j + gap] = temp;
            }
            gap = (gap - 1) / 3;
        }
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
    }

    /**
     * 选择排序
     */
    public static void selectSort(int[] array) {
        System.out.println("chooseSort");
        int minIndex;
        for (int i = 0, j; i < array.length; i++) {
            j = i + 1;
            minIndex = i;
            while (j < array.length) {
                if (array[j] < array[minIndex])
                    minIndex = j;
                j++;
            }
            if (minIndex != i) {
                j = array[minIndex];
                array[minIndex] = array[i];
                array[i] = j;
            }
        }
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array) {
        System.out.println("bubbleSort");
        for (int i = 0, j, temp; i < array.length - 1; i++) {
            j = array.length - 1;
            for (; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        for (int a : array)
            System.out.print(a + " ");
        System.out.println();

    }

    /**
     * 快速排序
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start == end)
            return;
        int pivort = start;
        int next = end;
        int temp;
        while (pivort != next) {
            if (array[pivort] > array[next]) {
                if (next > pivort) {
                    temp = array[pivort];
                    array[pivort] = array[next];
                    array[next] = temp;
                    temp = pivort + 1;
                    pivort = next;
                    next = temp;
                } else
                    next++;

            } else if (array[pivort] < array[next]) {
                if (next < pivort) {
                    temp = array[pivort];
                    array[pivort] = array[next];
                    array[next] = temp;
                    temp = pivort--;
                    pivort = next;
                    next = temp;

                } else
                    next--;
            }
        }
        quickSort(array, start, pivort);
        quickSort(array, pivort + 1, end);
    }
    public static class Value{
        public int start;
        public int end;
        public Value(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    /**
     * 快速排序非递归版本
     */
     public static void quickSortNonRecursive(int[] array){
         System.out.println("quickSortNonRecursive");
         for(int e:array){
             System.out.print(e+" ");
         }
         System.out.println();
         Stack<Value> stack=new Stack<>();
         stack.push(new Value(0,array.length-1));
         Value value;
         int start,end,pivort,next,temp;
         while(stack.size()>0){
             value=stack.pop();
             start=value.start;
             end=value.end;
             next=end;
             pivort=start;
             if(start==end)
             continue;
             while (pivort != next) {
                if (array[pivort] > array[next]) {
                    if (next > pivort) {
                        temp = array[pivort];
                        array[pivort] = array[next];
                        array[next] = temp;
                        temp = pivort + 1;
                        pivort = next;
                        next = temp;
                    } else
                        next++;
    
                } else if (array[pivort] < array[next]) {
                    if (next < pivort) {
                        temp = array[pivort];
                        array[pivort] = array[next];
                        array[next] = temp;
                        temp = pivort--;
                        pivort = next;
                        next = temp;
    
                    } else
                        next--;
                }
            }
            stack.push(new Value(start,pivort));
            stack.push(new Value(pivort+1,end));
         }
         for(int e:array){
             System.out.print(e+" ");
         }
         System.out.println();
     }
     /**
      * 堆排序
      */
    public static void adjustHeap(int[] array, int index, int end) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int largest=index;
        int temp;
        if(leftChild<=end&&array[leftChild]>array[largest])
        largest=leftChild;
        if(rightChild<=end&&array[rightChild]>array[largest])
        largest=rightChild;
        if(largest!=index){
            temp=array[largest];
            array[largest]=array[index];
            array[index]=temp;
            adjustHeap(array,largest, end);
        }
        
    }
      public static void buildMaxHeap(int[] array){
          int n=(array.length-2)/2;
          while(n>-1){
              adjustHeap(array,n,array.length-1);
              n--;
          }
      }
      public static void heapSort(int[] array){
          System.out.println("heapSort");
          int i=array.length-1;
          int temp;
          buildMaxHeap(array);
          while(i>0){
              temp=array[0];
              array[0]=array[i];
              array[i]=temp;
              i--;
              adjustHeap(array,0,i);
          }
          for(int a:array){
              System.out.print(a+ " ");
          }
          System.out.println();
      }
      /**
       * 归并排序
       */
      public static void merge(int[] array,int start,int mid,int end,int[] tmp){
          int i=start,j=mid+1;
          int k=0;
          while(i<=mid&&j<=end){
              if(array[i]<=array[j])
              tmp[k++]=array[i++];
              else
              tmp[k++]=array[j++];
          }
          while(i<=mid){
              tmp[k++]=array[i++];
          }
          while(j<=end){
              tmp[k++]=array[j++];
          }
          for(i=0;i<k;i++){
              array[start+i]=tmp[i];
          }
      }
      public static void mergeSort(int[] array,int start,int end,int[] tmp){
          if(start<end){
              int mid=(start+end)/2;
              mergeSort(array, start,mid, tmp);
              mergeSort(array,mid+1, end, tmp);
              merge(array,start,mid,end,tmp);
          }
      }

    public static void main(String[] args) {
        int[] array = { 4, 12, 22, 11, 8, 23, 6, 28 };
        insertSort(Arrays.copyOf(array, array.length));
        binaryInsertSort(Arrays.copyOf(array, array.length));
        shellSort(Arrays.copyOf(array, array.length));
        selectSort(Arrays.copyOf(array, array.length));
        bubbleSort(Arrays.copyOf(array, array.length));
        System.out.println("quickSort");
        int[] newArray = Arrays.copyOf(array, array.length);
        quickSort(newArray, 0, newArray.length - 1);
        for (int a : newArray) {
            System.out.print(a + " ");
        }
        System.out.println();
        quickSortNonRecursive(Arrays.copyOf(array, array.length));
        heapSort(Arrays.copyOf(array, array.length));
        System.out.println("mergeSort");
        int[] newArray2 = Arrays.copyOf(array, array.length);
        mergeSort(newArray2, 0, newArray2.length - 1,new int[newArray2.length]);
        for (int a : newArray2) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}