import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { AdminPrincipalePageComponent } from './_Dashboard/_AdminDashboard/admin-principale-page/admin-principale-page.component';
import { HomeComponent } from './home/home/home.component';
import { StatistiuqeComponent } from './_Dashboard/_AdminDashboard/statistiuqe/statistiuqe.component';
import { TableAdminComponent } from './_Dashboard/_AdminDashboard/table-admin/table-admin.component';
import { ChefPrincipalPageComponent } from './_Dashboard/_chefDepDashboard/chef-principal-page/chef-principal-page.component';
import { TechPrinciplePageComponent } from './_Dashboard/_techDashboard/tech-principle-page/tech-principle-page.component';
import { ProfPrincipalPageComponent } from './_Dashboard/_profDashboard/prof-principal-page/prof-principal-page.component';
import { TableMaterielComponent } from './_Dashboard/_chefDepDashboard/table-materiel/table-materiel.component';
import { TabletechTechComponent } from './_Dashboard/_techDashboard/tabletech-tech/tabletech-tech.component';
import { FormAdminComponent } from './_Dashboard/_AdminDashboard/form-admin/form-admin.component';
import { FormDepartmentComponent } from './_Dashboard/_AdminDashboard/form-department/form-department.component';
import { FormMaterielComponent } from './_Dashboard/_chefDepDashboard/form-materiel/form-materiel.component';
import { TabletechReclamationComponent } from './_Dashboard/_techDashboard/tabletech-reclamation/tabletech-reclamation.component';
const routes: Routes = [
  { path: "home", component: HomeComponent },

  {
    path: "", component: AdminPrincipalePageComponent,
    children: [
      { path: "statistique", component: StatistiuqeComponent },
      {
        path: "admintable", component: TableAdminComponent,
        data: {
          origin: 'ADMIN'
        }
      },
      {
        path: "chefdepartemnttable", component: TableAdminComponent,
        data: {
          origin: 'CHEF'
        }
      },
      {
        path: "techtable", component: TableAdminComponent,
        data: {
          origin: 'TECH'
        }
      },
      {
        path: "profftable", component: TableAdminComponent,
        data: {
          origin: 'PROF'
        }
      },

      {
        path: "addadmin", component: FormAdminComponent,
        data: {
          origin: 'ADMIN'
        }
      },
      {
        path: "Updateadmin/:idadmin", component: FormAdminComponent,
        data: {
          origin: 'ADMIN'
        }
      },
      {
        path: "addchefdepartemnt", component: FormAdminComponent,
        data: {
          origin: 'CHEF'
        }
      },
      {
        path: "Updatechefdepartemnt", component: FormAdminComponent,
        data: {
          origin: 'CHEF'
        }
      },
      {
        path: "addtechn", component: FormAdminComponent,
        data: {
          origin: 'TECH'
        }
      },
      {
        path: "Updatetechn", component: FormAdminComponent,
        data: {
          origin: 'TECH'
        }
      },
      {
        path: "addprof", component: FormAdminComponent,
        data: {
          origin: 'PROF'
        }
      },
      {
        path: "Updateprof", component: FormAdminComponent,
        data: {
          origin: 'PROF'
        }
      }







    ]

  },

  { path: "tabled", component: TableMaterielComponent },

  { path: "formB", component: FormDepartmentComponent },
  { path: "formE", component: TabletechReclamationComponent },






  { path: "chef", component: ChefPrincipalPageComponent },
  { path: "tech", component: TechPrinciplePageComponent },
  { path: "prof", component: ProfPrincipalPageComponent },


];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
