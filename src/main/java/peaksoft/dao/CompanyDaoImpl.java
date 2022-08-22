package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao{

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Company> getAllCompanies() {
        List<Company> companies = manager.createQuery(" from Company ",Company.class).getResultList();
        return companies;
    }

    @Override
    public void addCompany(Company company) {
        manager.persist(company);

    }

    @Override
    public Company getCompanyById(long id) {
        return manager.find(Company.class,id);
    }

    @Override
    public void updateCompany(Company company) {
       manager.merge(company);
    }

    @Override
    public void deleteCompany(Company company) {
      manager.remove(manager.contains(company) ? company:manager.merge(company));
    }
}
