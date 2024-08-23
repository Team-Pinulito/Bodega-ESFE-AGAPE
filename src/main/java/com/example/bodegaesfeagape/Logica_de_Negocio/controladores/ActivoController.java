package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Activo;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.ActivoBL;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/activos")
public class ActivoController {
    
    @Autowired
    private ActivoBL activoBL;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);

        Page<Activo> activos = activoBL.buscarTodosPaginados(pageable);
        model.addAttribute("activos", activos);

        if (activos.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, activos.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "activos/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("activo", new Activo());
        return "activos/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("activo") Activo activo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "activos/create";
        }

        // Generate barcode
        String codigoDeBarra = generarCodigoDeBarra();
        activo.setCodigoDeBarra(codigoDeBarra);

        activoBL.crearOEditar(activo);
        attributes.addFlashAttribute("msg", "Activo guardado correctamente");
        return "redirect:/activos/index";
    }

    private String generarCodigoDeBarra() {
        // Generate a unique barcode using UUID
        return UUID.randomUUID().toString();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Optional<Activo> activoOptional = activoBL.buscarPorId(id);
        if (activoOptional.isPresent()) {
            model.addAttribute("activo", activoOptional.get());
            return "/activos/edit";
        } else {
            return "redirect:/activos/index";
        }
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Optional<Activo> activoOptional = activoBL.buscarPorId(id);
        if (activoOptional.isPresent()) {
            model.addAttribute("activo", activoOptional.get());
            return "activos/details";
        } else {
            return "redirect:/activos/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Optional<Activo> activoOptional = activoBL.buscarPorId(id);
        if (activoOptional.isPresent()) {
            model.addAttribute("activo", activoOptional.get());
            return "/activos/delete";
        } else {
            return "redirect:/activos/index";
        }
    }

    @PostMapping("/delete")
    public String delete(Activo activo, RedirectAttributes attributes) {
        activoBL.eliminarPorId(activo.getId());
        attributes.addFlashAttribute("msg", "Activo eliminado correctamente");
        return "redirect:/activos/index";
    }
}