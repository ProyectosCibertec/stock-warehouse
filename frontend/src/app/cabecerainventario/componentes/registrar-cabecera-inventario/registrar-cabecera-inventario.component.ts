import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CabeceraInventarioService } from '../../servicios/cabecera-inventario.service';
import { CabeceraInventarioCreate } from '../../modelos/CabeceraInventarioCreate';

@Component({
  selector: 'app-registrar-cabecera-inventario',
  templateUrl: './registrar-cabecera-inventario.component.html',
  styleUrls: ['./registrar-cabecera-inventario.component.css']
})
export class RegistrarCabeceraInventarioComponent implements OnInit {

modelCabeceraInventario = new CabeceraInventarioCreate();

constructor(private router: Router, private cabeceraInventarioService: CabeceraInventarioService){}
  ngOnInit(): void {
    
  }

  guardarCabeceraInventario( cabeceraInventarioCreate: CabeceraInventarioCreate) {
    this.cabeceraInventarioService.registrarCabeceraInventario(cabeceraInventarioCreate).subscribe(data => {
      this.router.navigate(['cabecerasInventario']);
    });
  }
}
