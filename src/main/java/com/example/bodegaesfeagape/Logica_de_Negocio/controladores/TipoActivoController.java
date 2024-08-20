package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import org.springframework.stereotype.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Rol;
import com.example.bodegaesfeagape.Entidades_de_Negocio.TipoActivo;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.RolBL;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.TipoActivoBL;


@Controller
@RequestMapping("/tipoActivos")
public class TipoActivoController {
    
    @Autowired
    private TipoActivoBL tipoActivoBL;

    @GetMapping("/index")
    public String index(Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);

        Page<TipoActivo> tipoActivos = tipoActivoBL.buscarTodosPaginados(pageable);
        model.addAttribute("tipoActivos", tipoActivos);

        if (tipoActivos.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, tipoActivos.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "tipoActivos/index";
    }

    @GetMapping("/create")
    public String create(TipoActivo  tipoActivo) {
        return "tipoActivos/create";
    }

    @PostMapping("/save")
    public String save(TipoActivo tipoActivo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(tipoActivo);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "tipoActivos/create";
        }

        tipoActivoBL.crearOEditar(tipoActivo);
        attributes.addFlashAttribute("msg", "El tipo activo guardado correctamente");
        return "redirect:/tipoActivos/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        TipoActivo tipoActivo = tipoActivoBL.buscarPorId(id).get();
        model.addAttribute("tipoActivo", tipoActivo);
        return "/tipoActivos/edit";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Optional<TipoActivo> tOptional = tipoActivoBL.buscarPorId(id);
        if (tOptional.isPresent()) {
            TipoActivo tipoActivo = tOptional.get();
            model.addAttribute("tipoActivo", tipoActivo);
            return "tipoActivos/details"; 
        } else {
            return "redirect:/tipoActivos/index"; 
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Optional<TipoActivo> tOptional = tipoActivoBL.buscarPorId(id);
        if (tOptional.isPresent()) {
            TipoActivo tipoActivo = tOptional.get();
            model.addAttribute("tipoActivo", tipoActivo);
            return "/tipoActivos/delete";
        } else {
            return "redirect:/tipoActivos/index";
        }
    }

    @PostMapping("/delete")
    public String delete(TipoActivo tipoActivo, RedirectAttributes attributes) {
        tipoActivoBL.eliminarPorId(tipoActivo.getId());
        attributes.addFlashAttribute("msg", "El tipo activo eliminado correctamente");
        return "redirect:/tipoActivos/index";
    }
}
