import { Component, OnInit } from '@angular/core';
import { CabeceraInventarioService } from '../../servicios/cabecera-inventario.service';
import { Router } from '@angular/router';
import { CabeceraInventario } from '../../modelos/CabeceraInventario';
import { CabeceraInventarioUpdate } from '../../modelos/CabeceraInventarioUpdate';

@Component({
  selector: 'app-actualizar-cabecera-inventario',
  templateUrl: './actualizar-cabecera-inventario.component.html',
  styleUrls: ['./actualizar-cabecera-inventario.component.css']
})
export class ActualizarCabeceraInventarioComponent implements OnInit {

  cabeceraInventarioUpdate = new CabeceraInventarioUpdate();


  constructor(private router: Router, private cabecerainventarioService: CabeceraInventarioService){}
  ngOnInit(): void {
    this.editar();
  }

  editar(){
    let id = JSON.parse(localStorage.getItem('id') as string);
    this.cabecerainventarioService.obtenerCabeceraInventario(id).subscribe(
      data=>{this.cabeceraInventarioUpdate = data;
      });
  }

  actualizarCabeceraInventario(cabeceraInventarioUpdate:CabeceraInventarioUpdate){
    this.cabecerainventarioService.actualizarCabeceraInventario(cabeceraInventarioUpdate).subscribe(dato=>{
      this.cabeceraInventarioUpdate = dato;
      this.router.navigate(['cabecerasInventario']);
    });

}

}
