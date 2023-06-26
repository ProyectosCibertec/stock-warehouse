import { Component, OnInit } from '@angular/core';
import { Cargo } from 'src/app/data/schema/cargo';
import { CargoService } from 'src/app/data/service/cargo.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  cargos?: Cargo[];

  constructor(private cargoService: CargoService) { }

  ngOnInit(): void {
    this.listCargos()
  }

  listCargos(): void {
    this.cargoService.getCargos().subscribe(
      data => {
        this.cargos = data
      },
      error => {
        console.log(error)
      }
    );
  }

  deleteCargo(cargo: Cargo): void {
    this.cargoService.deleteCargo(cargo).subscribe(() => {
      this.cargos = this.cargos?.filter(e => e.id != cargo.id)
    });
  }
}
