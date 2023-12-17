import { Adresse } from "./adresse";
import { Roles } from "./roles";

export interface Utilisateur {
  id?: number;
  nom?: string;
  prenom?: string;
  numCin?: number;
  dateNaissance?: string;
  email?: string;
  password?: string;
  numTel?: string;
  adresse?: Adresse;
  roleSet?: Roles[] | Roles;

}
