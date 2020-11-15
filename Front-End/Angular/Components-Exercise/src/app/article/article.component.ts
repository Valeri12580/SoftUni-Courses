import {Component, Input, OnInit} from '@angular/core';
import {Article} from '../models/article.model';

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  private symbols: number = 255;
  @Input() article: Article;
  @Input() articleDesc: String;


  descToShow: string;
  articleDescLen: number;
  showReadMoreBtn: boolean = true;
  showHideBtn: boolean = false;

  imageIsShown: boolean = false;
  imageButtonTitle: string = 'Show Image';

  constructor() {
    this.articleDescLen = 0;
    this.descToShow = '';
  }

  ngOnInit(): void {
  }

  readMore():void {
      this.showReadMoreBtn = false;
      this.showHideBtn = true;
      this.descToShow=this.articleDesc.substr(0,255);


  }

  toggleImage():void{
    this.imageIsShown=!this.imageIsShown;
    this.imageButtonTitle=this.imageButtonTitle==='Hide Image'?'Show Image':'Hide Image';
  }

  hideDesc(){
    this.descToShow='';
    this.showReadMoreBtn=true;
    this.showHideBtn=false;
  }

}
