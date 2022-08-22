package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

import java.util.List;

@Controller
public class CompanyController {

    private final CompanyService service;

    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

      @GetMapping("/getAllCompanies")
    public String getCompanies(Model model){
        List<Company> companies=service.getAllCompanies();
        model.addAttribute("companies",companies);
        return "company/companies";
    }

    @GetMapping("/addCompany")
    public String addCompany(Model model){
        model.addAttribute("company",new Company());
        return "company/addCompany";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        service.addCompany(company);
        return "redirect:/addCompany";
    }
      @GetMapping
      public String updateCompany(@RequestParam("company")Long id,Model model){
        Company company=service.getCompanyById(id);
        model.addAttribute("company",company);
        return "company/updateCompany";
      }

      @PostMapping("/saveUpdateCompany")
      public String saveUpdateCompany(@ModelAttribute("company")Company company){
        service.updateCompany(company);
        return "redirect:/getAllCompanies";
      }

      @RequestMapping("deleteCompany")
      public String deleteCompany(@RequestParam("companyId")Long id){
        service.deleteCompany(service.getCompanyById(id));
        return "redirect:/getAllCompanies";
      }
}
