package br.com.agendadelives.service;

import br.com.agendadelives.entity.Live;
import br.com.agendadelives.exceptions.ErroAoListarLivesException;
import br.com.agendadelives.exceptions.ValorNaoPodeSerNuloException;
import br.com.agendadelives.exceptions.RegistroNaoEncontradoException;
import br.com.agendadelives.repository.LiveRepository;
import br.com.agendadelives.repository.LiveRepositoryQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class LiveService {

    LiveRepositoryQuery repositoryQuery;

    @Autowired
    LiveRepository repository;

    public Live adicionarLive(Live live) {
        validarLive(live);
        return repository.save(live);
    }

    public Optional<Live> buscarLivePorId(Long id){
        validarId(id);
        Optional<Live> live = repository.findById(id);
        if(!live.isPresent()){
            throw new RegistroNaoEncontradoException("Não encontrado registro de live correspondente.");
        }
        return live;
    }

    public Page<Live> listarLives(Pageable pageable, String flag) {
        if(flag != null && flag.equals("next")){
            return repositoryQuery.findByLiveDateAfterOrderByLiveDateAsc(LocalDateTime.now(), pageable);
        }else if(flag != null && flag.equals("previous")){
            return repositoryQuery.findByLiveDateBeforeOrderByLiveDateDesc(LocalDateTime.now(), pageable);
        }else if(flag.isBlank()){
            throw new ErroAoListarLivesException("Sua pesquisa não corresponde a nenhum resultado");
        } else{
            return repository.findAll(pageable);
        }
    }

    public Live atualizarLive(Live live, Long id){
        buscarLivePorId(id);
        validarLive(live);
        return repository.save(live);
    }

    public Boolean deletarLive(Live live){
        validarLive(live);
        repository.delete(live);
        return true;
    }

    private Boolean validarId(Long id) {
        if (Objects.isNull(id)){
            throw new ValorNaoPodeSerNuloException("Id não pode ser nulo");
        }
        return true;
    }

    private Boolean validarLive(Live live){
        if (Objects.isNull(live.getLinkLive())){
            throw new ValorNaoPodeSerNuloException("Live não pode estar vazia");
        }
        return true;
    }

}
