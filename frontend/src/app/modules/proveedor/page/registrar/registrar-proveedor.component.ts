import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proveedor } from 'src/app/data/schema/proveedor';
import { ProveedorService } from 'src/app/data/service/proveedor.service';

@Component({
  selector: 'app-registrar-proveedor',
  templateUrl: './registrar-proveedor.component.html',
  styleUrls: ['./registrar-proveedor.component.css']
})
export class RegistrarProveedorComponent implements OnInit {
  modelProveedor = new Proveedor();

  constructor(private router: Router, private proveedorService: ProveedorService) { }

  ngOnInit(): void {
  }

  guardar(proveedor: Proveedor) {
    this.proveedorService.createProveedor(proveedor).subscribe(data => {
      this.router.navigate(['proveedor']);
    });
  }
}