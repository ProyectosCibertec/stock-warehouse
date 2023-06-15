import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../schema/login';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url = 'http://localhost:8080';

  constructor(private http: HttpClient, private router: Router) { }

  login(login: Login) {
    return this.http.post(this.url + '/login', login).subscribe((res: any) => {
      localStorage.setItem("access_token", res.token)
      localStorage.setItem("logged_user", login.username as string)
      this.router.navigate(['empleado'])
    })
  }

  register(register: any) {
    return this.http.post(this.url + '/register', register)
  }

  getToken() {
    return localStorage.getItem("access_token")
  }

  logout() {
    localStorage.removeItem("access_token")
    localStorage.removeItem("logged_user")
    this.router.navigate(['/auth/login'])
  }
}
