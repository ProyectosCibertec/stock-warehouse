import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../../servicios/usuario.service';
import { Usuario } from '../../modelos/Usuario';
import { TipoUsuarioService  } from 'src/app/tipo-usuario/servicios/tipo-usuarios.service';
import { TipoUsuario } from 'src/app/tipo-usuario/modelos/Tipo-usuario';
import { Empleado } from 'src/app/empleado/modelos/Empleado';
import { EmpleadoService } from 'src/app/empleado/servicios/empleado.service';

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
      this.router.navigate(['usuarios']);
    });

}

  getObtenerListaDeUsuario() {
    this.tipoUsuarioService.getObtenerListaDeTiposUsuario().subscribe(
      data => {
        this.tiposUsuario = data;
        console.log(data);
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
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }
}
