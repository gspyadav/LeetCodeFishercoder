package leetcode.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Test {



    public static void main(String args[]) {

        int x = 4;
        int y = 2;
        System.out.println((x & (1 << y)) != 0);


        List<String> dates = new ArrayList<>();
        /*
        20 Oct 2052
06 Jun 1933
26 May 1960
20 Sep 1958
16 Mar 2068
25 May 1912
16 Dec 2018
26 Dec 2061
04 Nov 2030
28 Jul 1963

         */
        dates.add("20 Oct 2052");
        dates.add("06 Jun 1933");
        dates.add("26 May 1960");
        dates.add("28 Jul 1963");



        ArrayList<Date> dateListInDateFormat=new ArrayList<>();

        SimpleDateFormat inputFormat = new SimpleDateFormat("dd MMM yyyy");
        Date date = null;
        for(int i=0;i<dates.size();i++){
            try {
                date = inputFormat.parse((String) dates.get(i));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            dateListInDateFormat.add(date);
        }
        Collections.sort(dateListInDateFormat);
        dates.clear();
        for(int i=0;i<dateListInDateFormat.size();i++){
            dates.add(inputFormat.format(dateListInDateFormat.get(i)));
        }
    }

}
