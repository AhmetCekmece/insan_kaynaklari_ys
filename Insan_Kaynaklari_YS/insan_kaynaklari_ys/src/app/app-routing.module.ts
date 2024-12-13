import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'candidates/home',
    loadChildren: () => import('./home/home.module').then( m => m.HomePageModule)
  },
  {path: 'candidates', redirectTo: 'candidates/home', pathMatch: 'full'},
  {path: '', redirectTo: 'candidates/home', pathMatch: 'full'},
  {
    path: 'candidates/update/:id',
    loadChildren: () => import('./update/update.module').then( m => m.UpdatePageModule)
  },
  {
    path: 'candidates/create',
    loadChildren: () => import('./create/create.module').then( m => m.CreatePageModule)
  },

];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
