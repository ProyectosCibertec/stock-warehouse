import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from 'src/app/data/schema/producto';
import { ProductoService } from 'src/app/data/service/producto.service';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.css']
})
export class RegistrarComponent {
  modelProducto = new Producto();
  constructor(private router:Router, private productoService:ProductoService) { }

  ngOnInit(): void {
  }

  guardar(producto:Producto){

    this.productoService.createProducto(producto).subscribe( data=>{
        this.router.navigate(['producto']);
    });
  }
}
