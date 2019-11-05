import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { FunnymovieSharedModule } from 'app/shared/shared.module';
import { FunnymovieCoreModule } from 'app/core/core.module';
import { FunnymovieAppRoutingModule } from './app-routing.module';
import { FunnymovieHomeModule } from './home/home.module';
import { FunnymovieEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { JhiMainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ActiveMenuDirective } from './layouts/navbar/active-menu.directive';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    FunnymovieSharedModule,
    FunnymovieCoreModule,
    FunnymovieHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    FunnymovieEntityModule,
    FunnymovieAppRoutingModule
  ],
  declarations: [JhiMainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, ActiveMenuDirective, FooterComponent],
  bootstrap: [JhiMainComponent]
})
export class FunnymovieAppModule {}
