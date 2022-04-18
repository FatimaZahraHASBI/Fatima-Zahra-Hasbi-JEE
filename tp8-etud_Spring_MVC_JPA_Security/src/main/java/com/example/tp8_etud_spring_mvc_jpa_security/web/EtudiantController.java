package com.example.tp8_etud_spring_mvc_jpa_security.web;

import com.example.tp8_etud_spring_mvc_jpa_security.entities.Etudiant;
import com.example.tp8_etud_spring_mvc_jpa_security.repositories.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class EtudiantController {
    private EtudiantRepository etudiantRepository;
    @GetMapping(path = "/user/index")
    public String etudiants(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "size", defaultValue = "5") int size,
                           @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Etudiant> pageEtudiants=etudiantRepository.findAll(PageRequest.of(page, size));
        List<Etudiant> etudiantList=new ArrayList<Etudiant>();
        model.addAttribute("etudiantList", pageEtudiants.getContent());
        model.addAttribute("pages", new int[pageEtudiants.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "etudiants";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, String page){
        etudiantRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String home2(){
        return "home";
    }

    @GetMapping("/admin/formEtudiants")
    public String formEtudiants(Model model){
        model.addAttribute("etudiant", new Etudiant());
        return "formEtudiants";
    }

    @PostMapping("/admin/save")
    public String save(Model model, @Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(defaultValue = "") String keyword,
                       @RequestParam(defaultValue = "0") int page){
        if(bindingResult.hasErrors()) return "formEtudiants";
        etudiantRepository.save(etudiant);
        return "redirect:/user/index?page="+page+"&keyword="+keyword;
    }

    @GetMapping("/admin/editEtudiants")
    public String editEtudiant(Model model, Long id, String keyword, int page){
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        if (etudiant ==  null) throw new RuntimeException("Etudiant introuvable");
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "editEtudiant";
    }

}
