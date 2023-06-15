import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthLayoutComponent } from './layout/auth-layout/auth-layout.component';
import { ContentLayoutComponent } from './layout/content-layout/content-layout.component';
import { AuthGuard } from './core/guard/auth.guard';
import { LoginGuard } from './core/guard/login.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'auth/login',
    pathMatch: 'full'
  },
  {
    path: 'auth',
    component: AuthLayoutComponent,
    canActivate: [LoginGuard('empleado')],
    loadChildren: () => import('./modules/auth/auth.module').then(m => m.AuthModule)
  },
  {
    path: '',
    component: ContentLayoutComponent,
    canActivate: [AuthGuard('auth/login')],
    children: [
      {
        path: 'empleado',
        loadChildren: () => import('./modules/empleado/empleado.module').then(m => m.EmpleadoModule)
      },
      {
        path: 'ordencompra',
        loadChildren: () => import('./modules/ordencompra/ordencompra.module').then(m => m.OrdencompraModule)
      },
      {
        path: 'proveedor',
        loadChildren: () => import('./modules/proveedor/proveedor.module').then(m => m.ProveedorModule)
      },
      {
        path: 'usuario',
        loadChildren: () => import('./modules/usuario/usuario.module').then(m => m.UsuarioModule)
      },
      {
        path: 'cargo',
        loadChildren: () => import('./modules/cargo/cargo.module').then(m => m.CargoModule)
      }
    ]
  },
  {
    path: '**',
    redirectTo: 'auth/login',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
