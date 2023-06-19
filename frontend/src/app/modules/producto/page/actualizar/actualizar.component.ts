import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from 'src/app/data/schema/producto';
import { ProductoService } from 'src/app/data/service/producto.service';

@Component({
  selector: 'app-actualizar',
  templateUrl: './actualizar.component.html',
  styleUrls: ['./actualizar.component.css']
})
export class ActualizarComponent {
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
        this.router.navigate(['producto']);
    });
  }
}
