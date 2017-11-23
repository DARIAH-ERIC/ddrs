package eu.dariah.has.ddrs.helper;

import eu.dariah.has.ddrs.elasticsearch.model.Institution;
import eu.dariah.has.ddrs.elasticsearch.model.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class DdrsHelper {
    public static Map<String, List<Repository>> addCountriesToRepositories(Map<String, List<Repository>> repositories) {
        for(String key : repositories.keySet()) {
            for(Repository repository : repositories.get(key)) {
                addCountriesToRepository(repository);
            }
        }
        return repositories;
    }

    public static Repository addCountriesToRepository(Repository repository) {
        Set<String> countries = new HashSet<>();
        for(Institution institution : repository.getInstitutions()) {
            countries.add(institution.getCountry());
        }
        repository.setCountries(countries);
        return repository;
    }
}
