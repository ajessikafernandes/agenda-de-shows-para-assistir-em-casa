package br.com.agendadelives.controller;

import br.com.agendadelives.entity.Live;
import br.com.agendadelives.service.LiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

//Cross-Origin Resource Sharing ( CORS ) é um conceito de segurança que
// permite restringir os recursos implementados em navegadores web.
// Evita que o código JavaScript produza ou consuma as solicitações
// em diferentes origens.
@CrossOrigin(origins = "*")
@Controller
public class LiveController {

    @Autowired
    LiveService service;

    @GetMapping("/lives")
    public ResponseEntity<Page<Live>> listarLives(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable,
                                                  @RequestParam(required = false) String flag){

        Page<Live> livePage = service.listarLives((org.springframework.data.domain.Pageable) pageable, flag);
        if (livePage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Page<Live>>(livePage, HttpStatus.OK);
        }
    }

    @GetMapping("/lives/info")
    public ResponseEntity<Live> buscarLivePorId(@RequestHeader("id") Long id){
        Optional<Live> liveIn = service.buscarLivePorId(id);
        if (!liveIn.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Live>(liveIn.get(), HttpStatus.OK);
        }
    }

    @PostMapping(value = "/lives")
    public ResponseEntity<Live> adicionarLive(@RequestBody @Validated Live live){
        if(live != null) {
            return new ResponseEntity<Live>(service.adicionarLive(live), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/lives")
    public ResponseEntity<Live> atualizarLivePorId(@RequestHeader("id") Long id, @RequestBody @Validated Live live){
        Optional<Live> liveIn = Optional.ofNullable(service.atualizarLive(live, id));
        if (!liveIn.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            live.setId(liveIn.get().getId());
            return new ResponseEntity<Live>(service.atualizarLive(live, id), HttpStatus.OK);
        }
    }

    @DeleteMapping("/lives")
    public ResponseEntity<Live> deletarLivePorId(@RequestHeader("id") Long id){
        Optional<Live> liveIn = service.buscarLivePorId(id);
        if (!liveIn.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            service.deletarLive(liveIn.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
