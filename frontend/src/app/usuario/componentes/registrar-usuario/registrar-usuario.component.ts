import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../../servicios/usuario.service';
import { Usuario } from '../../modelos/Usuario';
import { TipoUsuarioService  } from 'src/app/tipo-usuario/servicios/tipo-usuarios.service';
import { TipoUsuario } from 'src/app/tipo-usuario/modelos/Tipo-usuario';
import { Empleado } from 'src/app/empleado/modelos/Empleado';
import { EmpleadoService } from 'src/app/empleado/servicios/empleado.service';

@Component({
  selector: 'app-registrar-usuario',
  templateUrl: './registrar-usuario.component.html',
  styleUrls: ['./registrar-usuario.component.css']
})
export class RegistrarUsuarioComponent  implements OnInit{
  tiposUsuario?:TipoUsuario[];
  empleados?:Empleado[];
  modelUsuario = new Usuario();

  constructor(private router: Router, private usuarioService: UsuarioService,private tipoUsuarioService:TipoUsuarioService, private empleadoService:EmpleadoService){}
  ngOnInit(): void {
    
    this.getObtenerListaDeUsuario();
    this.getEmpleados();
  }

  guardarUsuario(usuario: Usuario){
    this.modelUsuario.idEmpleado = usuario.idEmpleado;
    console.log(usuario.idEmpleado);
    this.usuarioService.registrarUsuario(usuario).subscribe(data => {
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
