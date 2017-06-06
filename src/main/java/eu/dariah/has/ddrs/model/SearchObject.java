package eu.dariah.has.ddrs.model;

import java.util.ArrayList;
§import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yoannmoranville on 10/05/17.
 */
public class SearchObject {
    private Map<String, List<String>> searchParameters;

    public Map<String, List<String>> getSearchParameters() {
        if(searchParameters == null)
            return new HashMap<>();
        return searchParameters;
    }

    public void setSearchParameters(Map<String, List<String>> searchParameters) {
        this.searchParameters = searchParameters;
    }

}
