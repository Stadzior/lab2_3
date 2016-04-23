import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

public class FakeSequenceSearcher implements SequenceSearcher {
    @Override
    public SearchResult search(int i, int[] ints) {
        int position = -1;
        for(int index = 0;index<ints.length;index++){
            if(ints[index] == i){
                position = index;
                break;
            }
        }
        return new FakeSearchResult(position);
    }
}
