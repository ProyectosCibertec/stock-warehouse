import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TipoUsuario } from '../../modelos/Tipo-usuario';
import { TipoUsuarioService } from '../../servicios/tipo-usuarios.service';

@Component({
  selector: 'app-actualizar-tipo-usuario',
  templateUrl: './actualizar-tipo-usuario.component.html',
  styleUrls: ['./actualizar-tipo-usuario.component.css']
})
export class ActualizarTipoUsuarioComponent implements OnInit{

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
      this.router.navigate(['tiposUsuario']);
    });
}
}
