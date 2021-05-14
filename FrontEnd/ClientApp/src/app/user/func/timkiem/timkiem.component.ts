import { Component, OnInit } from '@angular/core';
import { ToastrService} from 'ngx-toastr';

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

  constructor(private toastr: ToastrService) { }

  ngOnInit(): void {
  }
  searchNow(){
    console.log("keyword: " +this.search.keyWord);
    console.log("api: " +this.data.apiString);
    this.toastr.error('Lỗi null','Có gì đó không ổn !!!');
    this.toastr.info('Hãy kiểm tra lại dữ liệu !!!');
  }

}
