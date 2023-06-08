package com.alura.foro.dto.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank(message = "Titulo es obligatorio")
        String titulo,
        @NotBlank(message = "Mensaje es obligatorio")
        String mensaje,
        @NotBlank(message = "Autor es obligatorio")
        String autor,
        @NotBlank(message = "Curso es obligatorio")
        String curso
) {
}
