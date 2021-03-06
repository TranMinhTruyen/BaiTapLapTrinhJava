import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NiceSelectModule } from "ng-nice-select";

@Component({
  selector: 'app-dattiec',
  templateUrl: './dattiec.component.html',
  styleUrls: ['./dattiec.component.css']
})
export class DattiecComponent implements OnInit {
  data: any = {

    "thoiGian": "",
    "ngayToChuc": "",
    "loai": "",
    "sanh": "",
    "khachHang": "",
    "trangThai": "",
    "caLamViec": "",
    "menu": ""
  };
  menu: any={
    "id": "",
    "tenMenu": "",
  };
  sanh: any={
    "id": "",
    "tenSanh": '',
  };

  constructor(
    private http: HttpClient,
    private router: Router,
    private toastr: ToastrService
  ) { }

  ngOnInit(): void {
    if(localStorage.getItem("taiKhoanKhachHang") == null){
      this.router.navigate(['/user/']);
    }
    this.getMenu(5,1);
    this.getSanh(5,1);
  }
  getMenu(size: number, page: number) {
    this.http.get<any>('http://localhost:8080/api/menu/getAllMenu/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.menu = response;
      }
    );
  };
  getSanh(size: number, page: number) {
    this.http.get<any>('http://localhost:8080/api/sanh/getAllSanh/?page=' + page + '&size=' + size + '').subscribe(
      response => {
        console.log(response);
        this.sanh = response;
      }
    );
  };

  datTiec() {
    this.data.khachHang = localStorage.getItem("idKhachHang");
    //this.data.khachHang = "3";
    this.data.trangThai = "Đang Chuẩn Bị";
    this.data.caLamViec = "3";
    // console.log(this.data.loai);
    // console.log(this.data.khachHang);
    // console.log(this.data.trangThai);
    // console.log(this.data.menu);
    console.log(this.data.sanh);
    // console.log(this.data.thoiGian);
    // console.log(this.data.ngayToChuc);
    this.http.post("http://localhost:8080/api/tiec/createTiec", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('Bạn sẽ được chuyển hướng trong dây lát', 'Tạo tiệc thành công');
        this.router.navigate(['/user/quanlytiec']);
      },
      error => {
        this.toastr.error('Xin vui lòng tạo lại', 'Có gì đó không ổn !!!');
        this.toastr.info('Hãy kiểm tra lại dữ liệu bạn đã nhập');
        console.error(error);
      }
    )

  }

}
