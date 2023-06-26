import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Categoria } from 'src/app/data/schema/categoria';
import { CategoriaService } from 'src/app/data/service/categoria.service';

@Component({
  selector: 'app-registrar',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.css']
})
export class RegistrarComponent implements OnInit {
  modelCategoria = new Categoria();
  
  constructor(private router: Router, private categoriaService: CategoriaService) { }

  ngOnInit(): void {
  }

  guardar(categoria: Categoria) {
    this.categoriaService.createCategoria(categoria).subscribe(data => {
      this.router.navigate(['categoria']);
    });
  }
}
