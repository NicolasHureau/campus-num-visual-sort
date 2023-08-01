package edu.campusnum.visualsort.sort;

import edu.campusnum.visualsort.model.ObservableArray;
import edu.campusnum.visualsort.model.Order;

/**
 * Created by Web 74 all right reserved
 * User: vincent
 * Date: 27/07/2023
 * Time: 16:31
 */
public class HeapSort implements SortAlgorithm{
    @Override
    public void sort(ObservableArray array) {
        organiser(array);
        for (int i=array.getLength()-1;i>=0;i--){
            array.swap(0,i);
            redescendre(array,i,0);
        }
    }

    void organiser(ObservableArray array){
        for (int i = 0; i < array.getLength()-1; i++) {
            remonter(array, i);
        }
    }
    void remonter(ObservableArray array, int index){
        //if (array.get(index)>array.get(index/2)){
        if (array.compare(index,index/2).equals(Order.Higher)){
            array.swap(index,index/2);
            remonter(array,index/2);
        }
    }
    void redescendre (ObservableArray array,int element,int index){
        int formule = 2*index+1;
        if (formule<element){
            int max;
            //if (array.get(formule)>array.get(2*index)){
            if (array.compare(formule,2*index).equals(Order.Higher)){
                max = formule;
            }else{
                max = 2*index;
            }
            //if (array.get(max)>array.get(index)){
            if (array.compare(max,index).equals(Order.Higher)){
                array.swap(max,index);
                redescendre(array,element,max);
            }
        }

    }
}
