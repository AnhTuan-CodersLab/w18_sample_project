package pl.coderslab.myapplication.algorithms

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

class MostOccurrencesFinderTest extends Specification {

    @Subject
    MostOccurrencesFinder finder = new MostOccurrencesFinder()

    @Unroll
    def "should find most occurrences for given word: #word"() {
        when:
        def result = finder.find(word)

        then:
        result == expectedResult

        where:
        word    | expectedResult
        ""      | 0
        "a"     | 1
        "ab"    | 1
        "asia"  | 2
        "ooo"   | 3
        "   "   | 0
        "a a b" | 2
    }

}
