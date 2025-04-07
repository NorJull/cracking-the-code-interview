import StacksAndQueues.SetOfStacks;
import StacksAndQueues.SetOfStacksWithPopAt;
import StacksAndQueues.StackMin;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
  // -6 7 8 3 -20 50

        // 1 - (-6) = 7
        //-1
        System.out.println(max(Arrays.asList(-6, 7, 8, 3, -20, 50)));


    }

    private static int max(List<Integer> nums ){
        int max = 0;
        int sum = 0;

        for(int i = 0; i < nums.size(); i++ ) {
            sum = sum + nums.get(i);

            if(sum < sum - max) {
                max = Math.max(max, sum - max);
            } else {
                max =Math.max(max, sum );
            }
        }

        return max;
    }
    private static int findMaxLength(String s) {
        Map<Character, Integer> indexOfCharacters = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int firstCharacter = 0;

        for(int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if(indexOfCharacters.containsKey(character) && i > firstCharacter) {
                firstCharacter = indexOfCharacters.get(character) + 1 ;
            }

            indexOfCharacters.put(character, i);

            maxLength = Math.max(maxLength, i - firstCharacter + 1);
        }
        return maxLength;
    }
















    private static int findMaxLengthCarlos(String s) {
        Map<Character, Object> counter = new HashMap();
        int to = s.length();
        int mxLength = Integer.MIN_VALUE;
        int currLength = 0;
        int pivote = 0;

        for (int from = 0; from < to; from ++) {
            char currentChart = s.charAt(from);
            if(!counter.containsKey(currentChart)){
                currLength ++;
                counter.put(currentChart, null);
            } else{
                pivote ++;
                mxLength = (mxLength < currLength) ? currLength : mxLength;
                currLength = 0;
                from = pivote;
                counter.clear();
            }

        }

        return mxLength;





    }
    private static int minSum(List<Integer> l, int k) {

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < l.size() - k; i++) {
            int sum = l.get(i) + l.get(i + 1) + l.get(i+2);
            if (min < sum)
                min = sum;
        }

        return min;

    }

    private static Map<Long, Long> count(Map<String, UserStats>... visits) {
        if (visits == null)
            return new HashMap<>();

        return Arrays.stream(visits)
                .filter(map -> map != null) // Map should not be null
                .filter(map -> !map.isEmpty()) // Map should not be empty
                .flatMap(map -> map.entrySet().stream()
                .filter(entry -> isALong(entry.getKey())) // key should be parseable to Long
                .filter(entry -> entry.getValue() != null) // UserStats should be not null
                .filter(entry -> entry.getValue().getVisitCount().isPresent()) // visitCount should have a value
                        .map(entry -> new AbstractMap.SimpleEntry<Long, Long>(Long.parseLong(entry.getKey()), entry.getValue().getVisitCount().get()))

        ).collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingLong(Map.Entry::getValue)));

    }

    private static  boolean isALong(String stringNum) {
        if(stringNum == null)
            return false;

        try {
            Long l = Long.parseLong(stringNum);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    class UserStats {
        Optional<Long> visitCount;

        public UserStats(Optional<Long> visitCount) {
            this.visitCount = visitCount;
        }

        public Optional<Long> getVisitCount() {
            return visitCount;
        }
    }
}