import { NgModule } from '@angular/core';
import { FunnymovieSharedModule } from 'app/shared/shared.module';
import { RouterModule } from '@angular/router';
import { pageState } from 'app/pages/pages.route';
import { SharingMovieComponent } from 'app/pages/sharing-movie/sharing-movie.component';

@NgModule({
  imports: [FunnymovieSharedModule, RouterModule.forChild(pageState)],
  declarations: [SharingMovieComponent]
})
export class PagesModule {}
