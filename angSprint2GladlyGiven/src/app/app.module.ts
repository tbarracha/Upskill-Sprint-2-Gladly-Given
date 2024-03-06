import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppHeaderComponent } from './components/mainAppComponents/mainComponents/app-header/app-header.component';
import { AppBodyComponent } from './components/mainAppComponents/mainComponents/app-body/app-body.component';
import { AppFooterComponent } from './components/mainAppComponents/mainComponents/app-footer/app-footer.component';
import { AppUserViewComponent } from './components/mainAppComponents/mainViews/app-user-view/app-user-view.component';
import { AppAdminViewComponent } from './components/mainAppComponents/mainViews/app-admin-view/app-admin-view.component';

@NgModule({
  declarations: [
    AppComponent,
    AppHeaderComponent,
    AppBodyComponent,
    AppFooterComponent,
    AppUserViewComponent,
    AppAdminViewComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
