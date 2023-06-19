import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/data/schema/usuario';
import { UsuarioService } from 'src/app/data/service/usuario.service';
@Component({
  selector: 'app-listar-usuario',
  templateUrl: './listar-usuario.component.html',
  styleUrls: ['./listar-usuario.component.css']
})
export class ListarUsuarioComponent implements OnInit {

  usuarios?:Usuario[];
  usuario = new Usuario();

  constructor(private usuarioService:UsuarioService, private router:Router){
    this.usuarios=[];
  }
  ngOnInit(): void {
    this.getObtenerUsuarios();
  }

 private getObtenerUsuarios(){
    this.usuarioService.getObtenerListaDeUsuario().subscribe(
      data =>{ 
        this.usuarios = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  nuevoUsuario():void {
    this.router.navigate(['usuario/registrar']);
  }

  editarUsuario(usuario:Usuario):void {
    localStorage.setItem('id', usuario.id_usuario.toString());
    this.router.navigate(['usuario/actualizar']);
  }
  
  eliminarUsuario(usuario: Usuario): void {
    this.usuarioService.deleteUsuario(usuario).subscribe(
      () => {
        this.usuarios = this.usuarios!.filter(p => p !== usuario);
      },
      error => {
        console.log(error);
      }
    );
  }

}