package com.alura.foro.controllers;

import com.alura.foro.dto.topico.DatosActualizarTopico;
import com.alura.foro.dto.topico.DatosListadoTopico;
import com.alura.foro.dto.topico.DatosRegistroTopico;
import com.alura.foro.model.Topico;
import com.alura.foro.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        topicoRepository.save(new Topico(datosRegistroTopico));
    }
    @GetMapping
    public Page<DatosListadoTopico> listarTopico(@PageableDefault(sort = "curso") Pageable paginacion){
        return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
    }
    @GetMapping("/{id}")
    public Optional<DatosListadoTopico> detallarTopico(@PathVariable Long id){
      return topicoRepository.findById(id).map(DatosListadoTopico::new);
    }
    @PutMapping("/{id}")
    @Transactional
    public void actualizarTopico(@PathVariable Long id, @RequestBody DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.inactivar();
    }

}
