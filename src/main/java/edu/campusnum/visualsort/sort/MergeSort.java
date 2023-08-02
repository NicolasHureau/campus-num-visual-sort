package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;


/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class MergeSort implements SortAlgorithm {
    @Override
    public void sort(ObservableArray array) {
        //mergeSort(array,array.getLength());
        if (array.getLength() > 1) {
            int n = array.getLength();
            int iL = 0;
            int iR = n / 2;
            int iE = n - iR;

            ObservableArray L = array.slice(iL, iR);
            ObservableArray R = array.slice(iR, iE);

            sort(L);
            sort(R);

            while (iR - iL > 0 && n - iR > 0) {
                //if (array.get(iR) < array.get(iL)) {
                if (array.compare(iR,iL).equals(Order.Lower)){
                    for (int j = iR; j > iL; j--) {
                        array.swap(j, j - 1);
                    }
                    iR++;
                }
                iL++;
            }
        }
    }

    /*ObservableArray mergeSort(ObservableArray array,int length){

        if (array.getLength()<=1){
            return array;
        }else{
            ObservableArray array1 = array.slice(0,array.getLength()/2);
            ObservableArray array2 = array.slice(array1.getLength(),array.getLength()-array1.getLength());
            //return merge(mergeSort(array1),mergeSort(array2));

            ///
            int idxLeft = 0;
            int idxRight = array1.getLength();
            int i = 0;

            while (array1.getLength()>0){
                if (array1.get(i)>array2.get(i)){
                    array.swap(idxLeft,idxRight);

                }

            }

            if (array1.getLength() == 1 && array2.getLength() ==1){
                if (array1.get(0) <= array2.get(0)){
                    array.swap(array.compare(array,array1.get(0));
                }
            }
        }
    }
    ObservableArray merge(ObservableArray arrayA, ObservableArray arrayB){
        if (arrayA.getLength() == 0){
            return arrayB;
        } else if (arrayB.getLength() == 0) {
            return arrayA;
        } else if (arrayA.get(0) <= arrayB.get(0)){
            return arrayA + arrayB;
        } else {
            return merge(arrayB,arrayA);
        }
    }*/
}