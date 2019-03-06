package br.com.poc.cadastro.controller;

import java.util.HashSet;
import java.util.Set;
 
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.cadastro.authentication.JwtProvider;
import br.com.poc.cadastro.model.PerfilUsuario;
import br.com.poc.cadastro.model.PerfilUsuarioEnum;
import br.com.poc.cadastro.model.Usuario;
import br.com.poc.cadastro.repository.PerfilUsuarioRepository;
import br.com.poc.cadastro.repository.UsuarioRepository;
import br.com.poc.cadastro.request.JwtResponse;
import br.com.poc.cadastro.request.LoginForm;
import br.com.poc.cadastro.request.ResponseMessage;
import br.com.poc.cadastro.request.SignUpForm;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	private AuthenticationManager authenticationManager;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	public AuthRestAPIs(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {

		// Creating user's account
		Usuario user = new Usuario(signUpRequest.getLogin(),
				encoder.encode(signUpRequest.getSenha()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<PerfilUsuario> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "administrador":
				PerfilUsuario adminRole = perfilUsuarioRepository.findByPerfil(PerfilUsuarioEnum.ADMINISTRADOR)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "funcionario":
				PerfilUsuario pmRole = perfilUsuarioRepository.findByPerfil(PerfilUsuarioEnum.FUNCIONARIO)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:

			}
		});

		user.setPerfil(roles);
		usuarioRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registrado com sucesso!"), HttpStatus.OK);
	}

}
