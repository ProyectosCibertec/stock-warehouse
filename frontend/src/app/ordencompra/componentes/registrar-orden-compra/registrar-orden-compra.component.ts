import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OrdenCompraService } from '../../servicios/orden-compra.service';
import { OrdenCompraCreate } from '../../modelos/OrdenCompraCreate';

@Component({
  selector: 'app-registrar-orden-compra',
  templateUrl: './registrar-orden-compra.component.html',
  styleUrls: ['./registrar-orden-compra.component.css']
})
export class RegistrarOrdenCompraComponent implements OnInit {

modelOrdenCompra = new OrdenCompraCreate();

constructor(private router: Router, private ordenCompraService: OrdenCompraService){}
  ngOnInit(): void {
    
  }

  guardarOrdenCompra( ordenCompraCreate: OrdenCompraCreate) {
    this.ordenCompraService.registrarOrdenCompra(ordenCompraCreate).subscribe(data => {
      this.router.navigate(['ordenesCompra']);
    });
  }
}
