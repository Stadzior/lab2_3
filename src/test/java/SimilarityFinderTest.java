import edu.iis.mto.similarity.SimilarityFinder;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimilarityFinderTest {

    private int[] seq1,seq2,seq3,seq4;
    private SimilarityFinder finder;
    private FakeSequenceSearcher searcher;
    public static int DEPENDENCY_CALL_COUNTER;
    public static int[] TABLE_PASSED_TO_SEARCH_METHOD;
    @Before
    public void initialize(){
        seq1 = new int[]{1,2,3,4};
        seq2 = new int[]{5,6,7,8};
        seq3 = new int[]{1,2,3,5};
        seq4 = new int[]{1,1,1,1,1};
        searcher = new FakeSequenceSearcher();
        finder = new SimilarityFinder(searcher);
        DEPENDENCY_CALL_COUNTER = 0;
        TABLE_PASSED_TO_SEARCH_METHOD = new int[]{};
    }

    @Test
    public void ShouldReturn1_WhenSetsAreTheSame(){
        Assert.assertThat(finder.calculateJackardSimilarity(seq1,seq1),equalTo((double)1));
    }
    @Test
    public void ShouldReturn0_WhenSetsAreDifferent(){
        Assert.assertThat(finder.calculateJackardSimilarity(seq1,seq2),equalTo((double)0));
    }

    @Test
    public void ShouldReturn0point6_When3of4ElementsAreSimilar(){
        Assert.assertThat(finder.calculateJackardSimilarity(seq1,seq3),equalTo(0.6));
    }

    @Test
    public void ShouldPass_WhenSearchResultWasCalledWithSeq2(){
        finder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(TABLE_PASSED_TO_SEARCH_METHOD,is(seq2));
    }

    @Test
    public void ShouldPass_WhenSearchMethodWasCalled5Times(){
        finder.calculateJackardSimilarity(seq1,seq2);
        Assert.assertThat(DEPENDENCY_CALL_COUNTER,equalTo(seq1.length));
    }

}
