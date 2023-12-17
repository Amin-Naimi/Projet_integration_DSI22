import { Component } from '@angular/core';

import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { UtilisateurService } from 'src/app/services/utilisateur.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(
    private router: Router,
    public userService : UtilisateurService,
    public auth: AuthenticationService
    ){}

    public login(login: NgForm):void{
      console.log(login.value);
      this.userService.login(login.value).subscribe(
        (response:any)=>{

          console.log(response.accesToken);
          console.log(response.users.roleSet)
          this.auth.setRoles(response.users.roleSet)
          this.auth.setToken(response.accesToken)
          const role  = response.users.roleSet[0];
          const roleName = role.roleName;
          console.log(roleName);

          if(roleName === 'ADMIN'){
            this.router.navigate(['/statistique']);
          }else
          {
            this.router.navigate(['/home']);
          }
        },
        (error)=>{
          console.log(error);
        }
      );

    }

    }

