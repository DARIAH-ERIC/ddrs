package eu.dariah.has.ddrs.model;

import java.util.*;

/**
 * Created by yoannmoranville on 10/05/17.
 */
public class SearchObject {
    private Map<String, List<String>> internSearchParameters;

    public Map<String, List<String>> getInternSearchParameters() {
        if(internSearchParameters == null)
            return new HashMap<>();
        return internSearchParameters;
    }

    /**
     * It has to be getSearchParameters with a Map<String, String> because this comes from AJAX query
     * @param searchParameters The search queries from AJAX
     */
    public void setSearchParameters(Map<String, String> searchParameters) {
        internSearchParameters = new HashMap<>(searchParameters.size());
        for(String key : searchParameters.keySet()) {
            internSearchParameters.put(key, new ArrayList<>(Collections.singletonList(searchParameters.get(key))));
        }
    }

}
