import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OpaHandlerService } from 'src/app/services/opa-file-handler.service';

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
  });

  constructor(private OpaFileHandler: OpaHandlerService){}

  parseProject(oEvent: Event){
    this.OpaFileHandler = this.projectDetails.value.project;
    console.log(this.projectDetails.value);
  }

}
