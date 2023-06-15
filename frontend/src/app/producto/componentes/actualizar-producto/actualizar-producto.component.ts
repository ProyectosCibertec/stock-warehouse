import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../../modelos/Producto';
import { ProductoService } from '../../servicios/producto.service';

@Component({
  selector: 'app-actualizar-producto',
  templateUrl: './actualizar-producto.component.html',
  styleUrls: ['./actualizar-producto.component.css']
})
export class ActualizarProductoComponent implements OnInit{

  producto: Producto= new Producto();
  constructor( private router:Router, private productoService:ProductoService) { }

  ngOnInit(): void {
    this.editar();
  }

  editar(){
    let id= JSON.parse(localStorage.getItem('id') as string);
    this.productoService.getProductoId(id).subscribe(data=>{
      this.producto=data;
    });
  }

  actualizar(producto:Producto){
    this.productoService.updateProducto(producto).subscribe(data=>{
        this.producto=data;
        this.router.navigate(['productos']);
    });
  }

}