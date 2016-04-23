import edu.iis.mto.search.SearchResult;

public class FakeSearchResult implements SearchResult {

    private int position;
    private boolean isFound;

    public FakeSearchResult(int pos){
        position = pos;
        isFound = getPosition()>-1;
    }

    @Override
    public boolean isFound() {
        return isFound;
    }

    @Override
    public int getPosition() {
        return position;
    }
}
