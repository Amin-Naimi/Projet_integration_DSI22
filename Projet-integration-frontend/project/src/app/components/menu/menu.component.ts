import { Component } from '@angular/core';
import { Menu } from './menu';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  public menuProperties: Array<Menu> = [
    {

      id: '1',
      titre: 'Tableau de Bord',
      icone: 'bi bi-shield-lock-fill',
      url: 'articles',
      sousMenus: [
        {
          id: '1.1',
          titre: 'Acceuil',
          icone: 'fas fa-boxes',
          url: 'statistique'
        }
      ]
    },
    {

      id: '2',
      titre: 'Administrateurs',
      icone: 'bi bi-shield-lock-fill',
      url: 'admintable',
      sousMenus: [
        {
          id: '2.1',
          titre: 'liste des Administrateurs',
          icone: 'fas fa-boxes',
          url: 'admintable'
        },
        {
          id: '2.2',
          titre: 'Ajouter un admin',
          icone: 'fab fa-stack-overflow',
          url: 'addadmin'
        }
      ]
    },
    {
      id: '3',
      titre: 'Departements',
      icone: 'bi bi-bank',
      url: '',
      sousMenus: [
        {
          id: '3.1',
          titre: 'liste des Departements',
          icone: 'fas fa-users',
          url: 'client'
        }
      ]
    },
    {
      id: '4',
      titre: 'Chef De departement',
      icone: 'bi bi-people-fill',
      url: 'fournisseurs',
      sousMenus: [
        {
          id: '4.1',
          titre: 'List Chef De departement',
          icone: 'fas fa-users',
          url: 'chefdepartemnttable'
        },
        {
          id: '4.2',
          titre: 'Ajouter chef departement',
          icone: 'fas fa-truck',
          url: 'addchefdepartemnt'
        }
      ]
    },
    {
      id: '5',
      titre: 'Techniciens',
      icone: 'bi bi-wrench',
      url: '',
      sousMenus: [
        {
          id: '5.1',
          titre: 'Liste Techniciens',
          icone: 'fas fa-tools',
          url: 'techtable'
        },
        {
          id: '5.2',
          titre: 'Ajouter Technicien',
          icone: 'fas fa-users-cog',
          url: 'addtechn'
        }
      ]
    },
    {
      id: '6',
      titre: 'Professeurs',
      icone: 'bi bi-person-square',
      url: '',
      sousMenus: [
        {
          id: '6.1',
          titre: 'Liste Professeurs',
          icone: 'fas fa-tools',
          url: 'profftable'
        },
        {
          id: '6.2',
          titre: 'Ajouter Professeurs',
          icone: 'fas fa-users-cog',
          url: 'addprof'
        }
      ]
    }
  ];

  private lastSelectedMenu: Menu | undefined;
  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  navigate(menu: Menu): void {
    if (this.lastSelectedMenu) {
      this.lastSelectedMenu.active = false;
    }
    menu.active = true;
    this.lastSelectedMenu = menu;
    this.router.navigate([menu.url]);
  }

}
