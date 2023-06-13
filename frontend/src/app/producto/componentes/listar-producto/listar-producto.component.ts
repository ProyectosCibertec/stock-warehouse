import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from '../../modelos/Producto';
import { ProductoService } from '../../servicios/producto.service';

@Component({
  selector: 'app-listar-producto',
  templateUrl: './listar-producto.component.html',
  styleUrls: ['./listar-producto.component.css']
})
export class ListarProductoComponent implements OnInit{

  productos?:Producto[];

  constructor(private productoService:ProductoService, private router:Router) { }

  ngOnInit(): void {
      
    this.productoService.getProductos().subscribe(
        data=>{
          this.productos=data;
          console.log(data);
        },
        error=>{
          console.log(error);
        }
    );
  }

  nuevo():void{
    this.router.navigate(['registrarProducto']);
  }

  editar(producto:Producto):void{
    localStorage.setItem("id",producto.id.toString());
    this.router.navigate(['actualizarProducto']);
  }

  eliminar(producto:Producto):void{
    this.productoService.deleteProducto(producto).subscribe(data=>{
          this.productos=this.productos!.filter(p=>p!=producto);
    });
  }

}

