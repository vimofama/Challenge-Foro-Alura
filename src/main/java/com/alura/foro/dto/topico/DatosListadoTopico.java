package com.alura.foro.dto.topico;

import com.alura.foro.model.Estado;
import com.alura.foro.model.Topico;

import java.time.LocalDate;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDate fecha,
        Estado estado,
        String autor,
        String curso
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha(), topico.getEstado(), topico.getAutor(), topico.getCurso());
    }
}
