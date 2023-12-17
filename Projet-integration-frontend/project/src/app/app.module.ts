import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './home/home/home.component';
import { AdminPrincipalePageComponent } from './_Dashboard/_AdminDashboard/admin-principale-page/admin-principale-page.component';
import { StatistiuqeComponent } from './_Dashboard/_AdminDashboard/statistiuqe/statistiuqe.component';
import { TableAdminComponent } from './_Dashboard/_AdminDashboard/table-admin/table-admin.component';
import { FormAdminComponent } from './_Dashboard/_AdminDashboard/form-admin/form-admin.component';
import { FormDepartmentComponent } from './_Dashboard/_AdminDashboard/form-department/form-department.component';
import { ChefPrincipalPageComponent } from './_Dashboard/_chefDepDashboard/chef-principal-page/chef-principal-page.component';
import { TableMaterielComponent } from './_Dashboard/_chefDepDashboard/table-materiel/table-materiel.component';
import { FormMaterielComponent } from './_Dashboard/_chefDepDashboard/form-materiel/form-materiel.component';
import { TablechefAdminComponent } from './_Dashboard/_chefDepDashboard/tablechef-admin/tablechef-admin.component';
import { TablechefTechComponent } from './_Dashboard/_chefDepDashboard/tablechef-tech/tablechef-tech.component';
import { TablechefProfComponent } from './_Dashboard/_chefDepDashboard/tablechef-prof/tablechef-prof.component';
import { TablechefChefComponent } from './_Dashboard/_chefDepDashboard/tablechef-chef/tablechef-chef.component';
import { ReclamationValideComponent } from './_Dashboard/_chefDepDashboard/reclamation-valide/reclamation-valide.component';
import { TabletechChefComponent } from './_Dashboard/_techDashboard/tabletech-chef/tabletech-chef.component';
import { TechPrinciplePageComponent } from './_Dashboard/_techDashboard/tech-principle-page/tech-principle-page.component';
import { TabletechTechComponent } from './_Dashboard/_techDashboard/tabletech-tech/tabletech-tech.component';
import { TabletechMaterielComponent } from './_Dashboard/_techDashboard/tabletech-materiel/tabletech-materiel.component';
import { TabletechReclamationComponent } from './_Dashboard/_techDashboard/tabletech-reclamation/tabletech-reclamation.component';
import { TableprofReclamationRefuseeComponent } from './_Dashboard/_profDashboard/tableprof-reclamation-refusee/tableprof-reclamation-refusee.component';
import { TableprofReclamationComponent } from './_Dashboard/_profDashboard/tableprof-reclamation/tableprof-reclamation.component';
import { TableprofCheffComponent } from './_Dashboard/_profDashboard/tableprof-cheff/tableprof-cheff.component';
import { FormprofReclamationComponent } from './_Dashboard/_profDashboard/formprof-reclamation/formprof-reclamation.component';
import { ProfPrincipalPageComponent } from './_Dashboard/_profDashboard/prof-principal-page/prof-principal-page.component';
import { TableprofTechComponent } from './_Dashboard/_profDashboard/tableprof-tech/tableprof-tech.component';
import { MenuComponent } from './components/menu/menu.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AdminPrincipalePageComponent,
    StatistiuqeComponent,
    TableAdminComponent,
    FormAdminComponent,
    FormDepartmentComponent,
    ChefPrincipalPageComponent,
    TableMaterielComponent,
    FormMaterielComponent,
    TablechefAdminComponent,
    TablechefTechComponent,
    TablechefProfComponent,
    TablechefChefComponent,
    ReclamationValideComponent,
    TabletechChefComponent,
    TechPrinciplePageComponent,
    TabletechTechComponent,
    TabletechMaterielComponent,
    TabletechReclamationComponent,
    TableprofReclamationRefuseeComponent,
    TableprofReclamationComponent,
    TableprofCheffComponent,
    FormprofReclamationComponent,
    ProfPrincipalPageComponent,
    TableprofTechComponent,
    MenuComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
