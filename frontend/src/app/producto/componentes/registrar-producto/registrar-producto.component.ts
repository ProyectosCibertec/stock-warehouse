import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../../modelos/Producto';
import { ProductoService } from '../../servicios/producto.service';


@Component({
  selector: 'app-registrar-producto',
  templateUrl: './registrar-producto.component.html',
  styleUrls: ['./registrar-producto.component.css']
})
export class RegistrarProductoComponent implements OnInit{

  modelProducto = new Producto();
  constructor(private router:Router, private productoService:ProductoService) { }

  ngOnInit(): void {
  }

  guardar(producto:Producto){

    this.productoService.createProducto(producto).subscribe( data=>{
        this.router.navigate(['productos']);
    });
  }

}
