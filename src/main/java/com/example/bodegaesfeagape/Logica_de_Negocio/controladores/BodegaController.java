package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Bodega;
import com.example.bodegaesfeagape.Entidades_de_Negocio.Estante;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.BodegaBL;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.EstanteBL;
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
@RequestMapping("/bodega")
public class BodegaController {

    @Autowired
    private BodegaBL bodegaBL;

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        PageRequest pageable = PageRequest.of(currentPage - 1, pageSize);

        Page<Bodega> bodegas = bodegaBL.buscarTodosPaginados(pageable);
        model.addAttribute("bodegas", bodegas);

        if (bodegas.getTotalPages() > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, bodegas.getTotalPages())
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "Bodega/index";
    }

    @GetMapping("/create")
    public String create(Bodega bodega) {
        return "Bodega/create";
    }

    @PostMapping("/save")
    public String save(Bodega bodega, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute(bodega);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "Bodega/create";
        }

        bodegaBL.crearOEditar(bodega);
        attributes.addFlashAttribute("msg", "Bodega guardado correctamente");
        return "redirect:/bodega/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        Bodega bodega = bodegaBL.buscarPorId(id).get();
        model.addAttribute("bodega", bodega);
        return "/Bodega/edit";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        Optional<Bodega> rOptional = bodegaBL.buscarPorId(id);
        if (rOptional.isPresent()) {
            Bodega bodega = rOptional.get();
            model.addAttribute("bodega", bodega);
            return "Bodega/details";
        } else {
            return "redirect:/bodega/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        Optional<Bodega> rOptional = bodegaBL.buscarPorId(id);
        if (rOptional.isPresent()) {
            Bodega bodega = rOptional.get();
            model.addAttribute("bodega", bodega);
            return "/Bodega/delete";
        } else {
            return "redirect:/bodega/index";
        }
    }

    @PostMapping("/delete")
    public String delete(Bodega bodega, RedirectAttributes attributes) {
        bodegaBL.eliminarPorId(bodega.getId());
        attributes.addFlashAttribute("msg", "Bodega eliminado correctamente");
        return "redirect:/bodega/index";
    }

}
