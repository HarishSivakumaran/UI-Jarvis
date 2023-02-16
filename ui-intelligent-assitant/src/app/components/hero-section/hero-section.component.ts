import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-hero-section',
  templateUrl: './hero-section.component.html',
  styleUrls: ['./hero-section.component.scss']
})
export class HeroSectionComponent {
  projectDetails: FormGroup = new FormGroup({
    "name": new FormControl(null,[Validators.required]),
    "email": new FormControl(null, [Validators.email, Validators.required]),
    "project": new FormControl()
  })

  parseProject(oEvent: Event){
    console.log(this.projectDetails.value);
  }

}
