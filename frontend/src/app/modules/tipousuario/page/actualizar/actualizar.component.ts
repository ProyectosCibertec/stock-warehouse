import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TipoUsuario } from 'src/app/data/schema/tipousuario';
import { TipoUsuarioService } from 'src/app/data/service/tipo-usuarios.service';

@Component({
  selector: 'app-actualizar',
  templateUrl: './actualizar.component.html',
  styleUrls: ['./actualizar.component.css']
})
export class ActualizarComponent {

  tipoUsuario = new TipoUsuario();
   
  constructor(private router: Router, private tipoUsuarioService: TipoUsuarioService){}
  ngOnInit(): void {
    this.editar();
  }

  editar(){
    let id = JSON.parse(localStorage.getItem('id') as string);
    this.tipoUsuarioService.obtenerTipoUsuario(id).subscribe(
      data=>{this.tipoUsuario = data;
      });
  }

  actualizarTipoUsuario(tipoUsuario:TipoUsuario){
    this.tipoUsuarioService.actualizarTipoUsuario(tipoUsuario).subscribe(dato=>{
      this.tipoUsuario = dato;
      this.router.navigate(['tipo-usuario']);
    });
}
}
