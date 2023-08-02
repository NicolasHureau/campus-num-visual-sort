package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class QuickSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {

        rapidSort(array, 0,array.getLength()-1 );
    }
    int part (ObservableArray array,int first, int last,int pivot){
        array.swap(pivot, last);
        int j = first;
        for (int i=first;i<=last-1;i++){
            if (array.get(i)<= array.get(last)){
                array.swap(i,j);
                j++;
            }
        }
        array.swap(last,j);
        return j;
    }
    void rapidSort(ObservableArray array, int first, int last){
        if (first<last){
            int pivot = first;
            pivot = part(array,first,last,pivot);
            rapidSort(array,first,pivot-1);
            rapidSort(array,pivot+1,last);
        }
    }
}
