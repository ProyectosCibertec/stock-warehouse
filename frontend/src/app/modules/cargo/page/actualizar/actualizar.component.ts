import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Cargo } from 'src/app/data/schema/cargo';
import { CargoService } from 'src/app/data/service/cargo.service';

@Component({
  selector: 'app-actualizar',
  templateUrl: './actualizar.component.html',
  styleUrls: ['./actualizar.component.css']
})
export class ActualizarComponent implements OnInit {
  cargo: Cargo = new Cargo();

  constructor(
    private router: Router,
    private cargoService: CargoService, 
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getCargo();
  }

  getCargo() {
    let id = Number(this.route.snapshot.paramMap.get('id'));
    this.cargoService.getCargoId(id).subscribe(data => {
      this.cargo = data;
    });
  }

  update(cargo: Cargo) {
    this.cargoService.updateCargo(cargo).subscribe(data => {
      this.cargo = data;
      this.router.navigate(['cargo']);
    });
  }
}
