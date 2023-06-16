import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipoUsuarioService  } from '../../servicios/tipo-usuarios.service';
import { TipoUsuario } from '../../modelos/Tipo-usuario';


@Component({
  selector: 'app-registrar-tipo-usuario',
  templateUrl: './registrar-tipo-usuario.component.html',
  styleUrls: ['./registrar-tipo-usuario.component.css']
})
export class RegistrarTipoUsuarioComponent implements OnInit {
  modelTipoUsuario = new TipoUsuario();

  constructor(private router: Router, private tipoUsuarioService: TipoUsuarioService){}
  ngOnInit(): void {
  }

  guardarTipoUsuario( tipoUsuario: TipoUsuario) {
    this.tipoUsuarioService.registrarTipoUsuario(tipoUsuario).subscribe(data => {
      this.router.navigate(['tiposUsuario']);
    });
  }
}
