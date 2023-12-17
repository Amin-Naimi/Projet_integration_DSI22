import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Adresse } from 'src/app/Models/adresse';
import { Utilisateur } from 'src/app/Models/users';
import { UtilisateurService } from 'src/app/services/utilisateur.service';

@Component({
  selector: 'app-form-admin',
  templateUrl: './form-admin.component.html',
  styleUrls: ['./form-admin.component.css']
})
export class FormAdminComponent {

  origin = "";
  imageLink = "";
  titre = "";
  utilisateurs: Utilisateur = {};

  adresse: Adresse = {};
  errorsMsg: Array<string> = [];
  idUser: number = 0;
  operationType: string = "";


  constructor(private activatedRoute: ActivatedRoute,
    private userService: UtilisateurService,
    private router: Router) { }

  ngOnInit(): void {
    this.setImageLink();
    this.activatedRoute.data.subscribe((data: any) => {
      this.origin = data.origin;
    })
    console.log("origin de route: " + this.origin);
    this.idUser = this.activatedRoute.snapshot.params['idadmin'];
    console.log("idUser de route: " + this.idUser);
    if (this.idUser) {
      this.userService.findById(this.idUser).subscribe((response: Utilisateur) => {
        console.log(" find by id responce " + response);
        console.log("Mon adresse" + response.adresse?.region)
        this.utilisateurs = response;
        this.adresse = response.adresse!;
      },
        (error: any) => {
          console.log(error);
        }
      )
    }

  }

  activateRoute(): void {
    this.activatedRoute.data.subscribe((data: any) => {
      this.origin = data.origin;
      console.log("Dans le formulaie  : " + this.origin);
    })
  }

  setImageLink(): void {
    this.activateRoute();
    if (this.origin === "ADMIN") {
      this.imageLink = "https://img.freepik.com/free-vector/access-control-system-abstract-concept_335657-3180.jpg?w=2000";
      this.titre = "Ajouter un administrateur";

    } else if (this.origin === "CHEF") {
      this.imageLink = "https://img.freepik.com/vecteurs-libre/illustration-vectorielle-culture-milieu-travail-concept-abstrait-valeurs-partagees-systemes-croyance-attitude-au-travail-equipe-entreprise-culture-entreprise-haute-performance-metaphore-abstraite-sante-employes_335657-1930.jpg";
      this.titre = "Ajouter un chef de departemnt";

    }
    else if (this.origin === "TECH") {
      this.imageLink = "https://img.freepik.com/premium-vector/car-mechanic-concept_108855-3769.jpg?w=740";
      this.titre = "Ajouter un technicien";


    } else if (this.origin === "PROF") {
      this.imageLink = "https://img.freepik.com/free-vector/professor-concept-illustration_114360-3270.jpg";
      this.titre = "Ajouter un profeseure";

    }
  }

  createUser() {
    this.activateRoute();
    console.log("Dans la fonctione created new user" + this.origin);
    if (this.origin === "ADMIN") {
      console.log(this.utilisateurs);
      this.utilisateurs.adresse = this.adresse;
      console.log("Mon user " + this.utilisateurs);
      this.userService.saveAdmin(this.utilisateurs).subscribe(
        (response: Utilisateur) => {
          console.log("response", response);
          this.router.navigate(['/admintable']);
        },
        (error: any) => {
          console.log("error", error);
          if (error && error.error && error.error.errors) {
            this.errorsMsg = error.error.errors;
            console.log("errorsMsg", this.errorsMsg);
          } else {
            console.log("Unknown error occurred");
          }
        }
      )
    } else if (this.origin === "CHEF") {
      console.log(this.utilisateurs);
      this.utilisateurs.adresse = this.adresse;
      console.log("Mon user " + this.utilisateurs);
      this.userService.savechef(this.utilisateurs).subscribe(
        (response: Utilisateur) => {
          console.log("response", response);
          this.router.navigate(['/chefdepartemnttable']);
        },
        (error: any) => {
          console.log("error", error);
          if (error && error.error && error.error.errors) {
            this.errorsMsg = error.error.errors;
            console.log("errorsMsg", this.errorsMsg);
          } else {
            console.log("Unknown error occurred");
          }
        }
      )
    }
    else if (this.origin === "TECH") {
      console.log(this.utilisateurs);
      this.utilisateurs.adresse = this.adresse;
      console.log("Mon user " + this.utilisateurs);
      this.userService.saveTech(this.utilisateurs).subscribe(
        (response: Utilisateur) => {
          console.log("response", response);
          this.router.navigate(['/techtable']);
        },
        (error: any) => {
          console.log("error", error);
          if (error && error.error && error.error.errors) {
            this.errorsMsg = error.error.errors;
            console.log("errorsMsg", this.errorsMsg);
          } else {
            console.log("Unknown error occurred");
          }
        }
      )
    }
    else if (this.origin === "PROF") {
      console.log(this.utilisateurs);
      this.utilisateurs.adresse = this.adresse;
      console.log("Mon user " + this.utilisateurs);
      this.userService.saveprof(this.utilisateurs).subscribe(
        (response: Utilisateur) => {
          console.log("response", response);
          this.router.navigate(['/profftable']);
        },
        (error: any) => {
          console.log("error", error);
          if (error && error.error && error.error.errors) {
            this.errorsMsg = error.error.errors;
            console.log("errorsMsg", this.errorsMsg);
          } else {
            console.log("Unknown error occurred");
          }
        }
      )

    }
  }

  annulerFunction(): void {
    if (this.origin === "ADMIN") {
      this.router.navigate(['/admintable']);
    } else if (this.origin === "CHEF") {
      this.router.navigate(['/chefdepartemnttable']);
    }
    else if (this.origin === "TECH") {
      this.router.navigate(['/techtable']);
    }
    else if (this.origin === "PROF") {
      this.router.navigate(['/profftable']);
    }
  }

}
