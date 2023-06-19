import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from 'src/app/data/schema/producto';
import { ProductoService } from 'src/app/data/service/producto.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent {
  productos?:Producto[];

  constructor(private productoService:ProductoService, private router:Router) { }

  ngOnInit(): void {
      
    this.productoService.getProductos().subscribe(
        data=>{
          this.productos=data;
        },
        error=>{
          console.log(error);
        }
    );
  }

  editar(producto:Producto):void{
    localStorage.setItem("id",producto.id.toString());
    this.router.navigate(['producto/actualizar']);
  }

  eliminar(producto:Producto):void{
    this.productoService.deleteProducto(producto).subscribe(data=>{
          this.productos=this.productos!.filter(p=>p!=producto);
    });
  }
}
