package com.example.bodegaesfeagape.Acceso_a_Datos.servicios.implementaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.bodegaesfeagape.Acceso_a_Datos.repositorios.IDetallePaqueteActivoRepository;
import com.example.bodegaesfeagape.Acceso_a_Datos.servicios.interfaces.IDetallePaqueteActivoService;
import com.example.bodegaesfeagape.Entidades_de_Negocio.DetallePaqueteActivo;

@Service
public class DetallePaqueteActivoService implements IDetallePaqueteActivoService{
    @Autowired
    private IDetallePaqueteActivoRepository detallePaqueteActivoRepository;

    @Override
    public Page<DetallePaqueteActivo> buscarTodosPaginados(Pageable pageable) {
        return detallePaqueteActivoRepository.findAll(pageable);
    }

    @Override
    public List<DetallePaqueteActivo> obtenerTodos() {
        return detallePaqueteActivoRepository.findAll();
    }

    @Override
    public Optional<DetallePaqueteActivo> buscarPorId(Integer id) {
        return detallePaqueteActivoRepository.findById(id);
    }

    @Override
    public DetallePaqueteActivo crearOEditar(DetallePaqueteActivo detallePaqueteActivo) {
        return detallePaqueteActivoRepository.save(detallePaqueteActivo);
    }

    @Override
    public void eliminarPorId(Integer id) {
        detallePaqueteActivoRepository.deleteById(id);
    }
}
