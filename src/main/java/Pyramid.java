import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Pyramid {

    public static void main(String[] args) {
        assertTrue(isPyramid(countOccurrencesOfUniqueCharacters("banana")));
        assertFalse(isPyramid(countOccurrencesOfUniqueCharacters("bandana")));
        assertFalse(isPyramid(countOccurrencesOfUniqueCharacters("bcdcdcdd")));
    }

    /**
     * This method counts the occurrence of distinct characters in the supplied string.
     * It will then return a List of integers with the counts in ascending order
     * @param testString
     * @return List
     */
    private static List<Integer> countOccurrencesOfUniqueCharacters(String testString) {
        return testString.chars()
                .distinct()
                .map(ch -> StringUtils.countMatches(testString, String.valueOf((char) ch)))
                .sorted()
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * This takes the input of List of integers in ascending order and checks if the
     * numbers are consecutive.
     * @param charCountList
     * @return true if numbers are consecutive
     *         false if numbers are not consecutive
     */
    private static boolean isPyramid(List<Integer> charCountList) {
        for(int i=1; i<charCountList.size(); i++) {
            if(charCountList.get(i-1) + 1 != charCountList.get(i)) {
                return false;
            }
        }
        return true;
    }

}
