import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Utilisateur } from 'src/app/Models/users';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-table-admin',
  templateUrl: './table-admin.component.html',
  styleUrls: ['./table-admin.component.css']
})
export class TableAdminComponent implements OnInit {

  origin = "";


  users: Utilisateur[] =[];

  constructor(private userService: UtilisateurService,
    private ActivatedRoute: ActivatedRoute,
    private router : Router) { }

    ngOnInit(): void {
      this.loadUsers();
      this.activateRoute();
    }

    activateRoute():void{
      this.ActivatedRoute.data.subscribe((data :any) => {
        this.origin = data.origin;
        console.log("Dans la Table : "+this.origin);
      })
    }

    loadUsers(): void {
     let typeUser = "";
     this.activateRoute();
     typeUser = this.origin;
     console.log("type user : " + typeUser);
      this.userService.getAlluser(typeUser).subscribe(
        (response: Utilisateur[]) => {
          this.users = response;
          console.log(this.users); // afficher la liste des utilisateurs dans la console
        },
        (error: any) => {
          console.log(error); // afficher l'erreur éventuelle dans la console
        }
      );

    }

    modifierAdmin(id? : number): void {
        this.router.navigate(['Updateadmin', id]);
      }
    }


