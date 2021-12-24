package com.example.EmpresaApi.Controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.example.EmpresaApi.ControllerDto.FuncionarioDto;
import com.example.EmpresaApi.Form.FuncionarioForm;
import com.example.EmpresaApi.Repository.CargoRepository;
import com.example.EmpresaApi.Repository.FuncionarioRepository;
import com.example.EmpresaApi.models.Funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/funcionario")
@RestController
public class FuncionarioController 
{
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @GetMapping
    public List<Funcionario> listarFuncionarios()
    {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        
        return funcionarios;
    }
    
    @PostMapping
    @Transactional
    public Funcionario listaFuncionarioPorNome(@RequestBody @Valid FuncionarioForm form)
    {
        Funcionario funcionario = funcionarioRepository.findByNome(form.getNomeFuncionario());

        return funcionario;
    }

    public ResponseEntity<FuncionarioDto> atualizar(@RequestBody @Valid FuncionarioForm form)
    {
        Funcionario funcionario = funcionarioRepository.findByNome(form.getNomeFuncionario());

        if(funcionario != null)
        {
            funcionario = form.atualizarFuncionario(funcionario.getId(), funcionarioRepository);
            return ResponseEntity.ok(new FuncionarioDto(funcionario));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> cadastrar(FuncionarioForm funcionarioForm, UriComponentsBuilder uriBuilder)
    {   
        Funcionario funcionario = funcionarioForm.converterFuncionario(cargoRepository);

        funcionarioRepository.save(funcionario);

        URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new FuncionarioDto(funcionario));
    }

    public ResponseEntity<?> remover(Integer id)
    {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
        if(funcionario.isPresent())
        {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
        
    }

}
