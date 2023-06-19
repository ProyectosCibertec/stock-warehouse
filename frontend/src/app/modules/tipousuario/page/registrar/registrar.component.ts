import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TipoUsuario } from 'src/app/data/schema/tipousuario';
import { TipoUsuarioService } from 'src/app/data/service/tipo-usuarios.service';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.css']
})
export class RegistrarComponent {
  modelTipoUsuario = new TipoUsuario();

  constructor(private router: Router, private tipoUsuarioService: TipoUsuarioService){}
  ngOnInit(): void {
  }

  guardarTipoUsuario( tipoUsuario: TipoUsuario) {
    this.tipoUsuarioService.registrarTipoUsuario(tipoUsuario).subscribe(data => {
      this.router.navigate(['tipo-usuario']);
    });
  }
}
