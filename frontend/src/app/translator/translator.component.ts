import { Component, ElementRef, HostListener, ViewChild } from '@angular/core';
import axios from 'axios';
import { environment } from '../../environments/environment';
import qs from 'qs';

@Component({
  standalone: true,
  selector: 'app-translator',
  imports: [],
  templateUrl: './translator.component.html',
  styleUrl: './translator.component.scss'
})
export class TranslatorComponent {
  language: string = "";
  availableLanguages: string[] = [];
  private backendURL = environment.BACKEND_URL;
  textAreaRows = 5;
  @ViewChild("input_text") inputText!: ElementRef;
  @ViewChild("output_text") outputText!: ElementRef;
  @ViewChild("language_select") languageSelect!: ElementRef;


  constructor(){
    this.initializeLanguages();
  }

  initializeLanguages() : void{
    axios.get(this.backendURL + '/language/list')
    .then(((response : any) : void =>{
      this.availableLanguages = response.data;
    }).bind(this))
  }

  @HostListener('window:resize')
  onResize() : void{
    this.updateRows();
  }

  private updateRows(){
    this.textAreaRows = window.innerWidth < 768 ? 8 : 5;
  }

  translate() : void{
    console.log(this.languageSelect.nativeElement);
    axios.post(this.backendURL + '/translate', qs.stringify({
      language: this.languageSelect.nativeElement[this.languageSelect.nativeElement.selectedIndex].text,
      text: this.inputText.nativeElement.value,
      "AI_REPOSITORY": "GEMINI"
    }),{
      headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
    }).then(((response : any) : void =>{
      this.outputText.nativeElement.value = response.data;
    }).bind(this))
  }
}
