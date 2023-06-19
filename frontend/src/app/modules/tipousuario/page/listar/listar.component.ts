import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { TipoUsuario } from 'src/app/data/schema/tipousuario';
import { TipoUsuarioService } from 'src/app/data/service/tipo-usuarios.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent {

  tiposUsuario?:TipoUsuario[];
  tipoUsuario = new TipoUsuario();


  constructor(private tipoUsuarioService:TipoUsuarioService, private router:Router){
    this.tiposUsuario=[];
  }

  ngOnInit(): void {
    this.getObtenerTiposUsuario();
  }

 private getObtenerTiposUsuario(){
    this.tipoUsuarioService.getObtenerListaDeTiposUsuario().subscribe(
      data =>{ 
        this.tiposUsuario = data;
        console.log(data);
      },
      error => {
        console.log(error);
      }
    );
  }

  nuevoTipoUsuario():void {
    this.router.navigate(['tipo-usuario/registrar']);
  }

  editarTipoUsuario(tipoUsuario:TipoUsuario):void {
    localStorage.setItem('id', tipoUsuario.idTipoUsuario.toString());
    this.router.navigate(['tipo-usuario/actualizar']);
  }
  
  eliminarTipoUsuario(tipoUsuario:TipoUsuario):void {
    this.tipoUsuarioService.deleteTipoUsuario(tipoUsuario).subscribe(
      data=>{this.tiposUsuario=this.tiposUsuario!.filter(p=>p!==tipoUsuario)}
    )
  }

}
