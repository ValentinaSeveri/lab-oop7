package it.unibo.nestedenum;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }

    public enum Month{
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

        Month(int days){  //costruttore
            this.days=days;
        }
       public static Month fromString(String name){
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Mese non valido");
        } 
        String normalized = name.trim().toUpperCase();

        List<Month> match = new ArrayList<>();
         for(Month m : Month.values()){
                 if(m.name().startsWith(normalized)){
                    match.add(m);
                }
          }
          if(match.size() == 1){
            return match.get(0);
          }
          else
          {
            throw new IllegalArgumentException("mese non valdio" + name);
          }
       }

    }
}
