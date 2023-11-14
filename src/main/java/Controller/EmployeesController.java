package Controller;

import Entities.EmployeesEntity;
import Entities.StudentEntity;
import Respository.EmployeesRepository;
import Respository.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EmployeesController {
    @Autowired
    private EmployeesRepository employeesRepository;
    @GetMapping("EmployeForm")
    public String showStudentForm(Model map) {
        EmployeesEntity Employees = new EmployeesEntity();
        map.addAttribute("Employees", Employees);
        return "add-new";
    }

    @GetMapping("list")
    public String students(Model model) {
        System.out.println("da log duoc vao trong ham");
        model.addAttribute("Employees", this.employeesRepository.findAll());
        return "index";
    }
    @PostMapping("add")
    public String addStudent(@Validated EmployeesEntity employees, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "add-new";
        }
        this.employeesRepository.save(employees);
        return "redirect:list";
    }
}
