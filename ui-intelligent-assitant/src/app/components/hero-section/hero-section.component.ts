import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OpaHandlerService } from 'src/app/services/opa-file-handler.service';

@Component({
  selector: 'app-hero-section',
  templateUrl: './hero-section.component.html',
  styleUrls: ['./hero-section.component.scss'],
})
export class HeroSectionComponent {
  project: File | null = null;
  projectDetails: FormGroup = new FormGroup({
    name: new FormControl(null, [Validators.required]),
    email_id: new FormControl(null, [Validators.email, Validators.required]),
    project_url: new FormControl(),
  });

  constructor(
    private OpaFileHandler: OpaHandlerService,
    private http: HttpClient
  ) {}

  parseProject(oEvent: Event) {
    this.OpaFileHandler = this.projectDetails.value.project;
    const formData = new FormData();
    Object.entries(this.projectDetails.value).forEach(
      ([key, value]: any[]) => {
        formData.set(key, value);
      }

      //submit the form using formData
      // if you are using nodejs use something like multer
    )
    formData.append('data', this.project);
    this.http
      .post('http://localhost:8080/upload', formData)
      .subscribe((message) => alert(message));
  }

  handleFileInput(oEvent: any) {
    this.project = oEvent.target.files[0];
  }
}
