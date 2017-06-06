package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.model.SearchObject;

import java.util.List;

/**
 * Created by yoannmoranville on 12/05/17.
 */
public class Re3dataQueryList {
    private static final String URL_PREFIX = "http://www.re3data.org/api/beta/repositories?";
    private static final String URL_AND = "&";

    private static final String QUERY = "query=";
    private static final String SUBJECTS = "subjects[]=";

    private static final String SUBJECT_HUMANITIES = "11 Humanities";

    private String url;

    public String getUrl() {
        return url;
    }

    public Re3dataQueryList(SearchObject searchObject) {
        StringBuilder stringBuilder = new StringBuilder(URL_PREFIX);
        stringBuilder.append(QUERY);
        for(String key : searchObject.getSearchParameters().keySet()) {
            String filterName = key + "[]=";
            if(filterName.equals(SUBJECTS)) {
                searchObject.getSearchParameters().get(key).add(SUBJECT_HUMANITIES);
            }
            addList(stringBuilder, filterName, searchObject.getSearchParameters().get(key));
        }
        url = stringBuilder.toString();
    }

    private void addList(StringBuilder stringBuilder, String filterName, List<String> toBeAdded) {
        for(String contentType : toBeAdded) {
            stringBuilder.append(URL_AND).append(filterName).append(contentType);
        }
    }
}
