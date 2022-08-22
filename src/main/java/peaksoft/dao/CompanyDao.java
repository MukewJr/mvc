package peaksoft.dao;

import peaksoft.entity.Company;
import peaksoft.entity.Course;

import java.util.List;

public interface CompanyDao {

    List<Company> getAllCompanies();

    void addCompany(Company company);

    Company getCompanyById(long id);

    void updateCompany(Company company);

    void deleteCompany(Company company);
}
