
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NiceSelectModule } from "ng-nice-select";

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
  data: any = {
    "id": 0,
    "noiDung": "",
    "idTiec": 0,
    "idKhachHang": 0
  }
  tiec: any = {
    "id": "",
    "tenSanh": '',
  };

  constructor(
    private http: HttpClient,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    this.getTiec(5, 1);
  }
  getTiec(size: number, page: number) {
    this.http.get<any>('http://localhost:8080/api/tiec/getAllTiec/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.tiec = response;
      }
    );
  };
  phanHoi() {
    this.data.idKhachHang = localStorage.getItem("idKhachHang");
    console.log("Nội Dung: "+this.data.noiDung);
    console.log("ID Tiệc: "+this.data.idTiec);
    console.log("ID Khách Hàng: "+this.data.idKhachHang);

    // console.log(this.data.thoiGian);
    // console.log(this.data.ngayToChuc);
    this.http.post("http://localhost:8080/api/phanhoi/createPhanHoi", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát', 'Cảm ơn vì đã phàn nàn');
        this.router.navigate(['/user']);
      },
      error => {
        this.toastr.error('Xin vui lòng thử lại', 'Có gì đó không ổn !!!');
        this.toastr.info('Hãy kiểm tra lại dữ liệu bạn đã nhập');
        console.error(error);
      }
    )

  }

}
