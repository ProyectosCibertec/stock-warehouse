import { Component } from '@angular/core';
import { AuthService } from 'src/app/data/service/auth.service';

@Component({
  selector: 'app-content-layout',
  templateUrl: './content-layout.component.html',
  styleUrls: ['./content-layout.component.css']
})
export class ContentLayoutComponent {
  username = localStorage.getItem("logged_user")
  
  constructor(private auth: AuthService) { }

  logout() {
    this.auth.logout()
  }
}
