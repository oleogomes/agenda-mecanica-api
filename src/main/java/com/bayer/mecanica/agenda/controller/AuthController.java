package com.bayer.mecanica.agenda.controller;

import com.bayer.mecanica.agenda.representation.authorization.request.CadastrarPessoaRequest;
import com.bayer.mecanica.agenda.representation.authorization.request.LoginRequest;
import com.bayer.mecanica.agenda.representation.authorization.response.JwtResponse;
import com.bayer.mecanica.agenda.security.jwt.JwtUtils;
import com.bayer.mecanica.agenda.security.services.UserDetailsImpl;
import com.bayer.mecanica.agenda.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PessoaService pessoaService;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/cadastro")
	public ResponseEntity<?> cadastrarPessoa(@Valid @RequestBody CadastrarPessoaRequest cadastrarPessoaRequest) {
		return pessoaService.cadastrarPessoa(cadastrarPessoaRequest);
	}


}
