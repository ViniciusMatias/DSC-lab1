package com.dcs.spring.api.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.dcs.spring.api.dto.ComentarioDTO;
import com.dcs.spring.api.dto.DisciplinaDTO;
import com.dcs.spring.api.dto.NotaDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcs.spring.api.model.Disciplina;
import com.dcs.spring.api.repository.DisciplinaRepository;
import com.dcs.spring.api.services.exception.EntityNotFoundEx;

import javax.annotation.PostConstruct;

@Service
public class DisciplinaServices {


    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostConstruct
    public void initDisciplinas() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Disciplina>> listTypeReference = new TypeReference<List<Disciplina>>() {
        };
        InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplina.json");
        try {
            List<Disciplina> disciplinas = objectMapper.readValue(inputStream, listTypeReference);
            this.disciplinaRepository.saveAll(disciplinas);
        } catch (IOException e) {
            System.out.println("Não foi possivel salvar disciplina: " + e.getMessage());
        }
    }

    public Disciplina criar(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> buscar() {
        return disciplinaRepository.findAll();

    }

    public Disciplina buscarPorId(Integer id) {
        return disciplinaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundEx("Id não Existe !"));
    }


    public Disciplina atualizaNomeDisciplina(Integer id, Disciplina disciplinaUpdate) {
        Disciplina disciplina = buscarPorId(id);
        BeanUtils.copyProperties(disciplinaUpdate, disciplina, "id", "likes", "notas");
        return (disciplinaRepository.save(disciplina));
    }


    public Disciplina atualizaNotaDisciplina(Integer id, Disciplina disciplinaUpdate) {
        Disciplina disciplina = buscarPorId(id);
        //BeanUtils.copyProperties(disciplinaUpdate, disciplina, "id", "likes", "nome");
        disciplina.setNotas(disciplinaUpdate.getNotas());
        return (disciplinaRepository.save(disciplina));

    }

    public void deletar(Integer id) {
        buscarPorId(id);
        disciplinaRepository.deleteById(id);
    }

    public List<Disciplina> disciplinasComMaioresNotas() {
        List<Disciplina> lista = disciplinaRepository.findAll();

        Collections.sort(lista, Comparator.comparing(Disciplina::notaMediaDaDisciplina));

        return lista;
    }

    public List<Disciplina> disciplinasComMaiorLike() {
        List<Disciplina> lista = disciplinaRepository.findAll();

        Collections.sort(lista, Comparator.comparing(Disciplina::getLikes).reversed());

        return lista;
    }

    public Disciplina incrementaLikePorID(Integer id) {
        Disciplina disciplina = this.buscarPorId(id);
        disciplina.setLikes(disciplina.getLikes() + 1);

        return disciplinaRepository.save(disciplina);
    }

    public DisciplinaDTO toDisciplinaDTO(Disciplina disciplina) {
      DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
      disciplinaDTO.setNome(disciplina.getNome());
      disciplinaDTO.setLike(disciplina.getLikes());
      disciplinaDTO.setNotas(disciplina.getNotas().stream().map((e) -> new NotaDTO(e)).collect(Collectors.toList()));
      disciplinaDTO.setComentarios(disciplina.getComentarios().stream().map((c) -> new ComentarioDTO(c)).collect(Collectors.toList()));
      return  disciplinaDTO;
    }
}
