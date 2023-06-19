import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Empleado } from 'src/app/data/schema/empleado';
import { TipoUsuario } from 'src/app/data/schema/tipousuario';
import { Usuario } from 'src/app/data/schema/usuario';
import { EmpleadoService } from 'src/app/data/service/empleado.service';
import { TipoUsuarioService } from 'src/app/data/service/tipo-usuarios.service';
import { UsuarioService } from 'src/app/data/service/usuario.service';

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
      this.router.navigate(['usuario']);
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
