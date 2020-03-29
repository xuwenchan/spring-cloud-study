public class OrderTest {
    public static void main(String[] args){
       // maopaoOrderTest();
        heapOrderTest();
    }

    //快速排序测试
    /*
    通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
    然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
    * */
    public static void quickOrderTest(){
        int low = 0;
        int high = 18;
        int[] arr = { 45, 43, 16, 4, 36, 36, 12, 17, 43, 12, 42, 7, 26, 23, 35, 4, 14, 21, 9 };
        quckOrder(arr, low, high);
    }

    //快速排序测试
    public static void quckOrder(int arr[], int low, int high){
        int l = low;
        int h = high;
        int povit = arr[low];

        while (l < h) {
            while (l < h && arr[h] >= povit)  //从右边寻找值小于基准的值
                h--;
            if (l < h) {
                arr[l] = arr[h];
                l++;
            }

            while (l < h && arr[l] <= povit)
                l++;

            if (l < h) {
                arr[h] = arr[l];
                h--;
            }
        }
        arr[l] = povit;
        print(arr);
        System.out.print("l=" + (l + 1) + "h=" + (h + 1) + "povit=" + povit + "\n");
        if (l - 1 > low)
            quckOrder(arr, low, l - 1);
        if (h + 1 < high)
            quckOrder(arr, h + 1, high);

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " -> ");
        }
        System.out.println();
    }

    public static void maopaoOrderTest(){
        int[] arr = { 45, 43, 16, 4, 36, 36, 12, 17, 43, 12, 42, 7, 26, 23, 35, 4, 14, 21, 9 };
        print(arr);
    }


    //冒泡排序
    public static void maopaoOrder(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {   // 这里说明为什么需要-1
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /*
    * 直接插入排序是将无序序列中的数据插入到有序的序列中，在遍历无序序列时，
    * 首先拿无序序列中的首元素去与有序序列中的每一个元素比较并插入到合适的位置，
    * 一直到无序序列中的所有元素插完为止。对于一个无序序列arr{4，6，8，5，9}来说，
    * 我们首先先确定首元素4是有序的，然后在无序序列中向右遍历，6大于4则它插入到4的后面，
    * 再继续遍历到8，8大于6则插入到6的后面，这样继续直到得到有序序列{4，5，6，8，9}。
    * */
    public static void insertOrder(int[] arr){
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /*
    *
    *
    * */
    public static void xierOrder(int[] arr){

    }

    public static void heapOrderTest(){
        int[] arr = { 45, 43, 16, 4, 36, 36, 12, 17, 43, 12, 42, 7, 26, 23, 35, 4, 14, 21, 9 };
        print(heapSort(arr));
    }


    /*
    * 堆排序
    * 什么叫做堆
    * 堆满足两个条件
    * 1，必须是一个完全二叉属于
    * 2，每个父节点的值必须大于它的子节点
    * */
    public static int[] heapSort(int[] arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
        return arr;
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


}
