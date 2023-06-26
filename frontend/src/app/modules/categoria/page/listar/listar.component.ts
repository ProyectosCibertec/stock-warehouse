import { Component, OnInit } from '@angular/core';
import { Categoria } from 'src/app/data/schema/categoria';
import { CategoriaService } from 'src/app/data/service/categoria.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {
  categorias?: Categoria[];

  constructor(private categoriaService: CategoriaService) { }

  ngOnInit(): void {
    this.listCategorias()
  }

  listCategorias(): void {
    this.categoriaService.getCategorias().subscribe(
      data => {
        this.categorias = data
      },
      error => {
        console.log(error)
      }
    );
  }

  deleteCategoria(categoria: Categoria): void {
    this.categoriaService.deleteCategoria(categoria).subscribe(() => {
      this.categorias = this.categorias?.filter(e => e.id != categoria.id)
    });
  }
}
