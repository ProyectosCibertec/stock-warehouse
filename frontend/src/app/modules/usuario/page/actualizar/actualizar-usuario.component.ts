import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from 'src/app/data/schema/empleado';
import { TipoUsuario } from 'src/app/data/schema/tipousuario';
import { Usuario } from 'src/app/data/schema/usuario';
import { EmpleadoService } from 'src/app/data/service/empleado.service';
import { TipoUsuarioService } from 'src/app/data/service/tipo-usuarios.service';
import { UsuarioService } from 'src/app/data/service/usuario.service';

@Component({
  selector: 'app-actualizar-usuario',
  templateUrl: './actualizar-usuario.component.html',
  styleUrls: ['./actualizar-usuario.component.css']
})
export class ActualizarUsuarioComponent implements OnInit {

  tiposUsuario?:TipoUsuario[];
  empleados?:Empleado[];
  modelUsuario = new Usuario();

  constructor(private router: Router, private usuarioService: UsuarioService,private tipoUsuarioService:TipoUsuarioService, private empleadoService:EmpleadoService){}
  ngOnInit(): void {
    this.getObtenerListaDeUsuario();
    this.getEmpleados();
    this.editar();
  }

  editar(){
    let id = JSON.parse(localStorage.getItem('id') as string);
    this.usuarioService.obtenerUsuario(id).subscribe(
      data=>{this.modelUsuario = data;
      });
  }

  actualizarUsuario(usuario:Usuario){
    this.usuarioService.actualizarUsuario(usuario).subscribe(dato=>{
      this.modelUsuario = dato;
      this.router.navigate(['usuario']);
    });

}

  getObtenerListaDeUsuario() {
    this.tipoUsuarioService.getObtenerListaDeTiposUsuario().subscribe(
      data => {
        this.tiposUsuario = data;
      },
      error => {
        console.log(error);
      }
    );
  }
  
  getEmpleados() {
    this.empleadoService.getEmpleados().subscribe(
      data => {
        this.empleados = data;
      },
      error => {
        console.log(error);
      }
    );
  }
}
