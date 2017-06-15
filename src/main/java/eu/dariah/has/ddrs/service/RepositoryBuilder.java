package eu.dariah.has.ddrs.service;

import eu.dariah.has.ddrs.persistence.model.ContactRepository;
import eu.dariah.has.ddrs.re3data.details.v2_2.Re3Data;
import eu.dariah.has.ddrs.re3data.extra.RepositoryDetail;
import eu.dariah.has.ddrs.re3data.search.Link;
import eu.dariah.has.ddrs.re3data.search.Repository;

/**
 * Created by yoann on 14.06.17.
 */
public class RepositoryBuilder {

    public static Repository createRepository(Re3Data.Repository repo, ContactRepository contactRepository) {
        Repository repository = new Repository();

        repository.setId(repo.getRe3DataOrgIdentifier());
        repository.setName(repo.getRepositoryName().getValue());
        Link link = new Link();
        link.setHref("Nothing");
        repository.setLink(link);

        return addRepositoryDetails(repository, repo, contactRepository);
    }

    public static Repository addRepositoryDetails(Repository repository, Re3Data.Repository repo, ContactRepository contactRepository) {
        repository.setRepositoryDetail(new RepositoryDetail());
        if(repo.getDescription() != null)
            repository.getRepositoryDetail().setDescription(repo.getDescription().getValue());
        repository.getRepositoryDetail().setLastUpdate(repo.getLastUpdate());

        if(contactRepository != null)
            repository.getRepositoryDetail().setContact(contactRepository.getContact());
        else
            repository.getRepositoryDetail().setContact(repo.getRepositoryContact().toString());

        return repository;
    }

}
