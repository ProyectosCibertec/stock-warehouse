import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/data/schema/categoria';
import { CategoriaService } from 'src/app/data/service/categoria.service';

@Component({
  selector: 'app-actualizar',
  templateUrl: './actualizar.component.html',
  styleUrls: ['./actualizar.component.css']
})
export class ActualizarComponent implements OnInit {
  categoria: Categoria = new Categoria();

  constructor(
    private router: Router,
    private categoriaService: CategoriaService, 
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.getCategoria();
  }

  getCategoria() {
    let id = Number(this.route.snapshot.paramMap.get('id'));
    this.categoriaService.getCategoriaId(id).subscribe(data => {
      this.categoria = data;
    });
  }

  update(categoria: Categoria) {
    this.categoriaService.updateCategoria(categoria).subscribe(data => {
      this.categoria = data;
      this.router.navigate(['categoria']);
    });
  }
}
