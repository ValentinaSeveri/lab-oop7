package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() { //comparetor the compares month by their number of days
        return new Comparator<String>() {
            @Override
            public int compare(String m1, String m2){
                Month month1 = Month.fromString(m1); //convert the input in the month enum values
                Month month2 = Month.fromString(m2);
                //compare the numeber of days
                return Integer.compare(month1.days, month2.days);
            }
        }; 
    }

    @Override
    public Comparator<String> sortByOrder() { //comparetor the compares month by their ordinal position in the enum
        return new Comparator<String>() {
            
            @Override
            public int compare(String m1, String m2){
                Month month1 = Month.fromString(m1); //convert the input in the month enum values
                Month month2 = Month.fromString(m2);
                //compare their ordianl values
                return Integer.compare(month1.ordinal(), month2.ordinal()); 
            }
        }; 
    }

    public enum Month{ //nested enum representing the month of the year, each with its number of days
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        public int days;

        Month(int days){   //constructor to initialize the number of days
            this.days=days;
        }
       public static Month fromString(String name){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Mese non valido");
        } 
        String normalized = name.trim().toUpperCase(); //normalized the input

        List<Month> match = new ArrayList<>();  //list to collect matching month
         for(Month m : Month.values()){ 
                 if(m.name().startsWith(normalized)){ //add month if the name start with the input string
                    match.add(m);
                }
          }
          if(match.size() == 1){ //if one match is found, return it
            return match.get(0);
          }
          else
          {
            throw new IllegalArgumentException("mese non valdio" + name); //otherwise inout is invalid or ambiguous
          }
       }

    }
}
