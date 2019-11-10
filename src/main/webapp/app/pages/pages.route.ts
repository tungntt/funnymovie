import { sharingMovieRoute } from 'app/pages/sharing-movie/sharing-movie.route';
import { Routes } from '@angular/router';

const PAGES_ROUTES = [sharingMovieRoute];

export const pageState: Routes = [
  {
    path: '',
    children: PAGES_ROUTES
  }
];
