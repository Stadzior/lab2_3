import edu.iis.mto.similarity.SimilarityFinder;
import static org.hamcrest.Matchers.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimilarityFinderTest {

    int[] seq1,seq2,seq3,seq4;
    SimilarityFinder finder;
    FakeSequenceSearcher searcher;
    @Before
    public void initialize(){
        seq1 = new int[]{1,2,3,4};
        seq2 = new int[]{5,6,7,8};
        seq3 = new int[]{1,2,3,5};
        seq4 = new int[]{1,1,1,1,1};
        searcher = new FakeSequenceSearcher();
        finder = new SimilarityFinder(searcher);
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
    public void ShouldPass_WhenSearchResultWasCalledWithIntsTable(){

    }

    @Test
    public void ShouldPass_WhenSearchMethodWasCalled5Times(){

    }

}
