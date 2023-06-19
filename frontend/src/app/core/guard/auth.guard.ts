import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const AuthGuard = (redirectRoute: string): CanActivateFn => {
  return () => {
    const router: Router = inject(Router)
    let token = localStorage.getItem("access_token")
    return token !== null ? true : router.createUrlTree([redirectRoute])
  }
};