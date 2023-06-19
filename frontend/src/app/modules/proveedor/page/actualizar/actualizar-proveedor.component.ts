import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proveedor } from 'src/app/data/schema/proveedor';
import { ProveedorService } from 'src/app/data/service/proveedor.service';

@Component({
  selector: 'app-actualizar-proveedor',
  templateUrl: './actualizar-proveedor.component.html',
  styleUrls: ['./actualizar-proveedor.component.css']
})
export class ActualizarProveedorComponent implements OnInit {
  proveedor: Proveedor = new Proveedor();

  constructor(
    private router: Router,
    private proveedorService: ProveedorService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getProveedor();
  }

  getProveedor() {
    let id = Number(this.route.snapshot.paramMap.get('id'));
    this.proveedorService.getProveedorId(id).subscribe(data => {
      this.proveedor = data;
    });
  }

  update(proveedor: Proveedor) {
    this.proveedorService.updateProveedor(proveedor).subscribe(data => {
      this.proveedor = data;
      this.router.navigate(['proveedor']);
    });
  }
}
