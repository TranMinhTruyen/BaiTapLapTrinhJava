import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { NiceSelectModule } from "ng-nice-select";
import { FormGroup, FormControl, Validator, Validators } from '@angular/forms';

@Component({
  selector: 'app-dattiec',
  templateUrl: './dattiec.component.html',
  styleUrls: ['./dattiec.component.css']
})
export class DattiecComponent implements OnInit {
  form = new FormGroup({
    ngayToChuc: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
    thoiGian: new FormControl('', [Validators.required,Validators.minLength(8), Validators.maxLength(8)]),
    sanh: new FormControl('', [Validators.required]),
    loai: new FormControl('', [Validators.required]),
    menu: new FormControl('', [Validators.required]),
  })
  data: any = {
    "id": 0,
    "thoiGian": "",
    "ngayToChuc": "",
    "loai": "",
    "sanh": 0,
    "khachHang": 0,
    "trangThai": "",
    "caLamViec": 0,
    "menu": 0,
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
    console.log(this.sanh);
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
    this.data.trangThai = "??ang Chu???n B???";
    this.data.caLamViec = "3";
    console.log(this.data.loai);
    console.log(this.data.menu);
    console.log(this.data.sanh);
    // console.log(this.data.khachHang);
    // console.log(this.data.trangThai);
    // console.log(this.data.menu);
    // console.log(this.data.thoiGian);
    // console.log(this.data.ngayToChuc);
    this.http.post("http://localhost:8080/api/tiec/createTiec", this.data).subscribe(
      result => {
        let res: any = result;
        console.log(res);
        this.toastr.success('B???n s??? ???????c chuy???n h?????ng trong d??y l??t', 'T???o ti???c th??nh c??ng');
        this.router.navigate(['/user/quanlytiec']);
      },
      error => {
        this.toastr.error('Xin vui l??ng t???o l???i', 'C?? g?? ???? kh??ng ???n !!!');
        this.toastr.info('H??y ki???m tra l???i d??? li???u b???n ???? nh???p');
        console.error(error);
      }
    )

  }

}
