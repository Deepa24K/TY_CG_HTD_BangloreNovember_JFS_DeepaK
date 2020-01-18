import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-data-from-json',
  templateUrl: './data-from-json.component.html',
  styleUrls: ['./data-from-json.component.css']
})
export class DataFromJsonComponent implements OnInit {

  Products: Products[];

  constructor(private http: HttpClient) {
    this.getDataFromJSON();
   }

   getDataFromJSON() {
    this.http.get<Products[]>('../../assets/Products.json').subscribe(response => {
      console.log(response);
      this.Products = response;
    });
   }

  ngOnInit() {
  }
}
