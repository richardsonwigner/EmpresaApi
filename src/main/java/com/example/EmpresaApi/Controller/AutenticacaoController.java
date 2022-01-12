package com.example.EmpresaApi.Controller;

import javax.validation.Valid;

import com.example.EmpresaApi.ControllerDto.TokenDto;
import com.example.EmpresaApi.Form.LoginForm;
import com.example.EmpresaApi.Security.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController 
{   
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm loginForm)
    {
        UsernamePasswordAuthenticationToken dados = loginForm.converter();

        try
        {
            Authentication authentication = authManager.authenticate(dados);
            String token = tokenService.gerarToken(authentication);
            System.out.println(token);
            return ResponseEntity.ok(new TokenDto(token, "Bearer"));
        }
        catch(AuthenticationServiceException e)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
