package Test;

public class SAPQuestion {


    /**
     *
     * 1. acceptance Of cash
     *
     *
     *      1.1 Based of the amount of value list only items below that price
     *
     * 2. List of Production/Items --- Mapping item number and priceitem.
     *
     * 3. Selection Item
     *
     * 4. CheckPoint cash vs item cost ---
     *
     *
     * 5. calculate the remaning cash ---- give the items
     *
     *
     *
     *
     * vendingmachine/selectionOfItem
     * <></>Authentication basedon machine unique id
     *      <>itemtype</>
     *
     *  vendingmachine/listOfItems
     * <></>Authentication basedon machine unique id
     *
     *
     * vendingmachine/detailsOfItem
     * <></>Authentication basedon machine unique id
     * <>itemNumeber</>
     *
     *
     * vendingmachine/statusOfMachine
     * <></>Authentication basedon machine unique id
     *
     *
     * vendingmachine/totalcash
     * <></>Authentication basedon machine unique id
     *
     *
     */





    /**
     *
     * 0,1,2,3
     *
     * 9999, 59999, 855885, 855885
     *
     *
     *
     *
     * @param numbers
     * @return
     *
     */

    int sum(int[] numbers)  throws  Exception {

       try{
           if(numbers.length == 0 || numbers == null){
                throw  new Exception();
           }
       }catch (Exception e){
           //
       }

        int sum = 0; // long sum
        for(int i =0; i<numbers.length;i++){

            if(sum + numbers[i] < Integer.MAX_VALUE || sum + numbers[i] > Integer.MIN_VALUE){
                sum += numbers[i];
            }else{

                   throw  new Exception();
            }

        }
        return sum;
    }

}
