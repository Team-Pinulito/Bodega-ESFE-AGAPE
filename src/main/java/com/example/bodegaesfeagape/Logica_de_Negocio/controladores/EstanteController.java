package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.BodegaBL;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.EstanteBL;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.RolBL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/estante")
public class EstanteController {

    @Autowired
    private EstanteBL estanteBL;

    @Autowired
    private BodegaBL bodegaBL;

    @GetMapping("/index")
    public String index(Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);

        Page<Estante> estantes = estanteBL.buscarTodosPaginados(pageable);
        model.addAttribute("estantes", estantes);

        if (estantes.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, estantes.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "Estante/index";
    }

    @GetMapping("/create")
    public String create(Estante estante, Model model ) {
        model.addAttribute("bodegas", bodegaBL.obtenerTodos());
        return "Estante/create";
    }

    @PostMapping("/save")
    public String save(Estante estante, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(estante);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "Estante/create";
        }

        estanteBL.crearOEditar(estante);
        attributes.addFlashAttribute("msg", "Estante guardado correctamente");
        return "redirect:/estante/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Estante estante = estanteBL.buscarPorId(id).get();
        model.addAttribute("estante", estante);
        model.addAttribute("bodegas", bodegaBL.obtenerTodos());
        return "/Estante/edit";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Optional<Estante> rOptional = estanteBL.buscarPorId(id);
        if (rOptional.isPresent()) {
            Estante estante = rOptional.get();
            model.addAttribute("estante", estante);
            model.addAttribute("bodegas", bodegaBL.obtenerTodos());
            return "Estante/details";
        } else {
            return "redirect:/estante/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Optional<Estante> rOptional = estanteBL.buscarPorId(id);
        if (rOptional.isPresent()) {
            Estante estante = rOptional.get();
            model.addAttribute("estante", estante);
            model.addAttribute("bodegas", bodegaBL.obtenerTodos());
            return "/Estante/delete";
        } else {
            return "redirect:/estante/index";
        }
    }

    @PostMapping("/delete")
    public String delete(Estante estante, RedirectAttributes attributes) {
        estanteBL.eliminarPorId(estante.getId());
        attributes.addFlashAttribute("msg", "Estante eliminado correctamente");
        return "redirect:/estante/index";
    }



}
