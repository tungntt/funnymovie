import { Route } from '@angular/router';
import { SharingMovieComponent } from 'app/pages/sharing-movie/sharing-movie.component';

export const sharingMovieRoute: Route = {
  path: 'share',
  component: SharingMovieComponent,
  data: {
    authorities: [],
    pageTitle: 'share-movie.title'
  }
};
