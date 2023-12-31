import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  public clear(){
    localStorage.clear();
  }

  public isLoggedIn():boolean{
    let exciteUser = false;

    if(this.getToken() && this.getRoles()){
      exciteUser = true;
     }
     return exciteUser;
  }

  public setRoles(roles:[]){
    localStorage.setItem("roles", JSON.stringify(roles));
  }

  public getRoles(): string[] | null {
    const rolesString = localStorage.getItem("roles");
    if(rolesString != null){
    return JSON.parse(rolesString);
    }
    return null;

  }

  public setToken(token : string){
    localStorage.setItem("AccessToken", token);
  }

  public getToken(): string{
    const token = localStorage.getItem("AccessToken");
    return token!
  }

}
