import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { HeroSectionComponent } from "./components/hero-section/hero-section.component";
import { HivePageComponent } from "./components/hive-page/hive-page.component";

const routes: Routes = [
  {path:'intellicode', component: HeroSectionComponent},
  {path:'hive', component: HivePageComponent},
  {path:'**', redirectTo: 'intellicode'},
]

@NgModule({
  imports:[RouterModule.forRoot(routes)],
  exports:[RouterModule]
})

export class AppRoutingModule{

}
