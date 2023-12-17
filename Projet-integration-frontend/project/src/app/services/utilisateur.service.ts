import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { Observable } from 'rxjs';
import { Utilisateur } from '../Models/users';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient,
    private auth: AuthenticationService) { }

  APP_URL = 'http://localhost:8086';
  requestHeader = new HttpHeaders(
    { "No-Auth": "True" }
  )

  public login(LoginData: any) {
    return this.http.post(`${this.APP_URL}/login`, LoginData, { headers: this.requestHeader })
  }

  public roleVerification(roles: any): boolean {
    let isValid: boolean = false;
    const userRoles: any = this.auth.getRoles();

    if (userRoles != null && userRoles) {
      for (let i = 0; i < userRoles.length; i++) {
        for (let j = 0; j < roles.length; j++) {
          if (userRoles[i].roleName === roles[j]) {
            isValid = true;
            return isValid;
          }
        }
      }
    }
    // return false if no matching role found
    return isValid;
  }

  getAlluser(roleName: string): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(`${this.APP_URL}/user/all?roleName=${roleName}`);
  }

  saveAdmin(admin: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.APP_URL}/user/create/admin`, admin, { headers: this.requestHeader });
  }
  savechef(chef: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.APP_URL}/user/create/chef`, chef, { headers: this.requestHeader });
  }
  saveTech(tech: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.APP_URL}/user/create/tech`, tech, { headers: this.requestHeader });
  }
  saveprof(prof: Utilisateur): Observable<Utilisateur> {
    return this.http.post<Utilisateur>(`${this.APP_URL}/user/create/prof`, prof, { headers: this.requestHeader });
  }

  findById(userId: number): Observable<Utilisateur> {
    return this.http.get<Utilisateur>(`${this.APP_URL}/user/finduser/${userId}`)
  }

  /*upadte(userId: number, Utilisateur : Utilisateur): Observable<Utilisateur> {
    return this.http.put<Utilisateur>(`${this.APP_URL}/user`)c
  }*/



}
