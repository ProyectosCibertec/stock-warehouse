
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proveedor } from 'src/app/data/schema/proveedor';
import { ProveedorService } from 'src/app/data/service/proveedor.service';

@Component({
  selector: 'app-listar-proveedor',
  templateUrl: './listar-proveedor.component.html',
  styleUrls: ['./listar-proveedor.component.css']
})


export class ListarProveedorComponent implements OnInit {

  proveedores?: Proveedor[];

  constructor(private proveedorService: ProveedorService, private router: Router) { }

  ngOnInit(): void {
    this.listProveedores()
  }

  listProveedores(): void {
    this.proveedorService.getProveedores().subscribe(
      data => {
        this.proveedores = data;
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteProveedor(proveedor: Proveedor): void {
    this.proveedorService.deleteProveedor(proveedor).subscribe(data => {
      this.proveedores = this.proveedores!.filter(p => p.id != proveedor.id);
    });
  }
}

