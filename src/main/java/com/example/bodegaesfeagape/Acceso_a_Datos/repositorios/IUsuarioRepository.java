package com.example.bodegaesfeagape.Acceso_a_Datos.repositorios;

import com.example.bodegaesfeagape.Entidades_de_Negocio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
