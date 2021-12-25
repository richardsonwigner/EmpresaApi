package com.example.EmpresaApi.Controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/{id}")
    public Optional<Funcionario> listaFuncionarioPorId(@PathVariable Integer id)
    {
        Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

        return funcionario;
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<FuncionarioDto> atualizar(@RequestBody @Valid FuncionarioForm form, @PathVariable Integer id)
    {
        Funcionario funcionario = form.atualizarFuncionario(id, funcionarioRepository);

        if(Objects.nonNull(funcionario))
        {
            return ResponseEntity.ok(new FuncionarioDto(funcionario));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<FuncionarioDto> cadastrar(@RequestBody @Valid FuncionarioForm funcionarioForm, UriComponentsBuilder uriBuilder)
    {   
        List<Funcionario> funcionarios = funcionarioRepository.findAll();

        Integer idFuncionario = 1 + funcionarios.size();

        Funcionario funcionario = funcionarioForm.converterFuncionario(idFuncionario, cargoRepository);

        funcionarioRepository.save(funcionario);

        URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();

        return ResponseEntity.created(uri).body(new FuncionarioDto(funcionario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Integer id)
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
