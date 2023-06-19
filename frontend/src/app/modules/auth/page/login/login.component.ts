import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AuthService } from 'src/app/data/service/auth.service';
import { Login } from 'src/app/data/schema/login';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });

  constructor(
    private fb: FormBuilder,
    private auth: AuthService
  ) { }

  login() {
    let req = new Login()
    req = Object.assign(req, this.loginForm.value)
    this.auth.login(req)
  }
}
