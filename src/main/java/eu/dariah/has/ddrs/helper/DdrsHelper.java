package eu.dariah.has.ddrs.helper;

import eu.dariah.has.ddrs.elasticsearch.model.Institution;
import eu.dariah.has.ddrs.elasticsearch.model.Re3dataText;
import eu.dariah.has.ddrs.elasticsearch.model.Repository;
import eu.dariah.has.ddrs.persistence.model.ContactRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class DdrsHelper {
    public static Map<String, List<Repository>> enhanceRepositories(Map<String, List<Repository>> repositories) {
        for(String key : repositories.keySet()) {
            for(Repository repository : repositories.get(key)) {
                enhanceRepository(repository);
            }
        }
        return repositories;
    }

    public static Repository enhanceRepository(Repository repository) {
        addCountriesToRepository(repository);
        checkEmailAddressInRepository(repository);
        return repository;
    }

    private static void addCountriesToRepository(Repository repository) {
        Set<String> countries = new HashSet<>();
        for(Institution institution : repository.getInstitutions()) {
            countries.add(institution.getCountry());
        }
        repository.setCountries(countries);
    }

    private static void checkEmailAddressInRepository(Repository repository) {
        repository.setWithEmailAddress(false);
        for(Re3dataText contact : repository.getRepositoryContacts()) {
            if(contact.getText().contains("@")) {
                repository.setWithEmailAddress(true);
            }
        }
    }
}
