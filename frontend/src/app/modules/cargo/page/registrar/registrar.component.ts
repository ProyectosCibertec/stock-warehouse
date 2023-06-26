import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cargo } from 'src/app/data/schema/cargo';
import { CargoService } from 'src/app/data/service/cargo.service';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.css']
})
export class RegistrarComponent implements OnInit {
  modelCargo = new Cargo();
  
  constructor(private router: Router, private cargoService: CargoService) { }

  ngOnInit(): void {
  }

  guardar(cargo: Cargo) {
    this.cargoService.createCargo(cargo).subscribe(data => {
      this.router.navigate(['cargo']);
    });
  }
}
