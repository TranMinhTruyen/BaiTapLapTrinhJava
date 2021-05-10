import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-timkiem',
  templateUrl: './timkiem.component.html',
  styleUrls: ['./timkiem.component.css']
})
export class TimkiemComponent implements OnInit {
  data: any={
    "apiString": 1,
  }
  search: any ={
    "keyWord": "",
  }

  constructor() { }

  ngOnInit(): void {
  }
  searchNow(){
    console.log("keyword: " +this.search.keyWord);
    console.log("api: " +this.data.apiString);
  }

}
