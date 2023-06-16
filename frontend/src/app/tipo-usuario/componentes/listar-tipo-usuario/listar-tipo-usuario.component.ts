import { Component, OnInit } from '@angular/core';
import { TipoUsuarioService } from '../../servicios/tipo-usuarios.service';
import { TipoUsuario } from '../../modelos/Tipo-usuario';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listar-tipo-usuario',
  templateUrl: './listar-tipo-usuario.component.html',
  styleUrls: ['./listar-tipo-usuario.component.css']
})
export class ListarTipoUsuarioComponent implements OnInit {
  
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
    this.router.navigate(['nuevaTipoUsuario']);
  }

  editarTipoUsuario(tipoUsuario:TipoUsuario):void {
    localStorage.setItem('id', tipoUsuario.idTipoUsuario.toString());
    this.router.navigate(['editarTipoUsuario']);
  }
  
  eliminarTipoUsuario(tipoUsuario:TipoUsuario):void {
    this.tipoUsuarioService.deleteTipoUsuario(tipoUsuario).subscribe(
      data=>{this.tiposUsuario=this.tiposUsuario!.filter(p=>p!==tipoUsuario)}
    )
  }

}