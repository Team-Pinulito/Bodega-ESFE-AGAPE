package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Activo;
import com.example.bodegaesfeagape.Entidades_de_Negocio.DetallePaqueteActivo;
import com.example.bodegaesfeagape.Entidades_de_Negocio.PaqueteActivo;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.ActivoBL;
import com.example.bodegaesfeagape.Logica_de_Negocio.clasesBL.PaqueteActivoBL;

@Controller
@RequestMapping("/paqueteActivos")
public class PaqueteActivoController {
    @Autowired
    private PaqueteActivoBL paqueteActivoBL;

    @Autowired
    private ActivoBL activoBL;

    @GetMapping("/index")
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1) - 1; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<PaqueteActivo> paqueteActivos = paqueteActivoBL.buscarTodosPaginados(pageable);
        model.addAttribute("paqueteActivos", paqueteActivos);

        int totalPages = paqueteActivos.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "paqueteActivos/index";
    }

    @GetMapping("/create")
    public String create(PaqueteActivo paqueteActivo, Model model) {
 
         if(paqueteActivo.getDetallePaqueteActivos()==null)
         paqueteActivo.setDetallePaqueteActivos(new ArrayList<>());
         DetallePaqueteActivo detalleInicial= new DetallePaqueteActivo(paqueteActivo, 0);
         detalleInicial.setId(-1);
         paqueteActivo.getDetallePaqueteActivos().add(detalleInicial);
         
        model.addAttribute("activos", activoBL.obtenerTodos()); 
        model.addAttribute("paqueteActivo", paqueteActivo);
        return "paqueteActivos/create";
    }

    @PostMapping("/adddetalles")
    public String adddetalles(PaqueteActivo paqueteActivo, Model model) {
        if (paqueteActivo.getDetallePaqueteActivos() == null)
        paqueteActivo.setDetallePaqueteActivos(new ArrayList<>());
        paqueteActivo.getDetallePaqueteActivos().add(new DetallePaqueteActivo(paqueteActivo, 0));

    if (paqueteActivo.getDetallePaqueteActivos() != null) {
        Integer idDet = 0;
        for (DetallePaqueteActivo item : paqueteActivo.getDetallePaqueteActivos()) {
            if (item.getId() == null || item.getId() < 1) {
                idDet--;
                item.setId(idDet);
            }
        }
    }

    model.addAttribute("activos", activoBL.obtenerTodos()); 
    model.addAttribute("paqueteActivo", paqueteActivo);
    if (paqueteActivo.getId() != null && paqueteActivo.getId() > 0)
        return "paqueteActivos/edit";
    else
        return "paqueteActivos/create";
    }

    @PostMapping("/deldetalles/{id}")
    public String deldetalles(@PathVariable("id") Integer id, PaqueteActivo paqueteActivo, Model model) {
        paqueteActivo.getDetallePaqueteActivos().removeIf(elemento -> elemento.getId() == id);
        model.addAttribute("paqueteActivo", paqueteActivo);
        model.addAttribute("activos", activoBL.obtenerTodos()); 
        if (paqueteActivo.getId() != null && paqueteActivo.getId() > 0)
            return "paqueteActivos/edit";
        else
            return "paqueteActivos/create";
    }

    @PostMapping("/save")
    public String save(PaqueteActivo paqueteActivo, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("paqueteActivo", paqueteActivo);
            model.addAttribute("activos", activoBL.obtenerTodos()); 
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "paqueteActivos/create";
        }
        if (paqueteActivo.getDetallePaqueteActivos() != null) {
            for (DetallePaqueteActivo item : paqueteActivo.getDetallePaqueteActivos()) {
                if (item.getId() != null && item.getId() < 0)
                    item.setId(null);
                item.setPaqueteActivo(paqueteActivo);
            }
        }        
        if (paqueteActivo.getId() != null && paqueteActivo.getId() > 0) {
            // funcionalidad para cuando es modificar un registro
            PaqueteActivo paqueteActivoUpdate = paqueteActivoBL.buscarPorId(paqueteActivo.getId()).get();
            // almacenar en un dicionario los telefono que estan
            // guardados en la base de datos para mejor acceso a ellos
            Map<Integer, DetallePaqueteActivo> detallePaqueteActivoData = new HashMap<>();
            if (paqueteActivoUpdate.getDetallePaqueteActivos() != null) {
                for (DetallePaqueteActivo item : paqueteActivoUpdate.getDetallePaqueteActivos()) {
                    detallePaqueteActivoData.put(item.getId(), item);
                }               
            }
            // actualizar los registro que viene de la vista hacia el que se encuentra por id
            paqueteActivoUpdate.setCorrelativo(paqueteActivo.getCorrelativo());
            paqueteActivoUpdate.setNombre(paqueteActivo.getNombre());
            // recorrer los telefonos obtenidos desde la vista y actualizar 
            // alumnoiUpdate para que implemente los cambios
            if (paqueteActivo.getDetallePaqueteActivos() != null) {
                for (DetallePaqueteActivo item : paqueteActivo.getDetallePaqueteActivos()) {
                    if (item.getId() == null) {
                        if (paqueteActivoUpdate.getDetallePaqueteActivos() == null)
                        paqueteActivoUpdate.setDetallePaqueteActivos(new ArrayList<>());
                        item.setPaqueteActivo(paqueteActivoUpdate);
                        paqueteActivoUpdate.getDetallePaqueteActivos().add(item);
                    }
                    else{
                        if(detallePaqueteActivoData.containsKey(item.getId())){
                            DetallePaqueteActivo detallePaqueteActivoUpdate= detallePaqueteActivoData.get(item.getId());
                            // actualizar las propiedades de TelefonosAlumno
                            // si ya existe en la base de datos
                            detallePaqueteActivoUpdate.setActivo(item.getActivo());
                            detallePaqueteActivoUpdate.setCantidad(item.getCantidad());
                            // remover del dicionario los telefonos datas para 
                            // saber que cuales se van eliminar que serian
                            // todos aquellos que no se lograron remove porque no viene desde 
                            // la vista
                            detallePaqueteActivoData.remove(item.getId());
                        }
                    }
                }
            }
            if(detallePaqueteActivoData.isEmpty()==false){
                for (Map.Entry<Integer, DetallePaqueteActivo> item : detallePaqueteActivoData.entrySet()) {
                    paqueteActivoUpdate.getDetallePaqueteActivos().removeIf(elemento -> elemento.getId() ==item.getKey() );                                     
                }
                
            }
            paqueteActivo = paqueteActivoUpdate;
        }
        paqueteActivoBL.crearOEditar(paqueteActivo);
        attributes.addFlashAttribute("msg", "Paquete Activo creado correctamente");
        return "redirect:/paqueteActivos/index";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model) {
        PaqueteActivo paqueteActivo = paqueteActivoBL.buscarPorId(id).get();
        model.addAttribute("paqueteActivo", paqueteActivo);
        model.addAttribute("activos", activoBL.obtenerTodos());
        return "paqueteActivos/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        PaqueteActivo paqueteActivo = paqueteActivoBL.buscarPorId(id).get();
        model.addAttribute("paqueteActivo", paqueteActivo);
        model.addAttribute("activos", activoBL.obtenerTodos()); 
        return "paqueteActivos/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model) {
        PaqueteActivo paqueteActivo = paqueteActivoBL.buscarPorId(id).get();
        model.addAttribute("paqueteActivo", paqueteActivo);
        model.addAttribute("activos", activoBL.obtenerTodos()); 
        return "paqueteActivos/delete";
    }

    @PostMapping("/delete")
    public String delete(PaqueteActivo paqueteActivo, RedirectAttributes attributes) {
        paqueteActivoBL.eliminarPorId(paqueteActivo.getId());
        attributes.addFlashAttribute("msg", "Paquete Activo eliminado correctamente");
        return "redirect:/paqueteActivos/index";
    }
}
