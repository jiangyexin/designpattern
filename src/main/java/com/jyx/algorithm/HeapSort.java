package com.jyx.algorithm;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-23 9:57
 **/
public class HeapSort {

    public int[] heapSort(int[] A, int n) {
        int lastIndex = n - 1;
        buildMaxHeap(A, lastIndex);//建立最大堆
        while(lastIndex > 0){
            swap(A, 0, lastIndex);
            if(--lastIndex == 0)//只剩一个元素，就不用调整堆了，排序结束
                break;
            adjustHeap(A,0,lastIndex);
        }
        return A;
    }


    public void buildMaxHeap(int[] arr, int lastIndex) {
        // 从最后一个元素的父节点开始进行调整，一直调整到根节点结束
        int j = (lastIndex - 1) / 2;
        while (j >= 0) {
            //int rootIndex = j;
            adjustHeap(arr, j, lastIndex);
            j--;
        }
    }


    public void adjustHeap(int[] arr, int rootIndex, int lastIndex) {//从根节点开始往下调整
        int biggerIndex = rootIndex;
        int leftChildIndex = rootIndex * 2 + 1;
        int rightChildIndex = rootIndex * 2 + 2;
        if(rightChildIndex <= lastIndex){//如果右孩子存在，则左孩子一定存在
            if(arr[rightChildIndex] > arr[rootIndex] || arr[leftChildIndex] > arr[rootIndex]){
                //将子节点更大的元素下标赋值给biggerIndex
                biggerIndex = arr[rightChildIndex] > arr[leftChildIndex]?rightChildIndex:leftChildIndex;
            }
        } else if(leftChildIndex <= lastIndex){//保证左孩子存在，且不能越界
            if(arr[leftChildIndex] > arr[rootIndex]){
                biggerIndex = leftChildIndex;
            }
        }
        if(biggerIndex != rootIndex){
            swap(arr, biggerIndex, rootIndex);
            adjustHeap(arr, biggerIndex, lastIndex);
        }
    }


    public void swap(int[] arr, int biggerIndex, int rootIndex) {
        int temp = arr[rootIndex];
        arr[rootIndex] = arr[biggerIndex];
        arr[biggerIndex] = temp;
    }

    public static void main(String[] args) {
        /*使用堆排序法进行排序*/
        int heap[]=new int[]{9,8,7,9,5,4,7,2,1};  //把待排序的数存放在数组中
        int n=heap.length;
        HeapSort hs=new HeapSort();
        hs.heapSort(heap,n);
        PrintArr.printArr(heap);
    }
}
